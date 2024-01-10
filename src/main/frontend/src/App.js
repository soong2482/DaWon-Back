
import './App.css';
import React from 'react';
import Home from './pages/Home.jsx';
import AdminPage from './pages/Admin/AdminPage.jsx';
import AdminHome from './pages/Admin/AdminHome.jsx';
import Request from './pages/Request.jsx';
import { Route, Routes } from 'react-router-dom';
function App() {
  return (
   <Routes>
       <Route path='/' element={<Home />} />
       <Route path='/requestpage' element={<Request/>}/>
       <Route path='/adminhome' element={<AdminHome/>}/>
       <Route path='/adminpage' element={<AdminPage/>}/>
   </Routes>
  );
}

export default App;
