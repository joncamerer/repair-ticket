<template>
  <div id="new-contractor">
    <h1 class="form-title">New Contractor</h1>
    <form v-on:submit.prevent="addContractor()" id="new-contractor-form">
      <div id="new-contractor-form-inputs">
        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-first-name"
            >First Name:</label
          >
          <input
            id="new-ctr-first-name"
            type="text"
            placeholder="First Name"
            v-model="newContractor.firstName"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-last-name">Last Name:</label>
          <input
            id="new-ctr-last-name"
            type="text"
            placeholder="Last Name"
            v-model="newContractor.lastName"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-email">Email:</label>
          <input
            id="new-ctr-email"
            type="email"
            placeholder="Email"
            v-model="newContractor.email"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-phone">Phone Number:</label>
          <input
            id="new-ctr-phone"
            type="tel"
            placeholder="Phone Number"
            v-model="newContractor.phone"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-street-no"
            >Street Number:</label
          >
          <input
            id="new-ctr-street-no"
            type="text"
            placeholder="Street Number"
            v-model="newContractor.streetNumber"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-street-name"
            >Street Name:</label
          >
          <input
            id="new-ctr-street-name"
            type="text"
            placeholder="Street Name"
            v-model="newContractor.streetName"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-city">City:</label>
          <input
            id="new-ctr-city"
            type="text"
            placeholder="City"
            v-model="newContractor.city"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-state">State:</label>
          <input
            id="new-ctr-state"
            type="text"
            placeholder="State"
            v-model="newContractor.state"
          />
        </div>

        <div class="form-pair">
          <label class="hidden-label" for="new-ctr-zip-code">Zip Code:</label>
          <input
            id="new-ctr-zip-code"
            type="text"
            placeholder="Zip Code"
            v-model="newContractor.zipCode"
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
import contractorService from "@/services/ContractorService";

export default {
  data() {
    return {
      newContractor: {},
    };
  },
  methods: {
    addContractor() {
      contractorService.create(this.newContractor).then((response) => {
        if (response.status == 201) {
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
#new-contractor {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#new-contractor-form {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#new-contractor-form-inputs {
  display: flex;
  flex-wrap: wrap;
  flex-grow: 1;

  align-content: space-around;
  justify-content: space-around;
}
</style>