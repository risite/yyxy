var state = 3579;// 当前局面状态
var countLeft = 1;// 放左边总数
var countRight = 1;// 放右边总数
var rightVal;// 向左平移值
var bottomVal;// 向上平移值
var board = [];// 必赢着法对照表
var pieces = [ 49, 48, 47, 46, 45, 44, 43, 42, 41, 37, 36, 35, 34, 33, 32, 31,
		25, 24, 23, 22, 21, 13, 12, 11 ];// 当前所有棋子
var mark = true;// 控制button
function removeClick(id) {
	$("#" + id).removeClass("coin-evt");
	$("#" + id).unbind("click");
	for (x in pieces) {
		if (parseInt(pieces[x] / 10) != parseInt(id / 10)) {
			$("#" + pieces[x]).removeClass("coin-evt");
			$("#" + pieces[x]).unbind("click");
		}
	}
}
function addClick() {
	for (x in pieces) {
		$("#" + pieces[x]).addClass("coin-evt");
		$("#" + pieces[x]).click(function() {
			mark = true;
			rightVal = 79 * (this.id % 10 - 1);
			bottomVal = 90 + 79 * (parseInt(this.id / 10) - 1);
			movegif(this.id, rightVal, bottomVal);
			countLeft++;
			removeClick(this.id);
		});
	}
}
$(".coin-img").click(function() {
	mark = true;
	rightVal = 79 * (this.id % 10 - 1);
	// rightVal = 80 * (this.id % 10 - 1) - 8 * (countLeft - this.id % 10);
	bottomVal = 90 + 79 * (parseInt(this.id / 10) - 1);
	movegif(this.id, rightVal, bottomVal);
	countLeft++;
	removeClick(this.id);
});

$("#done").click(function() {
	if (mark) {
		mark = false;
		var move = pick(state);
		var n = move[1];
		var temppieces = pieces;
		for (var i = 0; i < temppieces.length; i++) {
			if (n != 0 && parseInt(temppieces[i] / 10) == move[0]) {
				rightVal = -640 + 79 * (temppieces[i] % 10 - 1);
				bottomVal = 90 + 79 * (parseInt(temppieces[i] / 10) - 1);
				movegif(temppieces[i], rightVal, bottomVal);
				$("#" + temppieces[i]).removeClass("coin-evt");
				$("#" + temppieces[i]).unbind("click");
				countRight++;
				n--;
			}
		}
		addClick();
	}
});

function movegif(id, rightVal, bottomVal) {
	$("#" + id).animate({
		bottom : bottomVal,
		right : rightVal
	}, 500);

	// 拿完之后的棋子
	var piece = new Array(1);
	piece[0] = parseInt(id);
	pieces = pieces.diff(piece); // 当前状态减去拿掉的硬币
	var rowVal = parseInt(id / 10);// 拿的几排
	state = state - Math.pow(10, 4 - rowVal);// 拿完状态
	if (state == 1 || state == 10 || state == 100 || state == 1000) {
		setTimeout(function() {
			alert('game over!')
		}, 500);
		$("#done").unbind("click");
		for (x in pieces) {
			if (parseInt(pieces[x] / 10) != parseInt(id / 10)) {
				$("#" + pieces[x]).removeClass("coin-evt");
				$("#" + pieces[x]).unbind("click");
			}
		}
	}
}

// 数组取差
Array.prototype.diff = function(a) {
	return this.filter(function(i) {
		return a.indexOf(i) < 0;
	});
};

/**
 * 拿硬币
 */
function pick(temp) {
	var num = matchNumber(temp);
	var int0 = new Array(2);
	if (num >= 1000) {
		int0[0] = 1;
		int0[1] = parseInt(num / 1000);
	} else if (num >= 100) {
		int0[0] = 2;
		int0[1] = parseInt(num / 100);
	} else if (num >= 10) {
		int0[0] = 3;
		int0[1] = parseInt(num / 10);
	} else {
		int0[0] = 4;
		int0[1] = num;
	}
	return int0;
}
// 对照表添加着法
function winMoves(row) {
	board[0] = 1;
	board[1] = 10;
	board[2] = 100;
	board[3] = 1000;
	for (var i = 0; i <= 3; i++) {
		for (var j = 0; j <= 5; j++) {
			for (var k = 0; k <= 7; k++) {
				for (var k1 = 0; k1 <= 9; k1++) {
					var a = i * 1000 + j * 100 + k * 10 + k1;
					var judge = true;
					for (var k2 = 0; k2 < board.length; k2++) {
						var b = board[k2];
						var temp = 0;
						if (i == parseInt(b / 1000)) {
							temp++;
						}
						if (j == parseInt(b / 100) % 10) {
							temp++;
						}
						if (k == parseInt(b / 10) % 10) {
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
						board.push(a);
					}
				}

			}
		}
	}
}
function matchNumber(integer) {
	/**
	 * 千位数：integer/1000
	 * 
	 * 百位数：integer/100%10
	 * 
	 * 十位数：integer/10%10
	 * 
	 * 个位数：integer%10
	 */
	// 逐一对照，返回差数
	for (i in board) {
		if (integer == board[i]) {
			if (parseInt(integer / 1000) != 0) {
				return 1000;
			} else if (parseInt(integer / 100) != 0) {
				return 100;
			} else if (parseInt(integer / 10) != 0) {
				return 10;
			}
		}
		if (integer > board[i]) {
			if ((integer - board[i]) % 1000 == 0
					|| (parseInt(integer / 1000) == parseInt(board[i] / 1000) && integer % 100 == board[i] % 100)
					|| (parseInt(board[i] / 100) == parseInt(integer / 100) && integer % 10 == board[i] % 10)
					|| parseInt(board[i] / 10) == parseInt(integer / 10)) {
				return integer - board[i];
			}
		}
	}
	return 0;
}