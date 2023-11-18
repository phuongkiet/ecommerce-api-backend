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
                        <div style={{marginLeft: 10}}><a href={"#"} className={"navbar-brand"}>Phone Management</a></div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;
