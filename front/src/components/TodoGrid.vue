<template>
  <div id="app">
    <v-grid theme="compact" :source="rows" :columns="columns" ></v-grid>
  </div>
</template>

<script>
import VGrid from '@revolist/vue3-datagrid'
export default {
  name: 'App',
  data () {
    return {
      columns: [
        { name: 'Name', prop: 'name', columnType: 'number', size: 150 },
        { name: 'Details', prop: 'details', columnType: 'text' }
      ],
      rows: [
        { name: '1', details: 'Item 1' },
        { name: '2', details: 'Item 1' },
        { name: '3', details: 'Item 1' },
        { name: '4', details: 'Item 1' },
        { name: '5', details: 'Item 1' },
        { name: '6', details: 'Item 1' }
      ]
    }
  },
  components: {
    VGrid
  }
}
</script>

<style scoped>
  #app {
	height: 200px;
	width: 100%;
  }
  revo-grid {
    height: 100%;
  }
</style>
