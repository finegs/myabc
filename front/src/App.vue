<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodo="addTodo"></TodoInput>
    <TodoList v-bind:propsdata="todos" @removeTodo="removeTodo"></TodoList>
    <TodoFooter v-on:clearTodoAll="clearTodoAll"></TodoFooter>
  </div>
</template>

<script>

import TodoHeader from "./components/TodoHeader.vue"
import TodoInput from "./components/TodoInput.vue"
import TodoList from "./components/TodoList.vue"
import TodoFooter from "./components/TodoFooter.vue"
import { Console } from "console"

export default {
  data() {
    return {
      todos: []
    }
  },
  methods: {
    addTodo(newTodo) {
      localStorage.setItem(newTodo, newTodo);
      this.todos.push(newTodo);
    },
    removeTodo(todo, index) {
      localStorage.removeItem(todo);
      this.todos.splice(index, 1);
    },
    clearTodoAll() {
      localStorage.clear();
      this.todos = [];
    }
  },
  components:  {
    "TodoHeader": TodoHeader,
    "TodoInput": TodoInput,
    "TodoList": TodoList,
    "TodoFooter": TodoFooter
  },
  created() {
    if(localStorage.length > 0) {
      for(var i =0;i<localStorage.length;i++) {
        this.todos.push(localStorage.key(i));
      }
    }
  }

}
</script>

<style>
  body {
    text-align: center;
    background-color : #f6f6f8;
  }
  input {
    border-style: groove;
    width : 200px;
  }
  button {
    border-style: groove;
  }

  .shadow {
    box-shadow: 5px 10px 10px rgba(0,0,0,0.03);
  }

</style>
