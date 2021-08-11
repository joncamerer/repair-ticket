<template>
  <div id="location-list">
    <h1>Location List</h1>
    <div>
      <location-summary
        v-for="location in locations"
        :key="location.id"
        v-bind:location="location"
      />
    </div>
  </div>
</template>

<script>
import LocationSummary from "@/components/profiles/LocationSummary";

import locationService from "@/services/LocationService";

export default {
  components: {
    LocationSummary,
  },
  data() {
    return {
      locations: [],
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
};
</script>

<style>
</style>