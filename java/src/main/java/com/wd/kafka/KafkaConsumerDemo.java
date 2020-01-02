package com.wd.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public class KafkaConsumerDemo {

    private static String brokerList = "117.48.214.21:20001,117.48.214.21:20002,117.48.214.21:20003";
    private static String topic = "test";
    private static String groupId = "group.demo";

    public static final AtomicBoolean isRunning = new AtomicBoolean(true);

    public static Properties initConfig(){
        Properties prop = new Properties();
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        //org.apache.kafka.common.serialization.StringDeserializer
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        prop.put(ConsumerConfig.CLIENT_ID_CONFIG,"producer.client.id.demo");
        prop.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        return prop;
    }

    public static void main(String[] arg0){
        Properties props = initConfig();
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
        while (isRunning.get()){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String,String> record : records){
                System.out.println("record:"+record);
                System.out.println("value:"+record.value()+";offset:"+record.offset());
            }
        }
    }
}
