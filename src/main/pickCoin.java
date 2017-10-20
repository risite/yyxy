package main;

import java.util.Arrays;

import org.junit.Test;

public class pickCoin {
	@Test
	public void test() {
		pick(152);
	}

	/**
	 * ÄÃÓ²±Ò
	 */
	public void pick(int temp) {
		// ÆåÅÌ³õÊ¼×´Ì¬
		Integer[] board = { 312, 321, 330, 347, 356, 303, 257, 246, 231, 220,
				213, 202, 154, 145, 132, 123, 111 };
		Arrays.sort(board);
		for (int i : board) {
			if(i<=temp){
				System.out.println(temp-i);
				break;
			}
		}
	}
}
