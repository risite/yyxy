package main;

import java.util.Arrays;

import org.junit.Test;

public class pickCoin {
	@Test
	public void test() {
		System.out.println(Arrays.toString(pick(123)));
	}

	Integer[] board1 = { 356, 347, 330, 321, 312, 303, 257, 246, 231, 220, 213, 202, 154, 145, 132, 123, 111, 55, 44,
			33, 22 };

	/**
	 * 拿硬币
	 */
	public int[] pick(int temp) {
		int num = matchNumber(temp);
		int[] int0 = new int[2];
		if (num >= 100) {
			int0[0] = 1;
			int0[1] = num / 100;
		} else if (num >= 10) {
			int0[0] = 2;
			int0[1] = num / 10;
		} else {
			int0[0] = 3;
			int0[1] = num;
		}
		return int0;
	}

	public int matchNumber(Integer integer) {

		//只有一排有
		if (integer%100==0&&integer!=100) {
			return integer-100;
		}else
		if (integer%10==0&&integer>10&&100>integer) {
			return integer-10;
		}else if (integer<10&&integer>1) {
			return integer-1;
		}
		/**
		 * 百位数：integer/100
		 * 
		 * 十位数：integer/10%10
		 * 
		 * 个位数：integer%10
		 */

		// *10 or *01
		if ((integer % 10 == 0 && integer / 10 % 10 == 1) || (integer % 10 == 1 && integer / 10 % 10 == 0)) {
			return integer / 100 * 100;
		}
		// 1*0 or 0*1
		if ((integer / 100 == 1 && integer % 10 == 0) || (integer / 100 == 0 && integer % 10 == 1)) {
			return (integer / 10 % 10) * 10;
		}
		// 10* or 01*
		if ((integer / 100 == 1 & integer / 10 % 10 == 0) || (integer / 100 == 0 && integer / 10 % 10 == 1)) {
			return integer % 10;
		}

		// 逐一对照，返回差数
		for (int i : board1) {
			if (integer == i) {
				if (i / 100 != 0) {
					return 100;
				} else {
					return 10;
				}
			}
			if (integer > i) {
				if ((integer - i) % 100 == 0 || ((integer - i) % 10 == 0 && (integer - i) / 10 < 10)
						|| i / 10 == integer / 10) {
					return integer - i;
				}
			}
		}
		return 0;
	}
}
