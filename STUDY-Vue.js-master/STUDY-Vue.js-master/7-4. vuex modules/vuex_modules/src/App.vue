<template>
  <div id="app" v-on:click="increasement">
    {{count}} {{subCount1}} {{subCount2}} 
  </div>
</template>

<script>
export default {
  name: 'App',
  computed: {
    count(){
      return this.$store.state.count
    },
    subCount1(){
      return this.$store.state.counter1.count
    },
    subCount2(){
      return this.$store.state.counter2.count
    }
  },  
  methods: {
    increasement(){
      console.log('click')
      this.$store.dispatch('start')
      this.$store.dispatch('counter1/start')
      this.$store.dispatch('counter2/start')
    }
  }
}
</script>
