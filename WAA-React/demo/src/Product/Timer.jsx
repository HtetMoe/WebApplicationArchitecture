import React from "react";
import { useState, useEffect } from "react";

function Timer() {
    const [seconds, setSeconds] = useState(0);

    useEffect(() => {
    }
    )

    return (
        <div>
            <p>Timer: {seconds} seconds</p>
        </div>
    )
}

export default Timer;
// import {Route, Routes, Navigate} from "react-router"

// export default function PagesRoute(props){
//     return( // posts, post by id, post detail, add post
//         <Route path="/" element={"<Navigate replace to ="/products"}/>
//         <Route path="[/products" element={""}/>
//         <Route path="/" element={""}/>
//         <Route path="/" element={""}/>
//     )
// }