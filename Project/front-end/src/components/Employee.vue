<template>
  <div>
    {{ employee.firstName }}
    {{ employee.lastName }}
  </div>
</template>

<script>
import employeeService from "@/services/EmployeeService";

export default {
  data() {
    return {
      employee: {},
    };
  },
  created() {
    employeeService.get(1).then((response) => {
      this.employee = response.data;
    });
  },
};
</script>

<style>
</style>