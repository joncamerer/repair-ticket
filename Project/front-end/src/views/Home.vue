<template>
  <div id="home">
    <employee-list />
    <contractor-list />
    <location-list />
    <equipment-list />
  </div>
</template>

<script>
import EmployeeList from "@/components/lists/EmployeeList";
import ContractorList from "@/components/lists/ContractorList";
import LocationList from "@/components/lists/LocationList";
import EquipmentList from "@/components/lists/EquipmentList.vue";

import categoryService from "@/services/CategoryService";

export default {
  name: "Home",
  components: {
    EmployeeList,
    ContractorList,
    LocationList,
    EquipmentList,
  },
  created() {
    categoryService.listPositions().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_POSITIONS", response.data);
      }
    });

    categoryService.listServiceCategories().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_SERVICE_CATEGORIES", response.data);
      }
    });

    categoryService.listEquipmentCategories().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_EQUIPMENT_CATEGORIES", response.data);
      }
    });
  },
};
</script>

<style>
.list-title-button {
  display: flex;
}
</style>