<template>
<!--  <img alt="Vue logo" src="./assets/logo.png"> -->
  <hw01 msg="Good myabc App"/>
<!--  <tutorial01 msg="title"/> -->
</template>

<script>
import hw01 from './components/HelloWorld.vue';
import tutorial01 from './components/Tutorial01.vue'

export default {
  name: 'App',
  components: {
    hw01,
    tutorial01
    // aaa
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
