<template>
    <div class="vueex">
        <h1>This is sample page.</h1>
        totalItems : {{totalItems}} <br/>
        totalPages : {{totalPages}} <br/>
        <ul>
            <li v-for="(row, i) in items" :key="'result_table_'+i">{{row}}</li>
        </ul>
    </div>
</template>


<script>
/**
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
    setup() {
        
    },
})
*/

import { response } from "express";
import http from "../http";

export default {
    name:"Vuex",
    component:{},
    methods: {
        delete(id) {
            http
            .delete("/api/sample/table01/"+id)
            .then(response=>{
                const {data} = response
                console.log(data)
            })
            .catch(error => {
                alert(error)
            })
        },
        create(id, params) {
            http
            .post("/api/sample/table01/", params)
            .then(response=> {
                const {data} = response
                console.log(data)
            })
            .catch(error => {
                alert(error)
            })
        },
        update(id, params) {
            http
            .put("/api/sample/table01/"+id, {
                params:params,
            })
            .then(response=> {
                const {data} = response
                console.log(data)
            })
            .catch(error => {
                alert(error)
            })
        },
        read() {
            let params = {}
            http
            .get("/api/sample/table01/", {
                params:params,
            })
            .then(response=> {
                const {data} = response
                console.log(data)
                this.items = data.items
                this.totalItems = data.totalItems
                this.totalPages = data.totalPages
            })
            .catch(error=>{
                alert(error)
            })
        },
    },
    data() {
        return {
            items: [],
            totalItems: 0,
            totalPages: 0,
        }
    },
    created() {
        console.log(http)
        this.read()
    },
};

</script>
<style scoped>
    .main {
        border:solid 5px #000;
        padding:100px;
    }
</style>
