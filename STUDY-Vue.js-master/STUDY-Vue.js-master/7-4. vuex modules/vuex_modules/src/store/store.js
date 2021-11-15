import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const counter1 = {
    namespaced: true,
    state: {
        count: 10
    },
    mutations: {
        increasement(state){
            console.log(4)
            console.log(state.count)
            state.count = state.count + 10
        }
    },
    actions: {
        start({commit}){
            console.log(1)
            new Promise((resolve) => {
                console.log(2)
                setTimeout(() => {
                    console.log(3)
                    resolve()
                }, 1000);
            }).then(() =>{
                commit('increasement')
            })
        }
    }
}

const counter2 = {
    namespaced: true,
    state: {
        count: 100
    },
    mutations: {
        increasement(state){
            console.log(4)
            console.log(state.count)
            state.count = state.count + 100
        }
    },
    actions: {
        start({commit}){
            console.log(1)
            new Promise((resolve) => {
                console.log(2)
                setTimeout(() => {
                    console.log(3)
                    resolve()
                }, 1000);
            }).then(() =>{
                commit('increasement')
            })
        }
    }
}

const store = new Vuex.Store({
    state: {
        count: 1
    },
    mutations: {
        increasement(state){
            console.log(4)
            console.log(state.count)
            state.count = state.count + 1
        }
    },
    actions: {
        start({commit}){
            console.log(1)
            new Promise((resolve) => {
                console.log(2)
                setTimeout(() => {
                    console.log(3)
                    resolve()
                }, 1000);
            }).then(() =>{
                commit('increasement')
            })
        }
    },
    modules:{
        counter1,
        counter2
    }
})

export default store