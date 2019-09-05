package com.wd.shejimoshi.jianzaozhemoshi;

/**
 * 套餐产品类
 */

public class SetMealProduct {

    /**
     * 食物
     */
    private String foot;

    /**
     * 饮料
     */
    private String drink;

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "SetMealProduct{" +
                "foot='" + foot + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}
