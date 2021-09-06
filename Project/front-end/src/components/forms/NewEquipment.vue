<template>
  <div id="new-equipment">
    <h1 class="form-title">Create New Equipment</h1>
    <form v-on:submit.prevent="addEquipment()" id="new-equipment-form">
      <div id="new-equipment-form-inputs">
        <div class="form-pair">
          <label class="hidden-label" id="new-eqp-brand">Brand:</label>
          <input
            id="new-eqp-brand"
            type="text"
            placeholder="Brand"
            v-model="newEquipment.brand"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" id="new-eqp-model">Model:</label>
          <input
            id="new-eqp-model"
            type="text"
            placeholder="Model"
            v-model="newEquipment.model"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" id="new-eqp-serial-no"
            >Serial Number:</label
          >
          <input
            id="new-eqp-serial-no"
            type="text"
            placeholder="Serial Number"
            v-model="newEquipment.serialNumber"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" id="new-eqp-eqp-cat"
            >Equipment Category:</label
          >
          <select
            id="new-eqp-eqp-cat"
            v-model="newEquipment.equipmentCategoryId"
          >
            <option value="">--Please select a category</option>
            <option
              v-for="category in $store.state.categories.equipmentCategories"
              :key="category.id"
              :value="category.id"
            >
              {{ category.name }}
            </option>
          </select>
        </div>

        <div class="form-pair">
          <label class="hidden-label" id="new-eqp-location">Location:</label>
          <select id="new-eqp-location" v-model="newEquipment.locationId">
            <option value="">--Please select a location</option>
            <option
              v-for="location in $store.state.locations"
              :key="location.id"
              :value="location.id"
            >
              {{ location.name }}
            </option>
          </select>
        </div>
      </div>

      <div>
        <button type="submit">Submit</button>
        <button type="button" v-on:click="hideForm()">Cancel</button>
      </div>
    </form>
  </div>
</template>

<script>
import equipmentService from "@/services/EquipmentService";

export default {
  data() {
    return {
      newEquipment: {
        equipmentCategoryId: "",
        locationId: "",
      },
    };
  },
  methods: {
    addEquipment() {
      equipmentService.create(this.newEquipment).then((response) => {
        if (response.status === 201) {
          var equipment = response.data;

          this.$store.commit("ADD_EQUIPMENT", equipment);
          this.hideForm();
        }
      });
    },
    hideForm() {
      this.$emit("hideForm");
    },
  },
};
</script>

<style>
#new-equipment {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#new-equipment-form {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#new-equipment-form-inputs {
  display: flex;
  flex-wrap: wrap;
  flex-grow: 1;

  align-content: space-around;
  justify-content: space-around;
}
</style>