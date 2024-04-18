import './App.css';
import BaiscLayout from './layout/BasicLayout';
import { Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Contact from './pages/Contact';
import About from './pages/About';

function App() {
  return (
    <div className="App">
        <BaiscLayout>
          <Routes>
            <Route path="/" element={<Home></Home>} />
            <Route path="/about" element={<About></About>} />
            <Route path="/contact" element={<Contact></Contact>} />
          </Routes>
        </BaiscLayout>
    </div>
  );
}

export default App;
