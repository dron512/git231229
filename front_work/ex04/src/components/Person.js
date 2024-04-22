// backend 데이터 요청
import React, { useState } from 'react';
import axios from 'axios';
import Button from '@mui/material/Button';

const getPeson = async () => {
    console.log('getPerson');
    const id = parseInt(Math.random() * 3 + 1);

    const result = await axios.get(`http://localhost:8080/person/one/${id}`);
    console.log(result);
    return result.data;
}

const getData = async () => {
    console.log('getData');
    const id = parseInt(Math.random() * 3 + 1);

    const result = await axios.get(`http://www.grencoffee.store/user/`);
    console.log(result);
    return result.data;
}

const Person = ({ name: personname, age: paramage }) => {
    console.log('Person');
    const [age, setAge] = useState(paramage);
    const [name, setName] = useState(personname);
    const [data,setData] = useState("초기값");
    const addAge = () => {
        setAge(age + 1);
    }
    const subAge = () => {
        setAge(age - 1);
    }
    return (<>
        <h1>{data}</h1>
        <h1>Person</h1>
        <h2>이름 = {name}</h2>
        <h2>나이 = {age}</h2>
        <Button onClick={addAge} variant="contained">새로운나이증가</Button>
        <button onClick={addAge}>나이증가</button>
        <button onClick={subAge}>나이감소</button>
        <button onClick={async () => {
            const data = await getPeson();
            setAge(data.age);
            setName(data.name);
        }}>가져오기</button>
        <button onClick={async () => {
            const data = await getData();
            setData(data);
        }}>가져오기</button>
    </>);
}

export default Person;