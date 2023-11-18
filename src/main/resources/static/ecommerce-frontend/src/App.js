import React from 'react';
import "./App.css";
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ListProductComponent from "./components/ListProductComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";

function App() {
    return (
        <div>
            <Router>
                <div className={"container"}>
                    <HeaderComponent/>
                    <div className={"container"}>
                        <Routes>
                            <Route path = "/" element = {<ListProductComponent />}></Route>
                            <Route path = "/product/getAll" element = {<ListProductComponent />}></Route>
                        </Routes>
                    </div>
                    <FooterComponent/>
                </div>
            </Router>
        </div>
    );
}

export default App;
