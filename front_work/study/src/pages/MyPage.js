import React,{useEffect} from 'react';

const MyPage = () => {

    useEffect(() => {
        const accessToken ="asdfasdf";
        localStorage.setItem("memberInfo",JSON.stringify({accessToken}));
    },[]);
    return (<>
        <h1>MyPage</h1>
    </>);
}

export default MyPage;