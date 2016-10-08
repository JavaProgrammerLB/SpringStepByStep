package com.yitianyigexiangfa.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public MapTest() {
	}

	public static void main(String[] args) {
		Map<Integer, String> id2name = new HashMap<Integer, String>();
		id2name.put(1, "liubei");
		id2name.put(2, "yuanmengchen");
		id2name.put(3, "zuoguofeng");
		id2name.put(4, "wangpingxin");
		id2name.put(5, "wuxiong");
		id2name.put(6, "licheng");
		Set<Integer> idkeySet = id2name.keySet();
		for (Integer i : idkeySet) {
			System.out.println("key: " + i + " value: " + id2name.get(i));
		}
	}

}
