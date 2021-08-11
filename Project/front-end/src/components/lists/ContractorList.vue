<template>
  <div id="contractor-list">
    <h1>Contractor List</h1>
    <div>
      <contractor-summary
        v-for="contractor in contractors"
        v-bind:key="contractor.id"
        v-bind:contractor="contractor"
      />
    </div>
  </div>
</template>

<script>
import ContractorSummary from "@/components/profiles/ContractorSummary";

import contractorService from "@/services/ContractorService";

export default {
  components: {
    ContractorSummary,
  },
  data() {
    return {
      contractors: [],
    };
  },
  created() {
    contractorService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_CONTRACTORS", response.data);
        this.contractors = this.$store.state.contractors;
      }
    });
  },
};
</script>

<style>
</style>