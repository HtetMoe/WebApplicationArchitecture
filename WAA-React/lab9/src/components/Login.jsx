import React from 'react'
import { useNavigate } from "react-router-dom";
import { useState } from 'react';

export const Login = () => {
    const navigate = useNavigate(); // Hook to navigate after login
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();

        //check input
        if (!username || !password) {
            setErrorMessage("Please enter both username and password.");
            return;
        }

        if (username == 'admin' && password == '111') {
            alert('Login successfull!')
            navigate("/posts");
        }
    }
    return (
        <div>
            <h3>Login</h3>
            {errorMessage && <div style={{ color: "red" }}>{errorMessage}</div>}
            <form onSubmit={handleSubmit}>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Enter username" required />
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Enter password" required />
                <button type="submit">Login</button>
            </form>
        </div>
    )
}
