<template>
  <div>
    {{ employee.firstName }}
    {{ employee.lastName }}
  </div>
</template>

<script>
export default {
  props: {
    employee: Object,
  },
};
</script>

<style>
</style>