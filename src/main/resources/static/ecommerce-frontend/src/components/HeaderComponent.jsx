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
                <header className={"App-header"}>
                    <nav>
                        <div style={{marginLeft: "10px", fontSize: "25px"}}><span className={"text-white fw-bold"}>Phone Management</span></div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;
