<template>
  <div id="ticket-summary">
    <p>{{ parseDate() }}</p>
    <p>{{ getLocation() }}</p>
    <p>{{ ticket.description }}</p>
  </div>
</template>

<script>
export default {
  props: {
    ticket: Object,
  },
  methods: {
    getLocation() {
      var location = this.$store.state.locations.find(
        (e) => e.id === this.ticket.locationId
      );

      return location.name;
    },
    parseDate() {
      var date = new Date(this.ticket.submittedOn);

      return date.toDateString();
    },
  },
};
</script>

<style>
#ticket-summary {
  display: flex;
  justify-content: center;
}

#ticket-summary > p {
  margin-right: 5%;
}
</style>