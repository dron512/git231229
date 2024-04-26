import "./App.css";
import { Routes, Route } from "react-router-dom";
import Main from './pages/Main';
import Maps from './pages/Map';
import Login from './pages/Login';
import Auth from './pages/Auth';
import Create from './pages/Create';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Main />}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/map" element={<Maps />}></Route>
        <Route path="/auth" element={<Auth />}></Route>
        <Route path='/login/create' element={<Create/>}></Route>
      </Routes>
    </div>
  );
}

export default App;
