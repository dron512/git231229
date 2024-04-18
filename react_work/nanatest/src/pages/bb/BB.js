import React, { useState } from 'react';
import { aaa } from '../../api/bbb/aaa';

export const BB = () => {
    const [data, setData] = useState("안녕하세요");

    return(
        <div>
            <h3>{data}</h3>
            <h1>BB</h1>
            <button onClick={()=>{
                aaa(data,setData);
            }} style={{
                width: "100px",
                height: "50px",
                backgroundColor: "red",
                color: "white",
                fontSize: "20px"
            }}>버튼</button>
        </div>
    )
};