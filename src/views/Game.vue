<template>
  <div class="game">
    <el-table :data="userList" style="width: 100%">
      <el-table-column type="index"></el-table-column>
      <el-table-column prop="username" label="用户名"></el-table-column>
      <el-table-column prop="password" label="密码"></el-table-column>
      <el-table-column prop="mobile" label="电话"></el-table-column>
      <el-table-column prop="role.name" label="角色"></el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  name: "game",
  data() {
    return {
      userList: []
    };
  },
  mounted() {
    this.getUser();
  },
  methods: {
    getUser() {
      this.$api.user.getUser().then(res => {
        this.userList = res._embedded.user;
      });
    }
  }
};
</script>
