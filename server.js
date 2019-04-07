var express = require('express')
var path = require('path')
var serveStatic = require('serve-static')
const request = require('request')

const serverUrl='http://yyxyapi.herokuapp.com';//server地址

var app = express()
app.use(serveStatic(path.join(__dirname, 'dist')))
app.use('/', function(req, res) {
	let url = serverUrl + req.url;
	req.pipe(request(url)).pipe(res);
});

var port = process.env.PORT || 5000
app.listen(port)
console.log('server started ' + port)