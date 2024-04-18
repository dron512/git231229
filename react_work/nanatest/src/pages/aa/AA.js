import React, { useState } from 'react';
import { aa } from '../../api/aa/aa';

export const AA = () => {

    const [data, setData] = useState("asdnfklcjqwnelrkjewnr");
    return (
        <div>
            <h1>구분을</h1>
            <h2>{data}</h2>
            <button onClick={() => {
                aa(setData);
            }}>버튼</button>

        </div>
    )
}

export const AA2 = () => {

    const [data, setData] = useState("asdnfklcjqwnelrkjewnr");
    const [myData, setMyData] = useState("원래Data");

    const sucessDataA = (asdf) => {
        setData(asdf);
    }
    const sucessDataB = (asdf) => {
        setMyData(asdf);
    }

    return (
        <div>
            <h1>구분을</h1>
            <h2>{data}</h2>
            <h2>{myData}</h2>
            <button onClick={() => {
                aa({ sucessDataA, sucessDataB });
            }}>버튼</button>

        </div>
    )
}