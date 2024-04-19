import './App.css';
import { Header, Header2, Header3 } from './components/Header';

import React, { useState } from 'react';

function App() {
  const doA = ({oa,ob}) => {
    console.log(oa);
    console.log(ob);
  }
  // 배열 분할 기법
  const [aa, bb] = [10, 20];
  // 객체 분할기법
  const props = { oa: 10, ob: 20 };
  doA(props);
  
  return (
    <div className="App">
      <Header title="첫번째제목" />
      <Header2 key1="제목" value="2번" />
      <Header3 name="이름" value="1" />
      <h1>aa = {aa} , bb = {bb}</h1>
      <h1>oa = {props.oa} , ob = {props.ob}</h1>
    </div>
  );
}

export default App;
