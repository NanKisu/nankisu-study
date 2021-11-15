import Vue from 'vue'
import Vuex from 'vuex'

Vue.config.productionTip = false

Vue.use(Vuex)

const store = new Vuex.Store({
  getters: {
    squared(state){
      return state.count * state.count
    }
  },
  state:{
    count: 10
  },
  mutations: {
    increment(state, payload = 1){
      state.count = state.count + payload
    }
  },
  actions: {
    incrementAction(st){
      st.commit('increment')
    }
  }
})

console.log(store.state.count)

console.log(store.getters.squared)

store.commit('increment')

console.log(store.state.count)

store.commit('increment', 10)

console.log(store.state.count)

store.dispatch('incrementAction')

console.log(store.state.count)

console.log(store.getters.squared)