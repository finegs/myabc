<template>
  <section>
    <transition-group name="list" tag="ul">
      <li v-for="(todo, index) in propsdata" :key="todo" class="shadow">
        <i class="checkBtn fas fa-check" aria-hidden="true"></i>
        {{todo}}
        <span class="removeBtn" type="button" @click="removeTodo(todo, index)">
          <i class="far fa-trash-alt" aria-hidden="true"></i>
        </span>
      </li>
    </transition-group>
    <!--
    <ul>
      <li v-for="(todo,index) in propsdata" class="shadow">
        <i class="checkBtn fas fa-check" aria-hidden="true"></i>
        {{todo}}
        <span class="removeBtn" type="button" @click="removeTodo(todo, index)">
          <i class="far fa-trash-alt" aria-hidden="true"></i>
        </span>
      </li>
    </ul>
    -->
  </section>
</template>

<script>

export default {
  props: [
    'propsdata'
  ],
  methods: {
    removeTodo (todo, index) {
      this.$emit('removeTodo', todo, index)
    }
  }
}
</script>

<style scoped>
  .list-enter-active, .list-leave-active {
    transition:all 1s;
  }
  .list-enter, .list-leave-to {
    opacity : 0;
    transform:transilateY(30px);
  }
  ul {
    height: 35%;
    list-style-type: none;
    padding-left:0px;
    margin-top:0;
    text-align: left;
  }

  li {
    display: flex;
    min-height: 25px;
    height: 25px;
    line-height: 25px;
    margin: 0.5rem 0;
    padding: 0 0.0rem;
    background: white;
    border-radius: 3px;
  }

  .checkBtn {
    line-height: 25px;
    color:#62acde;
    margin-right: 3px;
  }

  .removeBtn {
    line-height: 25px;
    margin-left : auto;
    color : #de4343;
  }
</style>
