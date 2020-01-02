package com.wd.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerDemo {

    private static String brokerList = "117.48.214.21:20001,117.48.214.21:20002,117.48.214.21:20003";
    private static String topic = "test";

    public static Properties initConfig(){
        Properties prop = new Properties();
//        prop.put("bootstrap.servers",brokerList);
//        prop.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
//        prop.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
//        prop.put("client.id","producer.client.id.demo");

        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        prop.put(ProducerConfig.CLIENT_ID_CONFIG,"producer.client.id.demo");
        return prop;
    }

    public static void main(String[] arg0){
        Properties config = initConfig();
        KafkaProducer<String,String> producer = new KafkaProducer(config);
        ProducerRecord<String,String> record = new ProducerRecord(topic,"hello,kafka");
        try{
//            producer.send(record, new Callback() {
//                @Override
//                public void onCompletion(RecordMetadata metadata, Exception exception) {
//                    if(exception == null){
//                        System.out.println(metadata);
//                    }else{
//                        exception.printStackTrace();
//                    }
//                }
//            });

            RecordMetadata metadata = producer.send(record).get();
            System.out.println(metadata);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
