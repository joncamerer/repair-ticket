<template>
  <div id="nav">
    <router-link to="/dashboard">Dashboard</router-link> |
    <router-link to="/tickets">Tickets</router-link>
  </div>
  <router-view />
</template>

<style>
html {
  display: flex;

  height: 100vh;
  width: 100vw;
}

body {
  display: flex;
  flex-grow: 1;
}

#app {
  display: flex;
  flex-direction: column;
  flex-grow: 1;

  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
  height: 3vh;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.hidden-label {
  display: none;
}

.list-title-button {
  display: flex;
  justify-content: space-between;

  margin-bottom: 10px;
}

.list-title-button > h1 {
  margin-bottom: 0;
  margin-top: 0;
}

.list-title-button > button {
  height: 2em;
  width: 2em;
}

.form-title {
  margin: 0;
  font-size: 1.5em;
}

.form-pair {
  display: flex;
}
</style>
