package com.wd.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Const {

	public static ConcurrentMap<String, BlockObject> cache = new ConcurrentHashMap<String, BlockObject>();
}
