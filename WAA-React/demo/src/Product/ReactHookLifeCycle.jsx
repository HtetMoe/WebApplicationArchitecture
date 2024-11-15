import React from "react";
import { useState, useEffect } from "react";

// React Hook LifeCycle
function ReactHookLifeCycle() {
    const [count, setCount] = useState(0);

    // mounting: Runs once when the component is mounted // coming to a page
    useEffect(() => {
        console.log('Component mounted');

        // unmounting: Cleanup function runs when the component is unmounted // goback to previous page
        return () => {
            console.log('Component unmounted');
        };
    }, []); // Empty dependency array ensures it runs only once on mount and unmount


    // updating: Runs every time the component re-renders (when 'count' changes)
    useEffect(() => {
        console.log('Component updated, count is:', count);
    }, [count]); // Runs every time 'count' changes

    return (
        <div>
            <h1>Count: {count}</h1>
            <button onClick={() => setCount(count + 1)}>Increment</button>
        </div>
    );
}

export default ReactHookLifeCycle;