package com.wd.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//注释1
public class BlockObject {
	
	private final Lock lock = new ReentrantLock();
	
	private Condition c = lock.newCondition();
	
	private String resMsg = "test1";
	
	public String getResMsg() throws InterruptedException {
		System.out.println("开始阻塞：resMsg=" + resMsg);
		lock.lock();
		c.await();
		lock.unlock();
		return resMsg;
	}

	protected void awaken() {
		System.out.println("结束阻塞：resMsg=" + resMsg);
		lock.lock();
		c.signal();
		lock.unlock();
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
}
