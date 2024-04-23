import './App.css';
import BaiscLayout from './layout/BasicLayout';
import { Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Contact from './pages/Contact';
import About from './pages/About';
import MultipleFileUploader from './pages/MultipleFileUploader';
import MapComponent from './pages/kakao/MapComponent';
import MyPage from './pages/login/MyPage';
import Login from './pages/login/Login';

function App() {
  return (
    <div className="App">
      <BaiscLayout>
        <Routes>
          <Route path="/" element={<Home></Home>} />
          <Route path="/about" element={<About></About>} />
          <Route path="/contact" element={<Contact></Contact>} />
          <Route path="/login" element={<MyPage></MyPage>} ></Route>
          <Route path="/login/login" element={<Login></Login>}></Route>
          <Route path="/login/mypage" element={<MyPage></MyPage>}></Route>
          <Route path="/filesupload" element={<MultipleFileUploader></MultipleFileUploader>} />
          <Route path="/map" element={<MapComponent></MapComponent>} />
        </Routes>
      </BaiscLayout>
    </div>
  );
}

export default App;
