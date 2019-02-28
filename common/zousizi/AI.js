//棋盘初始状态
var board = [ 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2 ];
// 当前要走的棋子
var currentPiece = 1;

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
function waysGenerator(board) {

	if (currentPiece == shiorhu) {
		for (var i = 0; i < board.length; i++) {
			if (board[i] == shiorhu) {
				if (i > 3 && board[i - 4] == 0) {
					move(i, i - 4, board, shiorhu);
				}
				if (i < 12 && board[i + 4] == 0) {
					move(i, i + 4, board, shiorhu);
				}
				if (i % 4 != 0 && board[i - 1] == 0) {
					move(i, i - 1, board, shiorhu);
				}
				if (i % 4 != 3 && board[i + 1] == 0) {
					move(i, i + 1, board, shiorhu);
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
function move(index, target, board, shiorhu) {
	board[index] = 0;
	board[target] = shiorhu;
	col = (index - 4) % 4 + 1;
	row = (index - 4) / 4 + 1;
	var ways = [ "1243", "2143", "2314", "2341", "3412", "3241", "3214", "4312" ];
	for (var i = 0; i < ways.length; i++) {
		var way = ways[i];
		var a = way.substr(0, 1);
		var b = way.substr(1, 1);
		var c = way.substr(2, 1);
		var d = way.substr(3, 1);
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
	return board;
}
/**
 * 局面评价函数
 * 
 */
function evaluate() {
	var temp0 = 0;
	for (var i = 0; i < board.length; i++) {
		if (board[i] == 1) {
			temp0++;
		} else if (board[i] == 1) {
			temp0--;
		}
	}
	return temp0;
}

/**
 * Alpha-Beta搜索
 * 
 */
function AlphaBeta(board, vlAlpha, vlBeta, nDepth) {
	if (nDepth == 0) {
		return evaluate();// 返回局面评价函数
	}
	var ways = waysGenerator(board);// 生成全部走法;
	// 按历史表排序全部走法;
	for (var i = 0; i < ways.length; i++) {
		// 走这个走法;
		if (true) {
			// 撤消这个走法;
		} else {
			int
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
		return vlAlpha;
	}
}