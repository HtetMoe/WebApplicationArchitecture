import React from "react";

function Welcome(props) { 
    // props = receives props as a single object.
    // {name} = props of an object, need to be destructured again.
    return <h4>Hello {props.name}</h4>;
}

function ComposingComponents() {
    return (
        <div>
            <Welcome name="User1" />
            <Welcome name="User2" />
            <Welcome name="User3" />
        </div>
    );
}

export default ComposingComponents