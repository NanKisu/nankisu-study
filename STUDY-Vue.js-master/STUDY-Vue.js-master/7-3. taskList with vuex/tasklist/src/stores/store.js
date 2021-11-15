import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        tasks: [
            {
                id: 1,
                name: '우유 사기',
                labelIds: [1,2],
                done: false
            },
            {
                id: 2,
                name: 'Vuejs 도서 구입',
                labelIds: [1,3],
                done: true
            }
        ],
        nextTaskId: 3,
        labels: [
            {
                id: 1,
                text: '쇼핑'
            },
            {
                id: 2,
                text: '음료'
            },
            {
                id: 3,
                text: '책'
            }
        ],
        nextLabelId: 4,
        filterLabelId: null
    },
    mutations: {
        addTask(state, {name, labelIds}){
            state.tasks.push({
                id: state.nextTaskId,
                name: name,
                labelIds: labelIds,
                done: false
            })
            state.nextTaskId++
        },
        toggleTaskStatus(state, {id}){
            state.tasks.filter(task => {
                return task.id === id
            }).forEach(task => {
                console.log(task.id)
                task.done = !task.done
            })
        },
        addLabel(state, {text}){
            state.labels.push({
                id: state.nextLabelId,
                text: text
            })
            state.nextLabelId++
        },
        changeFilterLabelId(state, {id}){
            console.log(id)
            state.filterLabelId = id
        },
        loadLocalData(state, {data}){
            state.tasks = data.tasks
            state.nextTaskId = data.nextTaskId
            state.labels = data.labels
            state.nextLabelId = data.nextLabelId
        }
    },
    getters: {
        getFilterredTasks(state){
            if(state.filterLabelId == null ){
                return state.tasks
            }
            return state.tasks.filter(task => {
                return task.labelIds.includes(state.filterLabelId)
            })
        }
    },
    actions: {
        save({state}){
            const data = {
                tasks: state.tasks,
                nextTaskId: state.nextTaskId,
                labels: state.labels,
                nextLabelId: state.nextLabelId
            }
            localStorage.setItem('taskList-data', JSON.stringify(data))
        },
        load({commit}){
            const data = localStorage.getItem('taskList-data')
            if(data){
                commit('loadLocalData', {data: JSON.parse(data)})
            }
        }
    }
})

export default store;