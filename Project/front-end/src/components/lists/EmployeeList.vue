<template>
  <div id="employee-list">
    <div class="list-title-button">
      <h1>Employee List</h1>
      <button type="button" v-on:click="toggleShowForm()">
        {{ showForm ? "-" : "+" }}
      </button>
    </div>

    <div v-if="showForm" id="employee-list-form">
      <new-employee v-on:hideForm="toggleShowForm()" />
    </div>

    <div v-else id="employee-list-scroll">
      <employee-summary
        v-for="employee in employees"
        v-bind:key="employee.id"
        v-bind:employee="employee"
      />
    </div>
  </div>
</template>

<script>
import NewEmployee from "@/components/forms/NewEmployee";
import EmployeeSummary from "@/components/profiles/EmployeeSummary";

import employeeService from "@/services/EmployeeService";

export default {
  components: {
    NewEmployee,
    EmployeeSummary,
  },
  data() {
    return {
      employees: [],
      showForm: false,
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
  methods: {
    toggleShowForm() {
      this.showForm = !this.showForm;
    },
  },
};
</script>

<style>
#employee-list {
  display: flex;
  flex-direction: column;

  width: 67%;
}

#employee-list-form {
  display: flex;
  flex-grow: 1;
}

#employee-list-scroll {
  overflow: scroll;
}
</style>