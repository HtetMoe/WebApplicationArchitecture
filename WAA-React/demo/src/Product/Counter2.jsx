import React from "react";
import { useState, useCallback } from "react";

// useCallback demo
const Counter2 = () => {
    const [count, setCount] = useState(0);

    //This function is recreated every time the component re-renders
    // const increment = () => {
        // const id = Math.random();
        // console.log("id ", id)
    //     setCount(count + 1);
    // };

    //memorizing increment fun, this will be recreated only if `count` changes
    const increment = useCallback(() => {
        // const id = Math.random();
        // console.log("id ", id)
        setCount(prevCount => prevCount + 1);
    }, []);

    return (
        <div>
            <p>Count: {count}</p>
            <button onClick={increment}>Increment</button>
        </div>
    );
}

export default Counter2