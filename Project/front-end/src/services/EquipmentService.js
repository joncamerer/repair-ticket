import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    create(equipment) {
        return http.post('/equipment', equipment);
    },

    list() {
        return http.get('/equipment');
    },

    get(id) {
        return http.get(`/equipment/${id}`);
    }
}