import React from "react";
import { useState, useEffect } from "react";
function TitleUpdater() {
    const [count, setCount] = useState(0);

    //update the document title when count changes 
    // control when to run the logic
    useEffect(() => {
        document.title = `Count: ${count}`;
        console.log('title => ', document.title)
    }, [count]); // The effect runs only when `count` changes


    return (
        <div>
            <h1>Count: {count}</h1>
            <button onClick={() => setCount(count + 1)}>Increase Count</button>
        </div>
    )
}

export default TitleUpdater