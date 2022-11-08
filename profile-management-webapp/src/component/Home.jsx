import React from 'react'
import { Link } from 'react-router-dom'
import { useSelector } from 'react-redux';

export const Home = () => {
  const { isLoggedIn } = useSelector(state => state.auth);

  return (
    <div className="home">
      {
        !isLoggedIn
        ?
        <span>Đăng nhập để xem thông tin cá nhân. <Link to="/dang-nhap">Đăng nhập</Link></span>
        :
        <h2><Link to="/thong-tin-ca-nhan">Thông tin của tôi</Link></h2>
      }
    </div>
  )
}







