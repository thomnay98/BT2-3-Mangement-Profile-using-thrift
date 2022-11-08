import axios from 'axios';

const BASE_URL = "http://localhost:8080/Client";
export const api = axios.create({
    baseURL: BASE_URL,
    withCredentials: true,
    allowCredentials : "true",
    headers: {
        'Content-Type': 'application/json', 
        'Accept': 'application/json',
    }
});