// vue.config.js
module.exports = {
  baseUrl: './',
  publicPath: process.env.NODE_ENV === 'production'
    ? '/yyxy/'
    : '/'
}