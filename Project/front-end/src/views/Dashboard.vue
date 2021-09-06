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
import locationService from "@/services/LocationService";

export default {
  name: "Dashboard",
  components: {
    EmployeeList,
    ContractorList,
    LocationList,
    EquipmentList,
  },
  created() {
    categoryService.listAll().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_CATEGORIES", response.data);
      }
    });

    locationService.list().then((response) => {
      if (response === 200) {
        this.$store.commit("SET_LOCATIONS", response.data);
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