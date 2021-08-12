<template>
  <div>
    <h1>Create Ticket</h1>
    <form v-on:submit.prevent="addTicket()">
      <div class="form-pair">
        <label class="hidden-label" for="new-ticket-location">Location:</label>
        <select id="new-ticket-location" v-model="newTicket.locationId">
          <option value="">--Please select a location</option>
          <option
            v-for="location in $store.state.locations"
            :key="location.id"
            :value="location.id"
          >
            {{ location.name }}
          </option>
        </select>
      </div>

      <div class="form-pair">
        <label class="hidden-label" for="new-ticket-equipment"
          >Equipment:</label
        >
        <select id="new-ticket-equipment" v-model="newTicket.equipmentId">
          <option value="">--Please select an equipment</option>
          <option
            v-for="equipment in filteredEquipment"
            :key="equipment.id"
            :value="equipment.id"
          >
            {{ equipment.brand }} {{ equipment.model }} --{{
              equipment.serialNumber
            }}
          </option>
        </select>
      </div>

      <div class="form-pair">
        <label class="hidden-label" for="new-ticket-category"
          >Service Category:</label
        >
        <select id="new-ticket-category" v-model="newTicket.serviceCategoryId">
          <option value="">--Please select a service category</option>
          <option
            v-for="category in $store.state.serviceCategories"
            :key="category.id"
            :value="category.id"
          >
            {{ category.name }}
          </option>
        </select>
      </div>

      <div class="form-pair">
        <label>Description:</label>
        <textarea
          for=""
          placeholder="Description"
          v-model="newTicket.description"
        />
      </div>

      <div class="form-pair">
        <label class="hidden-label" for="new-ticket-contractor"
          >Contractor:</label
        >
        <select id="new-ticket-contractor" v-model="newTicket.contractorId">
          <option value="">--Please select a contractor</option>
        </select>
      </div>

      <div class="form-pair">
        <label for="new-ticket-estimate">Estimate:</label>
        <input
          id="new-ticket-estimate"
          type="number"
          step="0.01"
          placeholder="Estimate"
          v-model="newTicket.estimate"
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
export default {
  data() {
    return {
      newTicket: {
        locationId: "",
        equipmentId: "",
        serviceCategoryId: "",
        employeeId: 1,
        contractorId: "",
      },
    };
  },
  computed: {
    filteredEquipment() {
      return this.$store.state.equipment.filter((equipment) => {
        if (equipment.locationId === this.newTicket.locationId) {
          return equipment;
        }
      });
    },
  },
  methods: {
    addTicket() {
      this.$router.go();
    },
    hideForm() {
      this.$emit("hideForm");
    },
  },
};
</script>

<style>
</style>