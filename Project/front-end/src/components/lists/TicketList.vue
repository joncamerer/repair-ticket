<template>
  <div id="ticket-list">
    <div class="list-title-button">
      <h1>Repair Tickets</h1>
      <button type="button" v-on:click="toggleShowForm()">
        {{ showForm ? "-" : "+" }}
      </button>
    </div>

    <div v-if="showForm">
      <new-ticket v-on:hideForm="toggleShowForm()" />
    </div>

    <div v-else>
      <ticket-summary
        v-for="ticket in tickets"
        :key="ticket.id"
        v-bind:ticket="ticket"
      />
    </div>
  </div>
</template>

<script>
import NewTicket from "@/components/forms/NewTicket";
import TicketSummary from "@/components/profiles/TicketSummary.vue";

import locationService from "@/services/LocationService";
import equipmentService from "@/services/EquipmentService";
import ticketService from "@/services/TicketService";

export default {
  components: {
    NewTicket,
    TicketSummary,
  },
  data() {
    return {
      tickets: [],
      showForm: false,
    };
  },
  created() {
    locationService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_LOCATIONS", response.data);
      }
    });
    equipmentService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_EQUIPMENT", response.data);
        this.equipment = this.$store.state.equipment;
      }
    });
    ticketService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_TICKETS", response.data);
        this.tickets = this.$store.state.tickets;
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