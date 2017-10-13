package main;

import java.util.Arrays;

public class test {
	
	public static void main(String[] args) {
		System.out.print(Arrays.toString(getFibonacci(30)));
	}

	//求斐波那契数列
	public static long[] getFibonacci(int len) {
		long[] array = new long[len];
		array[0] = 1;
		array[1] = 1;
		long x = 1;
		long y = 1;
		long z;
		for (int i = 2; i < len; i++) {
			array[i] = x + y;
			z = y;
			y = x + y;
			x = z;
		}
		return array;
	}
}