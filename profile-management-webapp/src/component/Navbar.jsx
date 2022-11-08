import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import {useSelector, useDispatch} from 'react-redux';
import { logout } from '../actions/UserAuthen';

export const Navbar = () => {
  const { isLoggedIn } = useSelector(state => state.auth);

  const navigate = useNavigate();
  const dispatch = useDispatch();


  const logOut = (e) => {
    e.preventDefault();

    dispatch(logout())
      .then(res => {
        navigate(`/dang-nhap`);
      })
      .catch((err) => {
        console.log("err" + err)
      });

    // api.post("/api-logout")
    //   .then(res =>{
    //     if(res.data.errCode === 0){
    //       localStorage.clear('user');
    //       navigate(`/dang-nhap`);
    //       toast.success('Đăng xuất thành công!', {
    //         position: "top-right",
    //         autoClose: 3000,
    //         hideProgressBar: false,
    //         closeOnClick: true,
    //         pauseOnHover: true,
    //         draggable: true,
    //         progress: undefined,
    //         theme: "light",
    //       })
    //     }
    //   })
}

  return (
    <div className="navbar container">
      <Link to="/" className="logo">QLTT Cá Nhân</Link>
      {
        //localStorage.user
        isLoggedIn
        ?
        <Link to="/dang-nhap" onClick={e => logOut(e)} className="login-button">Đăng xuất</Link>
        :
        <Link to="/dang-nhap" className="login-button">Đăng nhập</Link>
      }
    </div>
  )
}
