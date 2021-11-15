<template>
  <div id="app">
    <h2>테스크 목록</h2>
    <ul>
      <li v-for="task in tasks" :key="task.id">
        <input type="checkbox" :checked="task.done" v-on:change="toggleTaskStatus(task)"/>
        {{task.name}}
        <span v-for="id in task.labelIds" :key="id">
          [ {{getLabelText(id)}} ] 
        </span>
      </li>
    </ul>
    <form v-on:submit.prevent="addTask">
      <input type="text" v-model="newTaskName" placeholder="새 태스크"/>
    </form>

    <h2>레이블 목록</h2>
    <ul>
      <li v-for="label in labels" :key="label.id">
        <input type="checkbox" :value="label.id" v-model="newTaskLabelIds"/>
        {{label.text}}
      </li>
    </ul>
    <form v-on:submit.prevent="addLabel">
      <input type="text" v-model="newLabelText" placeholder="새 레이블"/>
    </form>

    <h2>필터 레이블</h2>
    <ul>
      <li v-for="label in labels" :key="label.id">
        <input type="radio" name="filterLabel" v-on:change="changeFilterLabelId(label.id)"/>
        {{label.text}}
      </li>
      <li>
        <input type="radio" name="filterLabel" v-on:change="changeFilterLabelId(null)"/>
        모든 레이블
      </li>
    </ul>

    <input type="button" value="저장" v-on:click="save()"/>
    <input type="button" value="불러오기" v-on:click="load()"/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){
    return {
      newTaskName: '',
      newTaskLabelIds: [],
      newLabelText: ''
    }
  },
  computed: {
    tasks(){
      return this.$store.getters.getFilterredTasks
    },
    labels(){
      return this.$store.state.labels
    },
    filterLabelId(){
      return this.$store.state.filterLabelId
    }
  },
  methods: {
    toggleTaskStatus(task){
      this.$store.commit('toggleTaskStatus', {id: task.id})
    },
    addTask(){
      this.$store.commit('addTask', {name: this.newTaskName, labelIds: this.newTaskLabelIds})
      this.newTaskName = ''
      this.newTaskLabelIds = []
    },
    addLabel(){
      this.$store.commit('addLabel', {text: this.newLabelText})
      this.newLabelText = ''
    },
    getLabelText(id){
      return this.labels.filter(label => {
        return label.id === id
      })[0].text
    },
    changeFilterLabelId(id){
      console.log(id)
      this.$store.commit('changeFilterLabelId',{id:id})
    },
    save(){
      this.$store.dispatch('save')
    },
    load(){
      this.$store.dispatch('load')
    }
  }
}
</script>