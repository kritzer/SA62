import Vue from 'vue'
import App from './App'
import Vuetify from 'vuetify'
import router from './router'
Vue.use(Vuetify)
Vue.config.productionTip = false

import VueLogger from 'vuejs-logger';
import vuetify from './plugins/vuetify';

const options = {
  isEnabled: true,
  logLevel : 'debug',
  stringifyArguments : false,
  showLogLevel : true,
  showMethodName : false,
  separator: '|',
  showConsoleColors: true
};

Vue.use(VueLogger, options);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  vuetify,
  router,
  components: { App }
});