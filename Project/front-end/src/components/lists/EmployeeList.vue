<template>
  <div id="employee-list">
    <h1>Employee List</h1>
    <div>
      <employee-summary
        v-for="employee in employees"
        v-bind:key="employee.id"
        v-bind:employee="employee"
      />
    </div>
  </div>
</template>

<script>
import EmployeeSummary from "@/components/profiles/EmployeeSummary";

import employeeService from "@/services/EmployeeService";

export default {
  components: {
    EmployeeSummary,
  },
  data() {
    return {
      employees: [],
    };
  },
  created() {
    employeeService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_EMPLOYEES", response.data);
        this.employees = this.$store.state.employees;
      }
    });
  },
};
</script>

<style>
</style>