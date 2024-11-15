import React from "react";
import { useReducer } from "react";

//useReducer demo

const initialState = { count: 0 };

//Reducer fun to handle state changes
function reducer(state, action) {
    //console.log('render...')
    switch (action.type) {
        case 'increment':
            console.log('pay load', action.payload)
            return { count: state.count + action.payload }
        case 'decrement':
            return { count: state.count - 1 }
        default:
            return state
    }
}

function Counter1() {
    const [state, dispatch] = useReducer(reducer, initialState)
    return (
        <div>
            <p>Count: {state.count}</p>
            <button onClick={() => dispatch({ type: 'increment', payload: 5 })}>Increment</button>
            <button onClick={() => dispatch({ type: 'decrement' })}>Decrement</button>
        </div>
    )
}

export default Counter1