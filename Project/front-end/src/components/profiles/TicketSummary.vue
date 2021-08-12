<template>
  <div id="ticket-summary">- {{ ticket.description }}</div>
</template>

<script>
export default {
  props: {
    ticket: Object,
  },
};
</script>

<style>
</style>