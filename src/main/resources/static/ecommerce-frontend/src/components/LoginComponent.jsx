import React, {Component} from 'react';
import UserService from "../services/UserService"
import {jwtDecode} from 'jwt-decode';

class LoginComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoggedIn: false,
            jwt: '',
            active: "login",
            username: '',
            password: '',
            onLogin: props.onLogin,
            onLogout: props.onLogout
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

                let decoded = jwtDecode(res.data.jwt);
                console.log('Decoded => ', decoded);
                if (decoded.roles.includes('ROLE_ADMIN') || decoded.roles.includes('ROLE_MANAGER')) {
                    this.props.history.push("/product/getAll");
                } else if (decoded.roles.includes('ROLE_USER')) {
                    this.props.history.push("/home");
                }

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
                <div className="container">
                    <div className="row justify-content-center">
                        <div className="col-md-4">
                            <div className={"card mt-5 mb-5"}>
                                <h3 className={"text-center mt-4"}>Login Page</h3>
                                <div className="card-body">
                                    <form onSubmit={this.loginSubmit}>
                                        <div className="mb-3">
                                            <label className="form-label">Username</label>
                                            <input type="text" className="form-control" id="username"
                                                   value={this.state.username}
                                                   onChange={this.handleUsernameChange}/>
                                        </div>
                                        <div className="mb-3">
                                            <label className="form-label">Password</label>
                                            <input type="password" className="form-control" id="password"
                                                   value={this.state.password}
                                                   onChange={this.handlePasswordChange}/>
                                        </div>
                                        <div className="mb-3">
                                            <a href="#">Forgot password?</a>
                                        </div>
                                        <button type="submit" className="btn btn-primary">Login</button>
                                    </form>
                                    <div className="mt-3">
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