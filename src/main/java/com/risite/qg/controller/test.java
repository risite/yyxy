package com.risite.qg.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//import org.junit.Test;

public class test {
	
//	@Test
	public void test(){
		//���̳�ʼ״̬
//		Integer[] board = { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1 };
//		Integer[] board = { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2};
//		AlphaBeta(board, -3,3,3);
//		int x=0;
//		ArrayList list = (ArrayList) map.get(1);
//		for(int i=0;i<list.size();i++){
//			System.out.println(i+1);
//			printArray((Integer[]) list.get(i));
//		}
//		System.out.prIntegerln("1324".substring(3,4));
//		System.out.println(Arrays.toString(getFibonacci(20)));
		String s = "123";
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
	
	// ��ǰҪ�ߵ�����
	public Integer shiorhu = 1;
	//���в���
	Map map = new HashMap();
	
	public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
	/**
	 * �߷�������
	 * 
	 * �жϵ�ǰ����1��2
	 * 
	 * ������ǰ״̬�����ÿһ����ֵ�����̵�ÿһ��λ�ã�
	 * 
	 * �������1���ж����������Ƿ����0 ����0�ı�Ϊ1����ǰ��ֵ��Ϊ0�����ж�ĳ��2�Ƿ��0
	 * 
	 * �������2���ж����������Ƿ����0 ����0�ı�Ϊ2����ǰ��ֵ��Ϊ0�����ж�ĳ��1�Ƿ��0
	 */
	public void waysGenerator(Integer[] board0,int Depth) {
		shiorhu = Depth%2!=1?1:-1;
		Integer[] board = new Integer[16];
		for(int i = 0;i<16;i++){
			board[i] = board0[i];
		}

		if (true) {
			for (Integer i = 0; i < board.length; i++) {
				if (board[i] == shiorhu) {
					if (i > 3 && board[i - 4] == 0) {
						move(i, i - 4, board, shiorhu,Depth);
					}
					if (i < 12 && board[i + 4] == 0) {
						move(i, i + 4, board, shiorhu,Depth);
					}
					if (i % 4 != 0 && board[i - 1] == 0) {
						move(i, i - 1, board, shiorhu,Depth);
					}
					if (i % 4 != 3 && board[i + 1] == 0) {
						move(i, i + 1, board, shiorhu,Depth);
					}
				}
			}
		}
	}
	/**
	 * �ƶ��ӣ����ҿ����Ƿ���Ҫȥ�ӣ�ͬɱ�ӹ���
	 * 
	 * params: index��ԭ����������target��Ŀ��λ��������board����ǰ״̬����
	 * 
	 * col,�ƶ����˵ڼ��� row,�ƶ����˵ڼ��� shiorhu���ƶ����ķ�
	 * 
	 * �ĸ����ֱַ��ʾ�� a���Ƶ��˵ڼ��� b�����ڵ��Ǽ��������� c����Զ�ı���û�� d��Ҫɱ�����ǶԷ���
	 */
	public void move(Integer index, Integer target, Integer[] board0, Integer shiorhu,int Depth) {
		ArrayList<Integer[]> arraylist = (ArrayList<Integer[]>) map.get(Depth);
		if(arraylist==null||arraylist.size()<0){
			arraylist = new ArrayList();
			map.put(Depth, arraylist);
		}
		
		Integer[] board = new Integer[16];
		for(int i = 0;i<16;i++){
			board[i] = board0[i];
		}

		board[index] = 0;
		board[target] = shiorhu;
		Integer col = target % 4 + 1;
		Integer row = target / 4 + 1;
		String[] ways = { "1243", "2143", "2314", "2341", "3412", "3241", "3214", "4312" };
		for (Integer i = 0; i < ways.length; i++) {
			String way = ways[i];
			Integer a = Integer.parseInt(way.substring(0, 1));
			Integer b = Integer.parseInt(way.substring(1, 2));
			Integer c = Integer.parseInt(way.substring(2, 3));
			Integer d = Integer.parseInt(way.substring(3, 4));
			if (col == a && board[4 * row + b - 5] == shiorhu
					&& board[4 * row + c - 5] == 0 && board[4 * row + d - 5] != 0
					&& board[4 * row + d - 5] != shiorhu) {
				board[4 * row + d - 5] = 0;
			}
			if (row == a && board[4 * b + col - 5] == shiorhu
					&& board[4 * c + col - 5] == 0 && board[4 * d + col - 5] != 0
					&& board[4 * d + col - 5] != shiorhu) {
				board[4 * d + col - 5] = 0;
			}
		}
		arraylist.add(board);
	}
	/**
	 * �������ۺ���
	 * 
	 */
	public Integer evaluate(Integer[] board) {
		Integer temp0 = 0;
		for (Integer i = 0; i < board.length; i++) {
			if (board[i] == 1) {
				temp0++;
			} else if (board[i] == -1) {
				temp0--;
			}
		}
		return temp0;
	}

	/**
	 * Alpha-Beta����
	 * 
	 */
	public Integer AlphaBeta(Integer[] board1, int vlAlpha, int vlBeta, int nDepth) {
		Integer[] board0 = new Integer[16];
		for(int i = 0;i<16;i++){
			board0[i] = board1[i];
		}
		if (nDepth == 0) {
			return evaluate(board0);// ���ؾ������ۺ���
		}
		waysGenerator(board0,nDepth);// ����ȫ���߷�;
		ArrayList<Integer[]> arraylist = (ArrayList) map.get(nDepth);
		// ����ʷ������ȫ���߷�;
		for (Integer i = 0; i < arraylist.size(); i++) {
			
			Integer[] board = arraylist.get(i);
			Integer vl= -AlphaBeta(board, -vlBeta, -vlAlpha, nDepth - 1);
			// ��������߷�;
			if (vl >= vlBeta) {
				// ������߷���¼����ʷ����;
				return vlBeta;
			}
			if (vl > vlAlpha) {
				// ��������߷�;
				vlAlpha = vl;
			}
//			System.out.println(i+1);
//			printArray(arraylist.get(i));
			
			/*// ������߷�;
			if (true) {
				// ��������߷�;
			} else {
				Integer
				vl = -AlphaBeta(-vlBeta, -vlAlpha, nDepth - 1);
				// ��������߷�;
				if (vl >= vlBeta) {
					// ������߷���¼����ʷ����;
					return vlBeta;
				}
				if (vl > vlAlpha) {
					// ��������߷�;
					vlAlpha = vl;
				}
			}

			// if (û���߹��κ��߷�) {
			// return ɱ��ķ���;
			// }
			// ������߷���¼����ʷ����;
			// if (���ڵ�) {
			// ����߷����ǵ���Ҫ�ߵ���;
			// }
			return vlAlpha;*/
		}
		System.out.println(vlAlpha);
		return vlAlpha;
	}
	
	//��쳲���������
	public static long[] getFibonacci(int len) {
		long[] array = new long[len];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i < len; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array;
	}
	
	public void printArray(Integer[] temp){
		System.out.println("**************");
		System.out.println("* "+temp[0]+", "+temp[1]+", "+temp[2]+", "+temp[3]+" *");
		System.out.println("* "+temp[4]+", "+temp[5]+", "+temp[6]+", "+temp[7]+" *");
		System.out.println("* "+temp[8]+", "+temp[9]+", "+temp[10]+", "+temp[11]+" *");
		System.out.println("* "+temp[12]+", "+temp[13]+", "+temp[14]+", "+temp[15]+" *");
		System.out.println("**************");
	}
}