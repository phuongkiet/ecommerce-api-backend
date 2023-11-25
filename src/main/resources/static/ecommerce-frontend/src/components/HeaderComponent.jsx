import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';

class HeaderComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            isLoggedIn: true
        };
    }

    logout = () => {
        console.log("Logging out...");
        localStorage.removeItem("token");
        this.setState({ isLoggedIn: false });
        this.props.history.push("/auth/login");
    };


    render() {
        return (
            <div>
                <header className={"App-header"}>
                    <nav className="navbar navbar-expand-lg">
                        <div className="container">
                            <span className={"navbar-brand text-white fw-bold"}>Phone Management</span>
                            <div>
                                {this.state.isLoggedIn && (
                                    <button onClick={this.logout} className="btn btn-primary" style={{ marginLeft: "10px", position: "relative", left: "954px", top: "-5px" }}>Logout</button>
                                )}
                                {!this.state.isLoggedIn && (
                                    <button onClick={() => this.props.history.push("/auth/login")} className="btn btn-primary" style={{ marginLeft: "10px", position: "relative", left: "954px", top: "-5px" }}>Login</button>
                                )}
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

// Wrap HeaderComponent with withRouter to access the history prop
export default withRouter(HeaderComponent);
