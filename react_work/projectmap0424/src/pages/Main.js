import axios from 'axios';
import { useEffect } from 'react';
import { Link } from 'react-router-dom';

const Main = () => {
    const doData = async()=>{
        console.log("test");
        const data = {
            id: 0,
            name: '레',
          };

        const token = localStorage.getItem("access_token");

        const result = await axios.post('search/name', data, {
            headers: {
              'Authorization': `Bearer ${token}`
            }
          })
        console.log(result.data);
    }

    

    
    return ( 
        <>
            <h1>Main</h1>
            <Link className='main-link' to="/login">Login</Link>
            <Link className='main-link' to="/map">Map</Link>
            <Link className='main-link' to="/login/create">Create</Link>
            <button onClick={doData}>데이터가져오기</button>
        </>
     );
}
 
export default Main;