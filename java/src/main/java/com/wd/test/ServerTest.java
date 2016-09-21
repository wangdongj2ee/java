package com.wd.test;

public class ServerTest {
	
	public static void main(String[] args) {
		BlockObject b = Const.cache.get("b");
		b.setResMsg("aaaaaaaaaaa");
		b.awaken();
	}
}
