import React, { useState } from 'react';
import Person from './components/Person';

// Person
// const Person = () => {
//     return ( <></> );
// }

const App2 = () => {
    console.log('App2');
    const [a, setA] = useState(10);
    const doA = ()=>{
        setA(a+1);
        // a = a+1;
        // console.log(a);
    }
    // Person();
    return (<>
        <h1>App2</h1>
        <h2>{a}</h2>
        <button onClick={doA}>Update A</button>
        <Person name="홍길동" age={20}></Person>
        <Person name="박길동" age={30}></Person>
        <Person name="이길동" age={40}></Person>
    </>);
}

export default App2; 