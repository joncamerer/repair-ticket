<template>
  <div id="contractor-list">
    <div class="list-title-button">
      <h1>Contractor List</h1>
      <button type="button" v-on:click="toggleShowForm()">
        {{ showForm ? "-" : "+" }}
      </button>
    </div>

    <div v-if="showForm">
      <new-contractor v-on:hideForm="toggleShowForm()" />
    </div>

    <div v-else>
      <contractor-summary
        v-for="contractor in contractors"
        v-bind:key="contractor.id"
        v-bind:contractor="contractor"
      />
    </div>
  </div>
</template>

<script>
import NewContractor from "@/components//forms/NewContractor";
import ContractorSummary from "@/components/profiles/ContractorSummary";

import contractorService from "@/services/ContractorService";

export default {
  components: {
    NewContractor,
    ContractorSummary,
  },
  data() {
    return {
      contractors: [],
      showForm: false,
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
  methods: {
    toggleShowForm() {
      this.showForm = !this.showForm;
    },
  },
};
</script>

<style>
</style>