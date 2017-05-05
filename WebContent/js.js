// 创建WebSocket对象
var webSocket = new WebSocket("ws://localhost:8080/echoserver/echo");
var sendMsg = function() {
	var inputElement = document.getElementById('msg');
	// 发送消息
	webSocket.send(inputElement.value);
	// 清空单行文本框
	inputElement.value = "";
}
var send = function(event) {
	if (event.keyCode == 13) {
		sendMsg();
	}
};
webSocket.onopen = function() {
	// 为onmessage事件绑定监听器，接收消息
	webSocket.onmessage = function(event) {
		var show = document.getElementById('show')
		// 接收、并显示消息
		show.innerHTML += event.data + "<br/>";
		show.scrollTop = show.scrollHeight;
		ak(event.data);
	}
	document.getElementById('msg').onkeydown = send;
	document.getElementById('sendBn').onclick = sendMsg;
};
webSocket.onclose = function() {
	document.getElementById('msg').onkeydown = null;
	document.getElementById('sendBn').onclick = null;
	Console.log('WebSocket已经被关闭。');
};

function ak(temp){
	var arr = temp.substr(temp.length-7,temp.length).split(",");
	var div0 = document.getElementById(arr[0]);
	var shiorhu = div0.children[0].name;

	// alert(div0.onclick)

	document.getElementById(arr[1]).innerHTML = div0.innerHTML;
	document.getElementById(arr[0]).style.opacity = 1.0;
	document.getElementById(arr[0]).innerHTML = '';

	var id1 = arr[1].substr(1, 1);
	var id2 = arr[1].substr(2, 1);

	var ways = [ "1243", "2143", "2314", "2341", "3412", "3241",
			"3214", "4312" ];
	// 杀子
	kill(id1, id2, shiorhu, ways);

	var animals = document.getElementsByName(shiorhu);
	removealph(animals);

	if (shiorhu == "shi") {
		var animals2 = document.getElementsByName("hu");
		if (animals2.length < 2) {
			if (confirm("狮子胜利，是否重新开始？")) {
				location.reload();
			} else {
				removealph(animals2);
			}
		} else {
			addalph(animals2);
		}
	} else {
		var animals3 = document.getElementsByName("shi");
		if (animals3.length < 2) {
			if (confirm("老虎胜利，是否重新开始？")) {
				location.reload();
			} else {
				removealph(animals3);
			}
		} else {
			addalph(animals3);
		}
	}
}

// 上次被点到的div
var theDiv;
// 绑定的onclick方法：
/*
 * 如果被点击的div有图像（调整透明度） 如果上次被点到的是空， 这次的变成0.4透明度 把这次的div赋值给theDiv
 * 如果上次被点击的就是这次被点击的， 这次的变成1.0透明度 theDiv置为空 如果上次被点击的是其他的div 这次的变成0.4透明度
 * 上次的变成1.0透明度 这次的div赋值给theDiv 如果没图像（移动棋子） 如果上次被点击div不是空（有棋子被选中）
 * 获取到上次与这次id后两位的差（是否可以移动） 如果绝对值等于10或者等于1（可以移动） 获取到上次的div 获取到img的name，赋值给shiorhu
 * 
 * 把上次的div赋给这次的div（移动） 上次的div透明度变为1.0 内容清空 theDiv置为空
 * 
 * 获取到当前移动过的所有的div 循环把事件清空（不能再被点击，换对方移动）
 * 
 * 并为对方的棋子添加事件（可以移动）
 * 
 * id1：获取到被点击的div在第几列 id2：获取到被点击的div在第几排
 * 
 * ways表示杀子规则 调用kill()方法（杀子）
 */
function alph(obj) {

	if (obj.innerHTML.trim().length != 0) {

		if (theDiv == null) {
			obj.style.opacity = 0.4;
			theDiv = obj.id;
		} else if (theDiv == obj.id) {
			obj.style.opacity = 1.0;
			theDiv = null;
		} else {
			obj.style.opacity = 0.4;
			document.getElementById(theDiv).style.opacity = 1.0;
			theDiv = obj.id;
		}
		;

	} else {
		if (theDiv != null) {

			var aaa = theDiv.substr(1, 2) - obj.id.substr(1, 2);
			// alert(aaa)
			if (Math.abs(aaa) == 10 || Math.abs(aaa) == 1) {

				// var str = "12-12-12";
				// str = str.replace(/-/g,'');

				// alert(str)
				webSocket.send(theDiv + "," + obj.id);
				var div0 = document.getElementById(theDiv);
				var shiorhu = div0.children[0].name;

				// alert(div0.onclick)

				obj.innerHTML = div0.innerHTML;
				document.getElementById(theDiv).style.opacity = 1.0;
				document.getElementById(theDiv).innerHTML = '';
				theDiv = null;

				var id1 = obj.id.substr(1, 1);
				var id2 = obj.id.substr(2, 1);

				var ways = [ "1243", "2143", "2314", "2341", "3412", "3241",
						"3214", "4312" ];
				// 杀子
				kill(id1, id2, shiorhu, ways);

				var animals = document.getElementsByName(shiorhu);
				removealph(animals);

				if (shiorhu == "shi") {
					var animals2 = document.getElementsByName("hu");
					if (animals2.length < 2) {
						if (confirm("狮子胜利，是否重新开始？")) {
							location.reload();
						} else {
							removealph(animals2);
						}
					} else {
						addalph(animals2);
					}
				} else {
					var animals3 = document.getElementsByName("shi");
					if (animals3.length < 2) {
						if (confirm("老虎胜利，是否重新开始？")) {
							location.reload();
						} else {
							removealph(animals3);
						}
					} else {
						addalph(animals3);
					}
				}
				;
			}
			;
		}
		;
	}

}

// 杀子规则
/*
 * params: id1,移动到了第几列 id2,移动到了第几排 shiorhu，移动的哪方 ways，杀子规则，四个数字分别表示： a，移到了第几排
 * b，相邻的是己方的棋子 c，最远的边上没子 d，要杀的子是对方的
 */
function kill(id1, id2, shiorhu, ways) {

	for (var i = 0; i < ways.length; i++) {

		var way = ways[i];
		var a = way.substr(0, 1);
		var b = way.substr(1, 1);
		var c = way.substr(2, 1);
		var d = way.substr(3, 1);
		if (id1 == a
				&& document.getElementById("g" + b + id2).children[0] != undefined
				&& document.getElementById("g" + b + id2).children[0].name == shiorhu
				&& document.getElementById("g" + c + id2).children[0] == undefined
				&& document.getElementById("g" + d + id2).children[0] != undefined
				&& document.getElementById("g" + d + id2).children[0].name != shiorhu) {
			document.getElementById("g" + d + id2).innerHTML = '';
			document.getElementById("g" + d + id2).onclick = function() {
				alph(this);
			}
		}
		;
		if (id2 == a
				&& document.getElementById("g" + id1 + b).children[0] != undefined
				&& document.getElementById("g" + id1 + b).children[0].name == shiorhu
				&& document.getElementById("g" + id1 + c).children[0] == undefined
				&& document.getElementById("g" + id1 + d).children[0] != undefined
				&& document.getElementById("g" + id1 + d).children[0].name != shiorhu) {
			document.getElementById("g" + id1 + d).innerHTML = '';
			document.getElementById("g" + id1 + d).onclick = function() {
				alph(this);
			}
		}
		;

	}
	;
}

// 去除事件
function removealph(arr) {
	for (var i = 0; i < arr.length; i++) {
		arr[i].parentNode.onclick = '';
	}
}

// 给div添加单击事件
function addalph(arr) {
	for (var i = 0; i < arr.length; i++) {
		arr[i].parentNode.onclick = function() {
			alph(this);
		}
	}
}