import { createStore } from 'vuex'

export default createStore({
  state: {
    positions: [],
    serviceCategories: [],
    equipmentCategories: [],
    employees: [],
    contractors: [],
    locations: [],
    equipment: [],
  },
  mutations: {
    SET_POSITIONS(state, positions) {
      state.positions = positions;
    },
    SET_SERVICE_CATEGORIES(state, serviceCategories) {
      state.serviceCategories = serviceCategories;
    },
    SET_EQUIPMENT_CATEGORIES(state, equipmentCategories) {
      state.equipmentCategories = equipmentCategories;
    },
    SET_EMPLOYEES(state, employees) {
      state.employees = employees;
    },
    SET_CONTRACTORS(state, contractors) {
      state.contractors = contractors;
    },
    SET_LOCATIONS(state, locations) {
      state.locations = locations;
    },
    SET_EQUIPMENT(state, equipment) {
      state.equipment = equipment;
    }

  },
  actions: {
  },
  modules: {
  }
})
