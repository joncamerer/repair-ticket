import axios from 'axios'

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    create(conctractor) {
        return http.post('/contractors', conctractor);
    },

    list() {
        return http.get('/contractors');
    },

    get(id) {
        return http.get(`/conctractors/${id}`);
    }
}