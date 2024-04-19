
import React from 'react';
import { Link } from 'react-router-dom';

const BaiscLayout = ({ children }) => {
    return (
        <>
            <div className="App-header">
                <h1>Header</h1>
                <div>{children}</div>
            </div>
            <div className="App-footer">
                <h1>Footer</h1>
                <Link to="/">Home</Link>
                <Link to="/about">About</Link>
                <Link to="/contact">Contact</Link>
                <Link to="/mypage">MyPage</Link>
                <Link to="/kakaomaps">location</Link>
            </div>
        </>
    );
}

export default BaiscLayout;