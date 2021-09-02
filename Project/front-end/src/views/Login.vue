<template>
  <div>
    <h1>Log In Splash Page</h1>
    <p>Welcome to our BoH protal</p>
    <user-login />
  </div>
</template>

<script>
import UserLogin from "@/components/forms/UserLogin.vue";

export default {
  name: "Login",

  components: { UserLogin },
};
</script>

<style>
</style>