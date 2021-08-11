import { createStore } from 'vuex'

export default createStore({
  state: {
    positions: [],
    employees: [],
    contractors: [],
  },
  mutations: {
    SET_POSITIONS(state, positions) {
      state.positions = positions;
    },
    SET_EMPLOYEES(state, employees) {
      state.employees = employees;
    },
    SET_CONTRACTORS(state, contractors) {
      state.contractors = contractors;
    }
  },
  actions: {
  },
  modules: {
  }
})
