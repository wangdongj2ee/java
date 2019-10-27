package com.wd.shejimoshi.qiaojiemoshi;

public class Test {

    public static void main(String[] arg0){
        Color redColor = new Red();
        Pen pen = new BigPen();
        pen.setColor(redColor);
        pen.draw("鲜花");
    }
}
