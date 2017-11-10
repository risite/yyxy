var state = 357;// 当前局面状态
var countLeft = 1;// 放左边总数
var countRight = 1;// 放右边总数
var rightVal;// 向左平移值
var bottomVal;// 向上平移值
var board1 = [ 356, 347, 330, 321, 312, 303, 257, 246, 231, 220, 213, 202, 154,
		145, 132, 123, 111, 55, 44, 33, 22 ];// 必赢着法对照表
var pieces = [ 37,36,35,34,33,32,31,25,24,23,22,21,13,12,11 ];// 当前所有棋子

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
			rightVal = 89 * (this.id % 10 - 1);
			bottomVal = 100 + 92 * (parseInt(this.id / 10) - 1);
			movegif(this.id, rightVal, bottomVal);
			countLeft++;
			removeClick(this.id);
		});
	}
}

$(".coin-img").click(function() {
	rightVal = 89 * (this.id % 10 - 1);
//	rightVal = 80 * (this.id % 10 - 1) - 8 * (countLeft - this.id % 10);
	bottomVal = 100 + 92 * (parseInt(this.id / 10) - 1);
	movegif(this.id, rightVal, bottomVal);
	countLeft++;
	removeClick(this.id);
});

/**
 * 机器(AI
 */
$("#done").click(
		function() {
			var move = pick(state);
			var n = move[1];
			var temppieces = pieces;
			for (var i = 0; i < temppieces.length; i++) {
				if (n != 0 && parseInt(temppieces[i] / 10) == move[0]) {
					rightVal = -558 + 89 * (temppieces[i] % 10 - 1);
					bottomVal = 100 + 92 * (parseInt(temppieces[i] / 10) - 1);
					movegif(temppieces[i], rightVal, bottomVal);
					$("#" + temppieces[i]).removeClass("coin-evt");
					$("#" + temppieces[i]).unbind("click");
					countRight++;
					n--;
				}
			}
			addClick();
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
	state = state - Math.pow(10, 3 - rowVal);// 拿完状态
	if (state == 1 || state == 10 || state == 100) {
		setTimeout(function() {
			alert('game over!')
		}, 500);
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
	if (num >= 100) {
		int0[0] = 1;
		int0[1] = parseInt(num / 100);
	} else if (num >= 10) {
		int0[0] = 2;
		int0[1] = parseInt(num / 10);
	} else {
		int0[0] = 3;
		int0[1] = num;
	}
	return int0;
}

function matchNumber(integer) {

	// 只有一排有
	if (integer % 100 == 0 && integer != 100) {
		return integer - 100;
	} else if (integer % 10 == 0 && integer > 10 && 100 > integer) {
		return integer - 10;
	} else if (integer < 10 && integer > 1) {
		return integer - 1;
	}
	/**
	 * 百位数：integer/100
	 * 
	 * 十位数：integer/10%10
	 * 
	 * 个位数：integer%10
	 */

	// *10 or *01
	if ((integer % 10 == 0 && parseInt(integer / 10) % 10 == 1)
			|| (integer % 10 == 1 && parseInt(integer / 10) % 10 == 0)) {
		return parseInt(integer / 100) * 100;
	}
	// 1*0 or 0*1
	if ((parseInt(integer / 100) == 1 && integer % 10 == 0)
			|| (parseInt(integer / 100) == 0 && integer % 10 == 1)) {
		return (parseInt(integer / 10) % 10) * 10;
	}
	// 10* or 01*
	if ((parseInt(integer / 100) == 1 & parseInt(integer / 10) % 10 == 0)
			|| (parseInt(integer / 100) == 0 && parseInt(integer / 10) % 10 == 1)) {
		return integer % 10;
	}

	// 逐一对照，返回差数
	for (i in board1) {
		if (integer == board1[i]) {
			if (parseInt(board1[i] / 100) != 0) {
				return 100;
			} else {
				return 10;
			}
		}
		if (integer > board1[i]) {
			if ((integer - board1[i]) % 100 == 0
					|| ((integer - board1[i]) % 10 == 0 && parseInt((integer - board1[i]) / 10) < 10)
					|| parseInt(board1[i] / 10) == parseInt(integer / 10)) {
				return integer - board1[i];
			}
		}
	}
	return 0;
}