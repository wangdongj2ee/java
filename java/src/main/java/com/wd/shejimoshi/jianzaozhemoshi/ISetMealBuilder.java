package com.wd.shejimoshi.jianzaozhemoshi;

/**
 * 套餐创建类
 */

public abstract class ISetMealBuilder {

    SetMealProduct setMealProduct = new SetMealProduct();

    abstract void buildFoot();

    abstract void buildDrink();

    public SetMealProduct getSetMealProduct(){
        return setMealProduct;
    }
}
