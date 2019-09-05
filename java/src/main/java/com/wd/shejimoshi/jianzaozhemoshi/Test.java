package com.wd.shejimoshi.jianzaozhemoshi;

/**
 * 测试类
 */

public class Test {

    public static void main(String[] arg0){
        ISetMealBuilder setMealABuilder = new SetMealABuilder();
        KFCDirector kfcADirector = new KFCDirector(setMealABuilder);
        System.out.println(kfcADirector.buildSetMealProduct());

        ISetMealBuilder setMealBBuilder = new SetMealBBuilder();
        KFCDirector kfcBDirector = new KFCDirector(setMealBBuilder);
        System.out.println(kfcBDirector.buildSetMealProduct());
    }
}
