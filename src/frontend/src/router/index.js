import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import ContentCreate from '../views/ContentCreate'
import ContentDetail from '../views/ContentDetail'
import ContactView from "@/views/ContactView";
import News from "@/views/News";
import Search from "@/views/Search";
import ContentUpdate from "@/views/ContentUpdate";

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/content/create',
    name: 'ContentCreate',
    component: ContentCreate
  },
  {
    path: '/content/detail',
    name: 'ContentDetail',
    component: ContentDetail
  },
  {
    path: '/contact',
    name: 'ContactView',
    component: ContactView
  },
  {
    path: '/news',
    name: 'News',
    component: News
  },
  {
    path: '/content/search',
    name: 'search',
    component: Search
  },
  {
    path: '/content/update',
    name: 'ContentUpdate',
    component: ContentUpdate
  },
]


const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

