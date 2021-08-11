import axios from 'axios'

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    create(location) {
        return http.post('/locations', location);
    },

    list() {
        return http.get('/locations');
    },

    get(id) {
        return http.get(`/locations/${id}`);
    }
}