package com.wd.shejimoshi.qiaojiemoshi;

public abstract class Pen {

    private Color color;

//    public Pen(Color color){
//        this.color = color;
//    }

    public Pen(){

    }

    public Pen(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(String name);
}
