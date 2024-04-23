
import NotificationsIcon from '@mui/icons-material/Notifications';
import SettingsIcon from '@mui/icons-material/Settings';
import { Button, IconButton } from '@mui/material';
import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

const BaiscLayout = ({ children }) => {

    const navigate = useNavigate();
    const handleClick = () => {
        // 클릭 이벤트 핸들러
        console.log('Notification icon clicked!');
    };
    const MoveMain = () => {
        navigate('/');
    }
    return (
        <>
            <div className="App-header">
                <div style={{ display: 'flex', flexDirection: 'row' }}>
                    <IconButton onClick={MoveMain}>
                        <h1>MyPage</h1>
                    </IconButton>
                    <div style={{ marginLeft: "11rem", marginTop: "0.5rem", marginBottom: "1rem" }}>
                        <IconButton onClick={handleClick}>
                            <NotificationsIcon />
                        </IconButton>
                        <IconButton onClick={handleClick}>
                            <SettingsIcon />
                        </IconButton>
                    </div>
                </div>
            </div>
            <div className='App-main'>{children}</div>
            <div className="App-footer">
                <h1>Footer</h1>
                <Button variant="outlined" sx={{height:'2rem'}}><Link to="/">Home</Link></Button>
                <Link to="/about">About</Link>
                <Link to="/contact">Contact</Link>
                <Link to="/filesupload">files</Link>
                <Link to="/login/login">login</Link>
                <Link to="/login/mypage">mypage</Link>
            </div>
        </>
    );
}

export default BaiscLayout;