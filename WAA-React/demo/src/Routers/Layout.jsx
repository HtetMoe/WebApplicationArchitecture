import { Outlet, Link } from "react-router-dom";

const Layout = () => {
    return (
        <>
            <header style={{ backgroundColor: '#00bcd4', textAlign: 'center' }}>
                <nav style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                    <ul style={{ display: 'flex', listStyleType: 'none' }}>
                        <li style={{ margin: '15px' }}> <Link to="/">Home</Link>  </li>
                        <li style={{ margin: '15px' }}> <Link to="/about">About</Link> </li>
                        <li style={{ margin: '15px' }}> <Link to="/contact">Contact</Link> </li>
                    </ul>
                </nav>
            </header>

            <main>
                <Outlet />
            </main>
        </>
    )
};

export default Layout;