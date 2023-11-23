import axios from "axios";

const USER_API_BASE_URL = "http://localhost:8080/auth/";

class UserService {
    login(user){
        let data = JSON.stringify(user);

        let config = {
            method: 'post',
            maxBodyLength: Infinity,
            url: USER_API_BASE_URL + 'login',
            headers: {
                'Content-Type': 'application/json'
            },
            data : data
        };

        return axios.request(config);
    }
}

const userService = new UserService();

export default userService;
