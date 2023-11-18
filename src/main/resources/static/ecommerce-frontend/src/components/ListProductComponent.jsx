import React, {Component} from 'react';
import ProductService from "../services/ProductService";

class ListProductComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            products: []
        }
    }
    componentDidMount() {
        ProductService.getProducts().then((res) => {
            this.setState({products: res.data});
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Product List</h2>
                <div className="row">
                    <table className={"table table-striped table-bordered"}>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Short Description</th>
                                <th>Long Description</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Category</th>
                                <th>Enabled</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.products.map(
                                product =>
                                    <tr key={product.id}>
                                        <td>{product.id}</td>
                                        <td>{product.name}</td>
                                        <td>{product.shortDescription}</td>
                                        <td>{product.longDescription}</td>
                                        <td>{product.price}</td>
                                        <td>{product.inventory.quantity}</td>
                                        <td>{product.category.categoryName}</td>
                                        <td>{product.enabled ? 'Available' : 'Not Available'}</td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListProductComponent;