import React, {Component} from 'react';
import ProductService from "../services/ProductService";

class UpdateProductComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
            name: '',
            shortDescription: '',
            longDescription: '',
            price: '',
            quantity: '',
            categoryId: ''
        }

        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeShortDescriptionHandler = this.changeShortDescriptionHandler.bind(this);
        this.changeLongDescriptionHandler = this.changeLongDescriptionHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);
        this.changeQuantityHandler = this.changeQuantityHandler.bind(this);
        this.changeCategoryIdHandler = this.changeCategoryIdHandler.bind(this);
        this.updateProduct = this.updateProduct.bind(this);
    }
    componentDidMount() {
        ProductService.getProductById(this.state.id).then((res) => {
            let product = res.data;
            this.setState({name: product.name, shortDescription: product.shortDescription, longDescription: product.longDescription,
                                price: product.price, quantity: product.inventory.quantity, categoryId: product.category.categoryName});
        });
    }

    updateProduct = (e) => {
        e.preventDefault();
        let product = {name: this.state.name, shortDescription: this.state.shortDescription, longDescription: this.state.longDescription,
            price: this.state.price, quantity: this.state.quantity, categoryId: this.state.categoryId}
        console.log('product => ' + JSON.stringify(product));
    }
    changeNameHandler = (event) => {
        this.setState({name: event.target.value});
    }
    changeShortDescriptionHandler = (event) => {
        this.setState({shortDescription: event.target.value});
    }
    changeLongDescriptionHandler = (event) => {
        this.setState({longDescription: event.target.value});
    }
    changePriceHandler = (event) => {
        this.setState({price: event.target.value});
    }
    changeQuantityHandler = (event) => {
        this.setState({quantity: event.target.value});
    }
    changeCategoryIdHandler = (event) => {
        this.setState({categoryId: event.target.value});
    }

    cancel(){
        this.props.history.push('/product/getAll');
    }
    render() {
        return (
            <div>
                <div className={"container"}>
                    <div className={"row"}>
                        <div className={"card col-md-6 offset-md-3 offset-md-3 mt-5 mb-5"}>
                            <h3 className={"text-center mt-4"}>Update Product</h3>
                            <div className={"card-body"}>
                                <form>
                                    <div className={"form-group"}>
                                        <label>Name:</label>
                                        <input className={"form-control"} placeholder={"Product Name"} name={"name"}
                                               value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className={"form-group mt-3"}>
                                        <label>Short Description:</label>
                                        <input className={"form-control"} placeholder={"Short description of product"} name={"shortDescription"}
                                               value={this.state.shortDescription} onChange={this.changeShortDescriptionHandler}/>
                                    </div>
                                    <div className={"form-group mt-3"}>
                                        <label>Long Description:</label>
                                        <input className={"form-control"} placeholder={"Long description of product"} name={"longDescription"}
                                               value={this.state.longDescription} onChange={this.changeLongDescriptionHandler}/>
                                    </div>
                                    <div className={"form-group mt-3"}>
                                        <label>Price:</label>
                                        <input className={"form-control"} placeholder={"Price of product"} name={"price"}
                                               value={this.state.price} onChange={this.changePriceHandler}/>
                                    </div>
                                    <div className={"form-group mt-3"}>
                                        <label>Quantity:</label>
                                        <input className={"form-control"} placeholder={"Quantity of product"} name={"quantity"}
                                               value={this.state.quantity} onChange={this.changeQuantityHandler}/>
                                    </div>
                                    <div className={"form-group mt-3 mb-3"}>
                                        <label>Category:</label>
                                        <input className={"form-control"} placeholder={"Category"} name={"category"}
                                               value={this.state.categoryId} onChange={this.changeCategoryIdHandler}/>
                                    </div>

                                    <button className={"btn btn-success"} onClick={this.updateProduct}>Save</button>
                                    <button className={"btn btn-danger"} onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default UpdateProductComponent;