<template>
  <div id="home">
    <employee-list />
    <new-employee />
    <contractor-list />
    <new-contractor />
    <location-list />
    <new-location />
  </div>
</template>

<script>
import EmployeeList from "@/components/lists/EmployeeList";
import NewEmployee from "@/components/forms/NewEmployee";
import ContractorList from "@/components/lists/ContractorList";
import NewContractor from "@/components/forms/NewContractor";
import LocationList from "@/components/lists/LocationList";
import NewLocation from "@/components/forms/NewLocation";

import positionService from "@/services/PositionService";

export default {
  name: "Home",
  components: {
    EmployeeList,
    NewEmployee,
    ContractorList,
    NewContractor,
    LocationList,
    NewLocation,
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
