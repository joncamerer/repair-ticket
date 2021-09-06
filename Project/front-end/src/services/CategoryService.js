import axios from 'axios'

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    listPositions() {
        return http.get('/positions');
    },

    listServiceCategories() {
        return http.get('/services');
    },

    listEquipmentCategories() {
        return http.get('/categories');
    },

    listAll() {
        return http.get('/category')
    }
}