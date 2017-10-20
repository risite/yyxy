package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class test {
	
	@Test
	public void test(){
		//棋盘初始状态
		Integer[] board = { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1 };
//		Integer[] board = { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2};
		AlphaBeta(board, -3,3,3);
		int x=0;
		ArrayList list = (ArrayList) map.get(1);
		for(int i=0;i<list.size();i++){
			System.out.println(i+1);
			printArray((Integer[]) list.get(i));
		}
//		System.out.prIntegerln("1324".substring(3,4));
	}
	
	// 当前要走的棋子
	public Integer shiorhu = 1;
	//所有步骤
	Map map = new HashMap();
	

	/**
	 * 走法生成器
	 * 
	 * 判断当前等于1或2
	 * 
	 * 遍历当前状态数组的每一个数值（棋盘的每一个位置）
	 * 
	 * 如果等于1，判断上下左右是否等于0 等于0的变为1，当前数值变为0，再判断某个2是否变0
	 * 
	 * 如果等于2，判断上下左右是否等于0 等于0的变为2，当前数值变为0，再判断某个1是否变0
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
	 * 移动子，并且考虑是否需要去子，同杀子规则
	 * 
	 * params: index，原数组索引，target，目标位置索引，board，当前状态数组
	 * 
	 * col,移动到了第几列 row,移动到了第几排 shiorhu，移动的哪方
	 * 
	 * 四个数字分别表示： a，移到了第几排 b，相邻的是己方的棋子 c，最远的边上没子 d，要杀的子是对方的
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
	 * 局面评价函数
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
	 * Alpha-Beta搜索
	 * 
	 */
	public Integer AlphaBeta(Integer[] board1, int vlAlpha, int vlBeta, int nDepth) {
		Integer[] board0 = new Integer[16];
		for(int i = 0;i<16;i++){
			board0[i] = board1[i];
		}
		if (nDepth == 0) {
			return evaluate(board0);// 返回局面评价函数
		}
		waysGenerator(board0,nDepth);// 生成全部走法;
		ArrayList<Integer[]> arraylist = (ArrayList) map.get(nDepth);
		// 按历史表排序全部走法;
		for (Integer i = 0; i < arraylist.size(); i++) {
			
			Integer[] board = arraylist.get(i);
			Integer vl= -AlphaBeta(board, -vlBeta, -vlAlpha, nDepth - 1);
			// 撤消这个走法;
			if (vl >= vlBeta) {
				// 将这个走法记录到历史表中;
				return vlBeta;
			}
			if (vl > vlAlpha) {
				// 设置最佳走法;
				vlAlpha = vl;
			}
//			System.out.println(i+1);
//			printArray(arraylist.get(i));
			
			/*// 走这个走法;
			if (true) {
				// 撤消这个走法;
			} else {
				Integer
				vl = -AlphaBeta(-vlBeta, -vlAlpha, nDepth - 1);
				// 撤消这个走法;
				if (vl >= vlBeta) {
					// 将这个走法记录到历史表中;
					return vlBeta;
				}
				if (vl > vlAlpha) {
					// 设置最佳走法;
					vlAlpha = vl;
				}
			}

			// if (没有走过任何走法) {
			// return 杀棋的分数;
			// }
			// 将最佳走法记录到历史表中;
			// if (根节点) {
			// 最佳走法就是电脑要走的棋;
			// }
			return vlAlpha;*/
		}
		System.out.println(vlAlpha);
		return vlAlpha;
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
	
	public void printArray(Integer[] temp){
		System.out.println("**************");
		System.out.println("* "+temp[0]+", "+temp[1]+", "+temp[2]+", "+temp[3]+" *");
		System.out.println("* "+temp[4]+", "+temp[5]+", "+temp[6]+", "+temp[7]+" *");
		System.out.println("* "+temp[8]+", "+temp[9]+", "+temp[10]+", "+temp[11]+" *");
		System.out.println("* "+temp[12]+", "+temp[13]+", "+temp[14]+", "+temp[15]+" *");
		System.out.println("**************");
	}
}