import axios from "axios";
import { useEffect } from "react";

const MyPage = () => {
    axios.defaults.headers.common['Authorization'] = 'Bearer ' + localStorage.getItem('accessToken');

    useEffect(async()=>{
        const result = await axios.get("/test/validate");
        if(result.status === 200){
            console.log('success');
            console.log(result.data);
        }
    },[])

    return (<>
        <h1>MyPage</h1>
    </>);
}

export default MyPage;