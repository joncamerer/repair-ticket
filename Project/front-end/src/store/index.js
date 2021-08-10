import { createStore } from 'vuex'

export default createStore({
  state: {
    positions: [],
  },
  mutations: {
    SET_POSITIONS(state, positions) {
      state.positions = positions;
    }
  },
  actions: {
  },
  modules: {
  }
})
