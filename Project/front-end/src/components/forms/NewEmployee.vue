<template>
  <div id="new-employee">
    <h1 class="form-title">New Employee</h1>
    <form v-on:submit.prevent="addEmployee()" id="new-employee-form">
      <div id="new-employee-form-inputs">
        <div class="form-pair">
          <label class="hidden-label" for="new-emp-first-name"
            >First Name:</label
          >
          <input
            id="new-emp-first-name"
            type="text"
            placeholder="First Name"
            v-model="newEmployee.firstName"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-last-name">Last Name:</label>
          <input
            id="new-emp-last-name"
            type="text"
            placeholder="Last Name"
            v-model="newEmployee.lastName"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-email">Email:</label>
          <input
            id="new-emp-email"
            type="email"
            placeholder="Email"
            v-model="newEmployee.email"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-phone">Phone Number:</label>
          <input
            id="new-emp-phone"
            type="tel"
            placeholder="Phone Number"
            v-model="newEmployee.phone"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-street-no"
            >Street Number:</label
          >
          <input
            id="new-emp-street-no"
            type="text"
            placeholder="Street Number"
            v-model="newEmployee.streetNumber"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-street-name"
            >Street Name:</label
          >
          <input
            id="new-emp-street-name"
            type="text"
            placeholder="Street Name"
            v-model="newEmployee.streetName"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-city">City:</label>
          <input
            id="new-emp-city"
            type="text"
            placeholder="City"
            v-model="newEmployee.city"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-state-select">State:</label>
          <select id="new-emp-state-select" v-model="newEmployee.state">
            <option value="">--Please select a State</option>
            <option
              v-for="state in $store.state.usStates"
              :key="state.id"
              :value="state.name"
            >
              {{ state.name }}
            </option>
          </select>
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-zip-code">Zip Code:</label>
          <input
            id="new-emp-zip-code"
            type="text"
            placeholder="Zip Code"
            v-model="newEmployee.zipCode"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-position">Position:</label>
          <select id="new-emp-position" v-model="newEmployee.positionId">
            <option value="">--Please select a position</option>
            <option
              v-for="position in $store.state.categories.positions"
              :key="position.id"
              :value="position.id"
            >
              {{ position.name }}
            </option>
          </select>
        </div>

        <div id="location-box" v-if="canSelectMultipleLocations">
          <div
            class="location-pair"
            v-for="location in $store.state.locations"
            :key="location.id"
          >
            <label class="location-label" :for="'location-' + location.id">{{
              location.name
            }}</label>
            <input
              :id="'location-' + location.id"
              class="location-check"
              type="checkbox"
              v-model="multipleIds"
              :value="location.id"
            />
          </div>
        </div>

        <div class="form-pair" v-else>
          <label class="hidden-label" for="new-employee-location"
            >Location:</label
          >
          <select id="new-employee-location" v-model="newEmployee.locationIds">
            <option value="">--Please select a location</option>
            <option
              v-for="location in $store.state.locations"
              :key="location.id"
              :value="[location.id]"
            >
              {{ location.name }}
            </option>
          </select>
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-hire-date">Hire Date:</label>
          <input
            id="new-emp-hire-date"
            type="date"
            v-model="newEmployee.hireDate"
          />
        </div>
      </div>

      <div>
        <button type="submit">Submit</button>
        <button type="button" v-on:click.prevent="hideForm()">Cancel</button>
      </div>
    </form>
  </div>
</template>

<script>
import employeeService from "@/services/EmployeeService";

export default {
  data() {
    return {
      newEmployee: {
        state: "",
        positionId: "",
        hireDate: "",
        locationIds: "",
      },
      multipleIds: [],
    };
  },
  created() {
    this.resetHireDate();
  },
  methods: {
    addEmployee() {
      var hireDate = new Date(this.newEmployee.hireDate);
      this.newEmployee.hireDate = new Date(
        hireDate.getTime() + hireDate.getTimezoneOffset() * 60000
      );

      if (this.canSelectMultipleLocations) {
        this.newEmployee.locationIds = this.multipleIds;
      }

      employeeService.create(this.newEmployee).then((response) => {
        if (response.status === 201) {
          var employee = response.data;

          this.$store.commit("ADD_EMPLOYEE", employee);
          this.hideForm();
        } else {
          this.resetHireDate();
        }
      });
    },
    resetHireDate() {
      var today = new Date();
      var month = "" + (today.getMonth() + 1);
      var day = "" + today.getDate();
      var year = today.getFullYear();

      if (month.length < 2) month = "0" + month;
      if (day.length < 2) day = "0" + day;

      this.newEmployee.hireDate = [year, month, day].join("-");
    },
    hideForm() {
      this.$emit("hideForm");
    },
  },
  computed: {
    canSelectMultipleLocations() {
      var position = this.$store.state.categories.positions.find(
        (e) => e.id === this.newEmployee.positionId
      );

      return (
        this.newEmployee.positionId !== "" &&
        (position.name === "Administrator" ||
          position.name === "District Manager")
      );
    },
  },
};
</script>

<style>
#new-employee {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#new-employee input {
  max-height: 1em;
}

#new-employee select {
  max-height: 2em;
}

#new-employee-form {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#new-employee-form-inputs {
  display: flex;
  flex-wrap: wrap;
  flex-grow: 1;

  align-content: space-around;
  justify-content: space-around;
}

#location-box {
  max-height: 3em;
  overflow: scroll;
}

#new-emp-hire-date {
  max-height: 1.5em !important;
}
</style>