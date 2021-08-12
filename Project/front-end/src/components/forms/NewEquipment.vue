<template>
  <div id="new-equipment">
    <h1>Create New Equipment</h1>
    <form v-on:submit.prevent="addEquipment()">
      <div class="form-pair"></div>
      <div class="form-pair"></div>
      <div class="form-pair"></div>
      <div class="form-pair"></div>
      <div class="form-pair"></div>

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
      newEquipment: {},
    };
  },
  methods: {
    addEquipment() {
      equipmentService.create(this.newEquipment).then((response) => {
        if (response.status === 201) {
          this.$router.go();
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
</style>