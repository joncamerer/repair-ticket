<template>
  <div id="login">
    <form id="login-form" v-on:submit.prevent="login()">
      <div class="form-pair">
        <label class="hidden-label" for="login-username">Username:</label>
        <input
          id="login-username"
          type="text"
          placeholder="Username"
          v-model="user.username"
          autofocus
          required
        />
      </div>

      <div class="form-pair">
        <label class="hidden-label" for="login-password">Passowrd:</label>
        <input
          id="login-password"
          type="text"
          placeholder="Password"
          v-model="user.password"
          required
        />
      </div>

      <button type="submit">Log in</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    login() {
      console.log("logged in");
    },
  },
};
</script>

<style>
#login {
  display: flex;
  justify-content: center;
}

#login-form {
  display: flex;
  flex-direction: column;
}
</style>