
import './App.css';
import React from 'react';
import Home from './pages/Home.jsx';
import TEST from './components/HomeSlider.js'
import Request from './pages/Request.jsx';
import { Route, Routes } from 'react-router-dom';
function App() {
  return (
   <Routes>
       <Route path='/' element={<Home />} />
       <Route path='/requestpage' element={<Request/>}/>
       <Route path='/test' element={<TEST/>}/>
   </Routes>
  );
}

export default App;
