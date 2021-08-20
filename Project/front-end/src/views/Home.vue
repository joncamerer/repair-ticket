<template>
  <div id="home">
    <div id="home-body">
      <employee-list />
      <contractor-list />
    </div>
    <div id="home-foot">
      <location-list />
      <equipment-list />
    </div>
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
#home {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#home-body {
  display: flex;
  height: 70%;
}

#home-foot {
  display: flex;
  height: 30%;
}

#home-sidebar {
  display: flex;
}
</style>