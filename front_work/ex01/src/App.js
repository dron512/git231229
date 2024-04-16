import aaa from './aaa.jpg';
import './App.css';

import React, { useEffect, useState } from 'react';

function App() {

  const [itemNm, setItemNm] = useState('');
  const [price, setPrice] = useState('');

  const newItem = () => {
    fetch('http://localhost:8080/api/item/new', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then(response => response.json())
    .then(data => {
      setItemNm(data.itemNm);
      setPrice(data.price);
    });
  }

  useEffect(() => {
    const queryParams = new URLSearchParams(window.location.search);
    
    // 'accesstoken' 파라미터 값 가져오기
    const accessToken = queryParams.get('accessToken');
    const refeshToken = queryParams.get('refeshToken');
    
    if(accessToken && refeshToken) {
      // 'accesstoken' 파라미터 값이 있을 경우 localStorage에 저장
      localStorage.setItem('accessToken', accessToken);
      localStorage.setItem('refeshToken', refeshToken);
      window.location.href = '/';
    }
    
  });

  return (
    <div className="App">
      <h1></h1>
      <header className="App-header">
        <img src={aaa} className="App-logo" alt="logo" />
        <button onClick={newItem}>AddItem</button>
        <p id="item">
          itemNm = {itemNm}
          <br/>
          price = {price}
        </p>
        <a
          className="App-link"
          href="https://kauth.kakao.com/oauth/authorize?client_id=ff0937f4b6886da19d90506ef2579de0&redirect_uri=http://localhost:8080/oauth/kakao/callback&response_type=code"
          // target="_blank"
          rel="noopener noreferrer"
        >
          KaKaoLogin
        </a>
      </header>
    </div>
  );
}

export default App;
