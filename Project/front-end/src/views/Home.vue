<template>
  <div class="home">
    <new-employee />
    <new-contractor />
    <Employee />
  </div>
</template>

<script>
import Employee from "@/components/Employee";
import NewEmployee from "@/components/forms/NewEmployee";
import NewContractor from "../components/forms/NewContractor.vue";

import positionService from "@/services/PositionService";

export default {
  name: "Home",
  components: {
    Employee,
    NewEmployee,
    NewContractor,
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
