package com.risite.qg.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pickCoin {
    //	@Test
    public void test() {
        // nums[1][0][0]=1;
        // nums[0][1][0]=1;
        // nums[0][0][1]=1;
        // System.out.println(Arrays.toString(nums));
        list.add(1);
        list.add(10);
        list.add(100);
        list.add(1000);
        step();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    List<Integer> list = new ArrayList<Integer>();
    public void step() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 5; j++) {
                for (int k = 0; k <= 7; k++) {
                    for (int k1 = 0; k1 <= 9; k1++) {
                        int a = i * 1000 + j * 100 + k * 10 + k1;
                        boolean judge = true;
                        for (int k2 = 0; k2 < list.size(); k2++) {
                            int b = list.get(k2);
                            int temp = 0;
                            if (i == b / 1000) {
                                temp++;
                            }
                            if (j == b / 100 % 10) {
                                temp++;
                            }
                            if (k == b / 10 % 10) {
                                temp++;
                            }
                            if (k1 == b % 10) {
                                temp++;
                            }
                            if (temp > 2) {
                                judge = false;
                                continue;
                            }
                        }
                        if (judge) {
                            list.add(a);
                        }
                    }
                }
            }
        }
    }

    Integer[] board1 = {356, 347, 330, 321, 312, 303, 257, 246, 231, 220, 213,
            202, 154, 145, 132, 123, 111, 100, 55, 44, 33, 22, 10, 1};
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
        /**
         * 百位数：integer/100
         *
         * 十位数：integer/10%10
         *
         * 个位数：integer%10
         */
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
                if ((integer - i) % 100 == 0 // 百位不同
                        || (integer / 100 == i / 100 && integer % 10 == i % 10)// 十位不同
                        || i / 10 == integer / 10) {// 个位不同
                    return integer - i;
                }
            }
        }
        return 0;
    }
}
