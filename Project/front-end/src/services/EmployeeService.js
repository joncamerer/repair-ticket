import axios from 'axios'

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    create(employee) {
        return http.post('/employees', employee);
    },

    get(id) {
        return http.get(`/employees/${id}`);
    }
}