<template>
  <div>
    {{ contractor.firstName }}
    {{ contractor.lastName }}
  </div>
</template>

<script>
export default {
  props: {
    contractor: Object,
  },
};
</script>

<style>
</style>