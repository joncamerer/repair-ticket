import { createRouter, createWebHistory } from 'vue-router'
import Dashboard from '@/views/Dashboard'
import Login from '@/views/Login'
import Tickets from '@/views/Tickets'

const routes = [
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: Dashboard
  },
  {
    path: '/tickets',
    name: 'Tickets',
    component: Tickets
  },
  {
    path: "/:pathMatch(.*)*",
    component: Login
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
