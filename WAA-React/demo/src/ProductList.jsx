import React from "react";
import Product from './Product/Product';
import { useState, useEffect } from "react";

const ProductList = () => {
    const [count, setCount] = useState(0) // useEffect(), useLayoutEffect.

    const countHandler = () => {
        setCount(count + 1);
    }

    const [products, setProducts] = useState(
        [
            { name: "iPhone 15", price: 900 },
            { name: "iPhone 14", price: 800 }
        ]
    )

    const flag = false
    useEffect(() => {
        //your actions
    }, flag) // every time flag is change, process the code block {}

    const productList = products.map(product => {
        return (
            <div>
                <Product name={product.name} price={product.price} />
            </div>
        )
    })

    return (
        <div>
            <Product name="iPhone 16" price={1000} />
            <Product name={products[0].name} price={products[0].price} />
            <div>{count}</div>
            <button onClick={countHandler}>Increase Count</button>
        </div>
    )
}

export default ProductList;