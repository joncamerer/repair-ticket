<template>
  <div class="tickets">
    <ticket-list />
  </div>
</template>

<script>
import TicketList from "@/components/lists/TicketList.vue";
export default {
  name: "Tickets",
  components: {
    TicketList,
  },
};
</script>

<style>
</style>