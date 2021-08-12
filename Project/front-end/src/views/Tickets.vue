<template>
  <div class="tickets">
    <ticket-list />
  </div>
</template>

<script>
import TicketList from "@/components/lists/TicketList.vue";

import categoryService from "@/services/CategoryService";

import locationService from "@/services/LocationService";

export default {
  name: "Tickets",
  components: {
    TicketList,
  },
  created() {
    locationService.list().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_LOCATIONS", response.data);
      }
    });
    categoryService.listPositions().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_POSITIONS", response.data);
      }
    });

    categoryService.listServiceCategories().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_SERVICE_CATEGORIES", response.data);
      }
    });

    categoryService.listEquipmentCategories().then((response) => {
      if (response.status === 200) {
        this.$store.commit("SET_EQUIPMENT_CATEGORIES", response.data);
      }
    });
  },
};
</script>

<style>
</style>