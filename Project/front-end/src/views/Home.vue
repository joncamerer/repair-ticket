<template>
  <div class="home">
    <new-employee />
    <Employee />
  </div>
</template>

<script>
import Employee from "@/components/Employee";
import NewEmployee from "@/components/forms/NewEmployee";

import positionService from "@/services/PositionService";

export default {
  name: "Home",
  components: {
    Employee,
    NewEmployee,
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
