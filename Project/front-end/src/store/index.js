import { createStore } from 'vuex'

export default createStore({
  state: {
    positions: [],
    employees: [],
    contractors: [],
    locations: [],
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
    },
    SET_LOCATIONS(state, locations) {
      state.locations = locations;
    }
  },
  actions: {
  },
  modules: {
  }
})
