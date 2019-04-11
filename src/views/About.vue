<template>
  <div class="about">
    <Card/>
  </div>
</template>
<script>
// @ is an alias to /src
import Card from '@/components/Card.vue'

export default {
  name: 'about',
  components: {
    Card
  }
}
</script>
<style>
.about{
  background: #303133;
  height: 100%;
}
</style>
