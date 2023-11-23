import React, {Component} from 'react';
import UserService from "../services/UserService"

class LoginComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            jwt: '',
            active: "login",
            username: '',
            password: '',
            onLogin: props.onLogin
        }
        this.handleUsernameChange = this.handleUsernameChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
    }

    loginSubmit = (e) => {
        e.preventDefault();
        let user = {username: this.state.username, password: this.state.password};
        console.log('user => ' + JSON.stringify(user));

        UserService.login(user).then(res => {
            console.log('Response => ', res);

            // Check if the response has the expected structure
            if (res.data && res.data.jwt) {
                localStorage.setItem("token", res.data.jwt);
                this.props.history.push("/product/getAll");
            } else {
                // Handle the case where the token is not present in the response
                console.error("JWT token not found in the response");
            }
        });
    }

    handleUsernameChange = (e) => {
        this.setState({username: e.target.value});
    };

    handlePasswordChange = (e) => {
        this.setState({password: e.target.value});
    };

    render() {
        return (
            <div>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-4">
                            <div className={"card mt-5 mb-5"}>
                                <h3 className={"text-center mt-4"}>Login Page</h3>
                                <div class="card-body">
                                    <form onSubmit={this.loginSubmit}>
                                        <div class="mb-3">
                                            <label for="username" class="form-label">Username</label>
                                            <input type="text" class="form-control" id="username"
                                                   value={this.state.username}
                                                   onChange={this.handleUsernameChange}/>
                                        </div>
                                        <div class="mb-3">
                                            <label for="password" class="form-label">Password</label>
                                            <input type="password" class="form-control" id="password"
                                                   value={this.state.password}
                                                   onChange={this.handlePasswordChange}/>
                                        </div>
                                        <div class="mb-3">
                                            <a href="#">Forgot password?</a>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Login</button>
                                    </form>
                                    <div class="mt-3">
                                        Not yet a member? <a href="#">Sign up now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default LoginComponent;