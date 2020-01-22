import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App'
import Report from './components/Report'
import Reported from './components/Reported'

Vue.use(VueRouter)

const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '',
            component: App,
            children: [
                {
                    path: '',
                    redirect: 'report'
                },
                {
                    path: 'report',
                    component: Report,                 
                },
                {
                    path: '/reported',
                    component: Reported
                },
               
            ]
        }
    ]
})

export default router;