package com.yitianyigexiangfa.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysTest {
	
	@Test(timeout=100)
	public void testPerformance(){
		for(int i = 0; i < 1000000; i++){
			Arrays.sort(new int[]{i, i - 1, i + 1});
		}
	}
	
	@Test
	public void testArraysSort(){
		int[] ary1 = new int[]{10, 2, 3, 8, 7, 9};
		Arrays.sort(ary1);
		assertArrayEquals(new int[]{
				2, 3, 7, 8, 9, 10
		}, ary1);
	}
}
