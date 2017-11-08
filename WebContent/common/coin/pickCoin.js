var count = 1;
var rightVal;
var bottomVal;
$("img").click(function() {
	rightVal = 80 * (this.id % 10 - 1) - 8 * (count - this.id % 10);
	bottomVal = 100 + 92 * (parseInt(this.id / 10) - 1);
	$("#" + this.id).animate({
		bottom : bottomVal,
		right : rightVal
	}, "fast");
	count += 1;
});

$("button").click(function(){
//	alert(pick(12))
});

var board1 = [ 356, 347, 330, 321, 312, 303, 257, 246, 231, 220, 213, 202, 154,
		145, 132, 123, 111, 55, 44, 33, 22 ];

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