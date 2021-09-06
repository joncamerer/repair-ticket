<template>
  <div class="tickets">
    <ticket-list />
  </div>
</template>

<script>
import TicketList from "@/components/lists/TicketList.vue";

import categoryService from "@/services/CategoryService";

export default {
  name: "Tickets",
  components: {
    TicketList,
  },
  created() {
    categoryService.listAll().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_CATEGORIES", response.data);
      }
    });
  },
};
</script>

<style>
</style>