import React from "react";
import { useState } from "react";

// useState demo
function Counter({initialCount}){
    const [count, setCount] = useState(initialCount) // to manage the value in virtual dom
    
    //let count = 0; //constant variable.
    return(
        <div>
            <p>Count : {count}</p>
            <button onClick={() => setCount(initialCount)}>Reset</button>
            <button onClick={() => setCount(prevCount => prevCount - 1)}>-</button>
            <button onClick={() => setCount(prevCount => prevCount + 1)}>+</button>
        </div>
    );
}

export default Counter
