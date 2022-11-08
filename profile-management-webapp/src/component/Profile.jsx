import React from 'react'
import { useSelector } from "react-redux";

export const Profile = () => {

    const {user} = useSelector(state => state.auth);

  return (
    <div className="profile-wrapper">
        <div className="profile">
            <div className="profile-logo">
                <h1>Thông tin của bạn</h1>
            </div>
            <div className="profile-info">
                <div className="profile-info__item">
                    <p>Họ tên: </p>
                    <h2>{user && user.name}</h2>
                </div>
                <div className="profile-info__item">
                    <p>Email: </p>
                    <h2>{user && user.email}</h2>
                </div>
                <div className="profile-info__item">
                    <p>Địa chỉ: </p>
                    <h2>{user && user.address}</h2>
                </div>
                <div className="profile-info__item">
                    <p>Số điện thoại: </p>
                    <h2>{user && user.phone}</h2>
                </div>
            </div>
        </div>
    </div>
  )
}
