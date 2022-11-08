import React, {useState} from 'react'
import { Link, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { useDispatch } from 'react-redux';

import loader from '../asset/Spinner-1s-64px.svg';
import { register } from "../actions/UserAuthen";

export const Register = () => {
  let navigate = useNavigate();
  const dispatch = useDispatch();

  const [isLoading, setIsLoading] = useState(false);
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [passwordAgain, setPasswordAgain] = useState('');
  const [address, setAddress] = useState('');
  const [phone, setPhone] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    const user = {
      email,
      name,
      password,
      address,
      phone
    }

    console.log("user: " + JSON.stringify(user));

    setIsLoading(true);
    if(password !== passwordAgain){
      setIsLoading(false);
      toast.error('Nhập lại mật khẩu không đúng', {
        position: "top-right",
        autoClose: 3000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
      });
    }else{
  
      var raw = JSON.stringify({
        "name": `${name}`,
        "email": `${email}`,
        "password": `${password}`,
        "address": `${address}`,
        "phone": `${phone}`
      });
      
      dispatch(register(raw))
      .then((res) => {
        console.log("res register: " + JSON.stringify(res))
        navigate("/dang-nhap");
        setIsLoading(false);
        //window.location.reload();
      })
      .catch((err) => {
        setIsLoading(false);
        console.log("err" + err)
      });
    }

  }

  return (
    <div className="form-wrapper">
        <div className="form">
          <form onSubmit={handleSubmit}>
            <div className="input-container">
              <label>Họ tên: </label>
              <input type="text" name="name" value={name} onChange={e => setName(e.target.value)} />
            </div>
            <div className="input-container">
              <label>Email: </label>
              <input type="email" name="email" value={email} onChange={e => setEmail(e.target.value)} />
            </div>
            <div className="input-container">
              <label>Mật khẩu: </label>
              <input type="password" name="password" value={password} onChange={e => setPassword(e.target.value)} />
            </div>
            <div className="input-container">
              <label>Nhập lại mật khẩu: </label>
              <input type="password" name="passwordAgain" value={passwordAgain} onChange={e => setPasswordAgain(e.target.value)} />
            </div>
            <div className="input-container">
              <label>Địa chỉ: </label>
              <input type="text" name="address" value={address} onChange={e => setAddress(e.target.value)} />
            </div>
            <div className="input-container">
              <label>Số điện thoại: </label>
              <input type="text" name="phone" value={phone} onChange={e => setPhone(e.target.value)} />
            </div>
            <div className="button-container">
              <button type="submit" > { isLoading && <img src={loader} alt="loader" />} Đăng ký</button>
            </div>
            <span>Đã có tài khoản. <Link to="/dang-nhap">Đăng nhập ngay!</Link></span>
          </form>
        </div>
    </div>
  )
}
