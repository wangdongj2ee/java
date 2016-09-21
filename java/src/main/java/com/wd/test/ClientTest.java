package com.wd.test;


public class ClientTest {

	public static void main(String[] args) {
		new Thread(new Test1()).start();
		new Thread(new Test2()).start();
	}
}

class Test1 implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		BlockObject b =  new BlockObject();
		Const.cache.put("b", b);
		try {
			System.out.println(b.getResMsg());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Test2 implements Runnable {
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BlockObject b = Const.cache.get("b");
		if(b!=null){
			b.setResMsg("ssssssssssss");
			b.awaken();
		}
	}
}
