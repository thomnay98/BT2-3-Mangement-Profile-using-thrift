import './App.css';
import React from 'react';
import 'react-toastify/dist/ReactToastify.css';
import { Routes, Route } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';

import { Navbar } from './component/Navbar';
import { Home } from './component/Home';
import { Login } from './component/Login';
import { Register } from './component/Register';
import { Profile } from './component/Profile';
import { PrivateRoute } from './component/PrivateRoute';
import { Toast } from './component/Toast';
import AuthVerify from './common/auth-verify';

function App() {

  return (
    <>
      <Navbar />
      <ToastContainer
        position="top-right"
        autoClose={3000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="light"
        />
        <Routes>
          <Route exac path="/" element={<Home />} />
          <Route exac path="dang-nhap" element={<Login />} />
          <Route exac path="dang-ky" element={<Register />} />
          <Route path="thong-tin-ca-nhan" element={
                  <PrivateRoute> 
                    <Profile /> 
                  </PrivateRoute>} />
          <Route path="*" element={<p>There's nothing here: 404!</p>} />
        </Routes>
      <ToastContainer />
      <Toast />
      <AuthVerify />
    </>
  );
}

export default App;
