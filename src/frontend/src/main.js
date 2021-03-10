import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import mixins from "@/mixins";
import VueQuillEditor from 'vue-quill-editor'

import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme

createApp(App).use(VueQuillEditor, {}); // config is optional. more below

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min'
import 'popper.js/dist/popper'
import 'jquery/dist/jquery.min'
import 'bootstrap/dist/js/bootstrap.min'
import '@ocrv/vue-tailwind-pagination/dist/style.css'
createApp(App).use(router).mixin(mixins).mount('#app')
