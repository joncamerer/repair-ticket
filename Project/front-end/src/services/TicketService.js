import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    create(ticket) {
        return http.post('/tickets', ticket);
    },

    list() {
        return http.get('/tickets');
    },

    listById(id) {
        return http.get(`/ticlets/${id}`);
    }
}