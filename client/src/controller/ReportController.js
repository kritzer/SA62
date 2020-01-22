import axios from 'axios'  
  
const SERVER_URL = 'http://localhost:9000';  
  
const instance = axios.create({  
  baseURL: SERVER_URL,  
  timeout: 1000  
});  
  
export default {  
  
    getAllRepType: () => instance.get('repType/repTypes', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),
    getMember: () => instance.get('/member', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),
    getAllRating: () => instance.get('rating/rating', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),

    findReportAll: () => instance.get('report/reported', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),

    addReport: (data) => instance.post('report/report/add', {
        repType: data.repType,
        member: data.member,
        title: data.title,
        repDetail: data.repDetail,
        rating: data.rating
    })
}