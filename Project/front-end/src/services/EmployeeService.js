import axios from 'axios'

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    create(employee) {
        return http.post('/employees', employee);
    },

    list() {
        return http.get('employees');
    },

    get(id) {
        return http.get(`/employees/${id}`);
    }
}