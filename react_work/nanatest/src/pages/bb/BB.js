import React, { useState } from 'react';

export const BB = () => {
    const [data, setData] = useState("안녕하세요");

    const functiona = async () => {
        console.log("aaa");
        console.log("setData" + setData);
    };
    return (
        <div>
            <h3>{data}</h3>
            <h1>BB</h1>
            <button onClick={functiona} style={{
                width: "100px",
                height: "50px",
                backgroundColor: "red",
                border: "none",
                color: "white",
                fontSize: "20px"
            }}>버튼</button>
        </div>
    )
};