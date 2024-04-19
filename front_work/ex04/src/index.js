import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import App2 from './App2';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // index.js 에서 <App/> 함수가 호출되는것이다.
  // <App />
  // jsx 문법이다.

  // react 개발할때 혹시나 너가 틀릴수도 있으니깐
  // 화면 랜더링은 두번 해줄꼐
  // strict mode는 개발할때만 사용하고
  <App2/>
);

reportWebVitals();
