import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListProductComponent from "./components/ListProductComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CreateProductComponent from "./components/CreateProductComponent";
import UpdateProductComponent from "./components/UpdateProductComponent";
import ViewProductComponent from "./components/ViewProductComponent";
import LoginComponent from "./components/LoginComponent";
import "./App.css";


class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoggedIn: false
        };
        this.handleLogin = this.handleLogin.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
    }

    handleLogin() {
        this.setState({ isLoggedIn: true });
    }

    handleLogout() {
        this.setState({ isLoggedIn: false });
    }

    render() {
        return (
            <div>
                <Router>
                    {/* Pass isLoggedIn and handleLogout as props to HeaderComponent */}
                    <HeaderComponent isLoggedIn={this.state.isLoggedIn} onLogout={this.handleLogout} />
                    <div className={"container"}>
                        <Switch>
                            <Route exact path="/auth/login" component={LoginComponent} />
                            <Route path="/product/getAll" component={ListProductComponent} />
                            <Route path="/product/add-product" component={CreateProductComponent} />
                            {/*<Route path="/product/update-product/:id" component={UpdateProductComponent} />*/}
                            <Route path="/product/:id" component={ViewProductComponent} />
                            <Route path="/" component={LoginComponent} />
                        </Switch>
                    </div>
                    <FooterComponent />
                </Router>
            </div>
        );
    }
}

export default App;
