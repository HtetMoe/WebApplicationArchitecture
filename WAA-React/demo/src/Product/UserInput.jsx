import React, {useRef } from 'react';

function UserInput() {
    //a ref to store the input value
    const inputRef = useRef();
    const divRef = useRef();

    const handleSubmit = () => {
        console.log('current ', divRef.current) // div dome element
        console.log('current ', useRef.current) // input dom elemet

        alert('User Input: ' + inputRef.current.value);
    };

    return (
        <div ref={divRef}>
            <input ref={inputRef} type="text" placeholder="Type something..."/>
            <button onClick={handleSubmit}>Submit</button>
        </div>
    );
};

export default UserInput;