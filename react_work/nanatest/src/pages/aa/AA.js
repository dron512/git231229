
import React, { useState } from 'react';
import { aa } from '../../api/aa/aa';



export const AA = ()=>{

    const [data, setData] = useState("asdnfklcjqwnelrkjewnr");  

    return(
        <div>
            <h1>구분을</h1>
            <h2>{data}</h2>
            <button onClick={()=>{
                aa(setData);
            }}>버튼</button>
            
        </div>
    )
}