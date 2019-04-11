<template>
  <div id="app">
    <el-container>
      <el-header>
        <el-menu
          :default-active="activeIndex2"
          class="el-menu-demo"
          mode="horizontal"
          :router="true"
          @select="handleSelect"
          background-color="#000"
          text-color="#c0c4cc"
          active-text-color="#ffd04b"
        >
          <el-menu-item index="/">Home</el-menu-item>
          <el-submenu index="2">
            <template slot="title">Game</template>
            <el-menu-item index="/zousiqi">zousiqi</el-menu-item>
            <el-menu-item index="/pickCoin">pickCoin</el-menu-item>
            <el-menu-item index="/tictactoe">tictactoe</el-menu-item>
            <el-menu-item index="/biesiniu">biesiniu</el-menu-item>
          </el-submenu>
          <el-menu-item index="/user">User</el-menu-item>
          <el-menu-item index="/about">About</el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      activeIndex2: ""
    };
  },
  methods: {
    handleSelect() {}
  },
  mounted: function () {
    this.activeIndex2=this.$route.path||'/'
  },
};
</script>

<style lang="scss">
*,
*:before,
*:after {
  box-sizing: border-box;
  outline: none;
}

html {
  font-family: "Source Sans Pro", sans-serif;
  font-size: 16px;
  font-smooth: auto;
  font-weight: 300;
  line-height: 1.5;
  color: #444;
  height: 100%;
}

body {
  // position: relative;
  // display: flex;
  // align-items: center;
  // width: 100%;
  height: 100%;
  justify-content: center;
  background: linear-gradient(45deg, #ffffff, #ffffff);
  display: block;
  margin: 0;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  // text-align: center;
  color: #2c3e50;
  height: 100%;
}
.el-container {
  height: 100%;
}
.el-header {
  padding: 0 !important;
}
.el-main {
  overflow: unset !important;
  color: #333;
  display: contents !important;
  padding: 0% !important;
  // text-align: center;
}
.el-menu.el-menu--horizontal {
  border-bottom: 0 !important;
}

</style>
