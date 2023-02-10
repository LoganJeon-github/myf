import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import axios from 'axios'
// import store from './store/store'

loadFonts()

const app = createApp(App)
app.config.globalProperties.$axios = axios;
app.use(vuetify).mount('#app')
// createApp(App)
//   .use(vuetify).use(axios)
//   .mount('#app')
