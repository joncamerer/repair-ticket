<template>
  <div id="new-location">
    <h1 class="form-title">New Location</h1>
    <form v-on:submit.prevent="addLocation()" id="new-location-form">
      <div id="new-location-form-inputs">
        <div class="form-pair">
          <label class="hidden-label" for="new-loc-name">Location Name:</label>
          <input
            id="new-loc-name"
            type="tel"
            placeholder="Location Name"
            v-model="newLocation.name"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-loc-street-no"
            >Street Number:</label
          >
          <input
            id="new-loc-street-no"
            type="text"
            placeholder="Street Number"
            v-model="newLocation.streetNumber"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-loc-street-name"
            >Street Name:</label
          >
          <input
            id="new-loc-street-name"
            type="text"
            placeholder="Street Name"
            v-model="newLocation.streetName"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-loc-city">City:</label>
          <input
            id="new-loc-city"
            type="text"
            placeholder="City"
            v-model="newLocation.city"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-emp-loc-select">State:</label>
          <select id="new-loc-state-select" v-model="newLocation.state">
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
          <label class="hidden-label" for="new-loc-zip-code">Zip Code:</label>
          <input
            id="new-loc-zip-code"
            type="text"
            placeholder="Zip Code"
            v-model="newLocation.zipCode"
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
import locationService from "@/services/LocationService";

export default {
  data() {
    return {
      newLocation: {
        state: "",
      },
    };
  },
  methods: {
    addLocation() {
      locationService.create(this.newLocation).then((response) => {
        if (response.status === 201) {
          this.$router.go();
        }
      });
    },
    hideForm() {
      this.$emit("hideForm");
    },
  },
};
</script>

<style>
#new-location {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#new-location-form {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#new-location-form-inputs {
  display: flex;
  flex-wrap: wrap;
  flex-grow: 1;

  align-content: space-around;
  justify-content: space-around;
}
</style>