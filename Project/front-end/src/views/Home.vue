<template>
  <div class="home">
    <new-employee />
    <Employee />
  </div>
</template>

<script>
import Employee from "@/components/Employee";
import NewEmployee from "@/components/forms/NewEmployee";

export default {
  name: "Home",
  components: {
    Employee,
    NewEmployee,
  },
};
</script>
