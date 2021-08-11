import { createStore } from 'vuex'

export default createStore({
  state: {
    positions: [],
    employees: [],
  },
  mutations: {
    SET_POSITIONS(state, positions) {
      state.positions = positions;
    },
    SET_EMPLOYEES(state, employees) {
      state.employees = employees;
    }
  },
  actions: {
  },
  modules: {
  }
})
