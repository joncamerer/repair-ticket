<template>
  <div id="home">
    <employee-list />
    <contractor-list />
    <location-list />
  </div>
</template>

<script>
import EmployeeList from "@/components/lists/EmployeeList";
import ContractorList from "@/components/lists/ContractorList";
import LocationList from "@/components/lists/LocationList";

import positionService from "@/services/PositionService";

export default {
  name: "Home",
  components: {
    EmployeeList,
    ContractorList,
    LocationList,
  },
  created() {
    positionService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_POSITIONS", response.data);
      }
    });
  },
};
</script>
