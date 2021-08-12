<template>
  <div>
    {{ equipment.brand }}
    {{ equipment.model }}
  </div>
</template>

<script>
export default {
  props: {
    equipment: Object,
  },
};
</script>

<style>
</style>