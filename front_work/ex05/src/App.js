import './App.css';
import React, { useEffect, useMemo, useState } from 'react';

function App() {
  const [count, setCount] = useState(0);
  const [name, setName] = useState(('홍길동'));

  // 메모제이션
  //useMemo useCallback memo
  
  const memo_var = useMemo(() => {
    return {x:0,y:0};
  },[]);

  console.log("memo_var = ",memo_var);

  const [location,setLocation] = useState(memo_var);
  
  useEffect(() => {
    console.log("화면이 랜더링 되어질때 실행됩니다.");
  },[location])


  return (
    <div className="App">
      <div><h1>Header</h1></div>
      <div>
        <h1>Content</h1>
        {
          // display flex,grid 뭔가다른거
          // display block 세로 inline 가로인데 여백x inline-block 가로이긴한데 여백o
        }
        <div>
          <span style={{ display: 'block' }}>count = {count}</span>
          <button onClick={() => { setCount(count + 1); }}>Click</button>
        </div>
        <div>
          <span style={{ display: 'block' }}>name = {name}</span>
          <button onClick={() => { name==='홍길동'? setName('김길동'): setName('홍길동'); }}>Click</button>
        </div>
        <div>
          <span style={{ display: 'block' }}> location.x = {location.x}</span>
          <span style={{ display: 'block' }}> location.y = {location.y}</span>
          <span style={{ display: 'block' }}> location = {JSON.stringify(location)}</span>
          <button onClick={() => { setLocation(memo_var) }}>Click</button>
        </div>
      </div>
      <div><h1>Footer</h1></div>
    </div>
  );
}

export default App;

