import logo from './logo.svg';
import './App.css';
import Product from './Product/Product';
import { useState } from 'react';

function App() {
  const [count, setCount] = useState(0) // useEffect(), useLayoutEffect.

  const countHandler = () => {
    setCount(count + 1);
  }

  const [products, setProducts] = useState(
    [
      { name : "iPhone 15", price : 900},
      { name : "iPhone 14", price : 800}
    ]
  ) 

  const productList = products.map( product => {
    return(
      <div>
        <Product name = {product.name} price = {product.price}/>
      </div>
    )
  })


  return (
    <div className="App">
     <Product name = "iPhone 16" price = {1000}/>
     <Product name = {products[0].name} price = {products[0].price}/>
      <div>{count}</div>
       <button onClick={countHandler}>Increase Count</button>
    </div>
  );
}

export default App;
