package com.wd.shejimoshi.jianzaozhemoshi;

/**
 * 创建指挥者
 */

public class KFCDirector {

    private ISetMealBuilder setMealBuilder;

    public KFCDirector(ISetMealBuilder setMealBuilder){
        this.setMealBuilder = setMealBuilder;
    }

    public SetMealProduct buildSetMealProduct(){
        setMealBuilder.buildFoot();
        setMealBuilder.buildDrink();
        return setMealBuilder.getSetMealProduct();
    }
}
