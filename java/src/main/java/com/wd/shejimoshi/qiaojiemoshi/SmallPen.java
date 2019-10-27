package com.wd.shejimoshi.qiaojiemoshi;

public class SmallPen extends Pen{
    @Override
    public void draw(String name) {
        String penType = "小号毛笔";
        this.getColor().bepaint(penType,name);
    }
}
