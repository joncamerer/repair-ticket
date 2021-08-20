<template>
  <div id="equipment-list">
    <div class="list-title-button">
      <h1>EquipmentList</h1>
      <button type="button" v-on:click="toggleShowForm()">
        {{ showForm ? "-" : "+" }}
      </button>
    </div>

    <div v-if="showForm">
      <new-equipment v-on:hideForm="toggleShowForm()" />
    </div>

    <div v-else id="equipment-list-scroll">
      <equipment-summary
        v-for="item in equipment"
        :key="item.id"
        v-bind:equipment="item"
      />
    </div>
  </div>
</template>

<script>
import NewEquipment from "@/components/forms/NewEquipment";
import EquipmentSummary from "@/components/profiles/EquipmentSummary";

import equipmentService from "@/services/EquipmentService";

export default {
  components: {
    NewEquipment,
    EquipmentSummary,
  },
  data() {
    return {
      equipment: [],
      showForm: false,
    };
  },
  created() {
    equipmentService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_EQUIPMENT", response.data);
        this.equipment = this.$store.state.equipment;
      }
    });
  },
  methods: {
    toggleShowForm() {
      this.showForm = !this.showForm;
    },
  },
};
</script>

<style>
#equipment-list {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#equipment-list-scroll {
  overflow: scroll;
}
</style>