import React, { useEffect } from 'react';
import { getLottoNumber } from '../api/home/homePageApi';

const Home = () => {
    const initData = {
        "totSellamnt": 81032551000,
        "returnValue": "success",
        "drwNoDate": "2019-06-01",
        "firstWinamnt": 4872108844,
        "drwtNo6": 25,
        "drwtNo4": 21,
        "firstPrzwnerCo": 4,
        "drwtNo5": 22,
        "bnusNo": 24,
        "firstAccumamnt": 19488435376,
        "drwNo": 861,
        "drwtNo2": 17,
        "drwtNo3": 19,
        "drwtNo1": 11
    };

    useEffect( () => {
        getLottoNumber();
    }, []);

    return (
        <div>
            <h1>Home</h1>
            <h2>첫번째 번호{initData.drwtNo1}</h2>
            <h2>두번째 번호{initData.drwtNo2}</h2>
            <h2>세번째 번호{initData.drwtNo3}</h2>
        </div>
        
    );
}

export default Home;