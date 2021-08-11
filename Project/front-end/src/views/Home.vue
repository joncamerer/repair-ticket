<template>
  <div id="home">
    <employee-list />
    <new-employee />
    <contractor-list />
    <new-contractor />
  </div>
</template>

<script>
import EmployeeList from "@/components/lists/EmployeeList";
import NewEmployee from "@/components/forms/NewEmployee";
import ContractorList from "@/components/lists/ContractorList";
import NewContractor from "@/components/forms/NewContractor";

import positionService from "@/services/PositionService";

export default {
  name: "Home",
  components: {
    NewEmployee,
    NewContractor,
    EmployeeList,
    ContractorList,
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
