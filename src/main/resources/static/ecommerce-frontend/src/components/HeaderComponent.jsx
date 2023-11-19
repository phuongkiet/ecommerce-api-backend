import React, {Component} from 'react';

class HeaderComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {

        }
    }
    render() {
        return (
            <div>
                <header>
                    <nav className={"navbar navbar-expand-md navbar-dark bg-dark"}>
                        <div style={{marginLeft: "10px", fontSize: "25px"}}><span className={"text-white fw-bold"}>Phone Management</span></div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;
