import React from "react";
import { useTheme } from "./ThemeContext";
// import { useContext } from "react";
// import ThemeContext from './ThemeContext'

function ThemedComponent() {
    const {theme, setTheme} = useTheme(); // access to the context //useContext(ThemeContext); 
    return (
        <div>
            <p>Current Theme : {theme}</p>
            <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>Toggle Theme</button>
        </div>
    )
}

export default ThemedComponent

