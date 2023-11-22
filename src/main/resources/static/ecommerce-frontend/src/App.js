import React from 'react';
import "./App.css";
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListProductComponent from "./components/ListProductComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CreateProductComponent from "./components/CreateProductComponent";
import UpdateProductComponent from "./components/UpdateProductComponent";
import ViewProductComponent from "./components/ViewProductComponent";

function App() {
    return (
        <div>
            <Router>
                <div>
                    <HeaderComponent/>
                    <div className={"container"}>
                        <Switch>
                            <Route path = "/" exact component = {ListProductComponent}></Route>
                            <Route path = "/product/getAll" component = {ListProductComponent}></Route>
                            <Route path = "/product/add-product" component = {CreateProductComponent}></Route>
                            {/*<Route path = "/product/update-product/:id" component = {UpdateProductComponent} ></Route>*/}
                            <Route path = "/product/:id" component = {ViewProductComponent}></Route>
                        </Switch>
                    </div>
                    <FooterComponent/>
                </div>
            </Router>
        </div>
    );
}

export default App;
