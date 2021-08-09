import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home'
import Tickets from '@/views/Tickets'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/tickets',
    name: 'Tickets',
    component: Tickets
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
