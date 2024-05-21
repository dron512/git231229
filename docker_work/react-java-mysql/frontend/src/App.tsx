import React, { useEffect, useState } from "react";
import from "./App.css";

type Greeting = {
  id: number;
  name: string;
};

function App() {
  const [greeting, setGreeting] = useState<Greeting>();

  const doA = () => {
    fetch("http://localhost:8080/api/greeting")
      .then(res => res.text())
      .then(data => {
        console.log(data);
        const result: Greeting = {
          id: 1,
          name: data
        };
        setGreeting(result);
      })
  }

  return (
    <div className="App">
      <header className="App-header">
        {
          greeting && <><h1>{greeting.id}</h1><h1>{greeting.name}</h1></>
        }
        <button onClick={doA}> 버튼</button>
      </header>
    </div>
  );
}

export default App;
