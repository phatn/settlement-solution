import axios from 'axios';

let restRequest = axios.create();

restRequest.interceptors.response.use(function(response) {
    return response;
})

restRequest.interceptors.request.use(function(request) {
    return request;
})

export { restRequest };