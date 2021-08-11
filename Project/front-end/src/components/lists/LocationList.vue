<template>
  <div id="location-list">
    <div>
      <h1>Location List</h1>
      <button type="button" v-on:click="toggleShowForm()">
        {{ showForm ? "-" : "+" }}
      </button>
    </div>

    <div v-if="showForm">
      <new-location v-on:hideForm="toggleShowForm()" />
    </div>

    <div v-else>
      <location-summary
        v-for="location in locations"
        :key="location.id"
        v-bind:location="location"
      />
    </div>
  </div>
</template>

<script>
import NewLocation from "@/components/forms/NewLocation";
import LocationSummary from "@/components/profiles/LocationSummary";

import locationService from "@/services/LocationService";

export default {
  components: {
    NewLocation,
    LocationSummary,
  },
  data() {
    return {
      locations: [],
      showForm: false,
    };
  },
  created() {
    locationService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_LOCATIONS", response.data);
        this.locations = this.$store.state.locations;
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
</style>