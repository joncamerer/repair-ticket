<template>
  <div id="new-location">
    <h1>Create New Location</h1>
    <form v-on:submit.prevent="addLocation()">
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
        <label class="hidden-label" for="new-loc-state">State:</label>
        <input
          id="new-loc-state"
          type="text"
          placeholder="State"
          v-model="newLocation.state"
        />
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
      newLocation: {},
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
</style>