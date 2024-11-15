import React from "react";
import { Outlet, Link } from "react-router-dom";
import './Layout.css';

const Layout = () => {
    return (
        <>
            <header>
                <nav>
                    <ul>
                        <li> <Link to="/posts" className="nav-link">Posts</Link> </li>
                        <li> <Link to="/add" className="nav-link">New Post</Link> </li>
                        <li> <Link to="/signin" className="nav-link">Sign In</Link> </li>
                    </ul>
                </nav>
            </header>

            <main>
                <Outlet />
            </main>
        </>
    );
};

export default Layout;
