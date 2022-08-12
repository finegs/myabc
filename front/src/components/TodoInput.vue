<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodo" placeholder="Type what you have to do" 
      v-on:keyup.enter="addTodo">
      <span class="addContainer" v-on:click="addTodo">
        <i class="addBtn fas fa-plus" aria-hidden="true"></i>
      </span>

      <Teleport to="body">
        <modal :show="showModal" @close="showModal = false">
          <template #header>
            <h3>Warning</h3>
          </template>
          <template #body>
            <h3>Enter TODO</h3>
          </template>
          <template #footer>
            <h3></h3>
            <button
              class="modal-default-button"
              @click="showModal = false"
            >OK</button>
          </template>
        </modal>
      </Teleport>
      <!--
      <modal v-if="showModal" @close="showModal = false">
        <h3 slot="header">Warniiiiiiiiiiiiing</h3>
        <span slot="footer" @click="showModal = false">
          Enter TODO
          <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
        </span>
      </modal>
      -->
  </div>
</template>

<script>
import Modal from "./common/Modal.vue"

export default {
  data() {
    return {
      newTodo: '',
      showModal: false
    }
  },
  methods: {
    addTodo() {
      if(this.newTodo !== "") {
        let value = this.newTodo && this.newTodo.trim();
        this.$emit("addTodo", value);
        this.cleanInput();
      } else {
        this.showModal = !this.showModal;
      }
    },
    cleanInput() {
      this.newTodo = '';
    }
  },
  components : {
    Modal: Modal
  }
}
</script>

<style scoped>
  input:focus {
    outline: none;
  }
  .inputBox {
    background : white;
    height : 50px;
    line-height: 50px;
    border-radius: 5px;
  }
  .inputBox input {
    border-style: none;
    font-size:0.9rem;
  }
  .addContainer {
    float:right;
    background: linear-gradient(to right, #6478fb, #8763fb);
    display:block;
    width:3rem;
    border-radius: 0 5px 5px 0;;
  }
  .addBtn {
    color : white;
    vertical-align: middle;
  }
</style>
