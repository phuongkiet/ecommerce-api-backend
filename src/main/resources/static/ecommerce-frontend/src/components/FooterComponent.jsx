import React, {Component} from 'react';

class FooterComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {

        }
    }
    render() {
        return (
            <div>
                <footer className={"App-footer"}>
                    <span className={"foooter-text"}>All rights reserved 2023 @phuongkiet</span>
                </footer>
            </div>
        );
    }
}

export default FooterComponent;
