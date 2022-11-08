import React, { useState} from 'react';
import { Link, Navigate, useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
// import { toast } from 'react-toastify';

// import { api } from '../config/axiosConfig';
import loader from '../asset/Spinner-1s-64px.svg';
import { login } from "../actions/UserAuthen";

export const Login = () => {
  const { isLoggedIn } = useSelector(state => state.auth);
  let navigate = useNavigate();
  const dispatch = useDispatch();

  // const [errorMessages, setErrorMessages] = useState({});
  const [isLoading, setIsLoading] = useState(false);
  const [form, setForm] = useState({
    email: "",
    password: ""
  })

  // const renderErrorMessage = (name) =>
  // name === errorMessages.name && (
  //   <div className="error">{errorMessages.message}</div>
  // );

  const handleChange = (e) => {
    const nextFormState = {
      ...form,
      [e.target.name]: [e.target.value],
    };
    setForm(nextFormState);
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    setIsLoading(true);

    var user = JSON.stringify({
      "email": `${form.email}`,
      "password": `${form.password}`
    })

    dispatch(login(user))
        .then((res) => {
          console.log("res Login: " + JSON.stringify(res))
          navigate("/thong-tin-ca-nhan");
          setIsLoading(false);
          //window.location.reload();
        })
        .catch((err) => {
          setIsLoading(false);
          console.log("err" + err)
        });

  }

  if (isLoggedIn) {
    return <Navigate to="/profile" />;
  }

  return (
    <div className="form-wrapper">
      <div className="form">
        <div className="form-login__header">
            <h1>Đăng nhập</h1>
        </div>
        <form onSubmit={handleSubmit}>
          <div className="input-container">
            <label>Email: </label>
            <input type="email" name="email" value={form.email} onChange={handleChange} />
            {/* {renderErrorMessage("email")} */}
          </div>
          <div className="input-container">
            <label>Mật khẩu: </label>
            <input type="password" name="password" value={form.password} onChange={handleChange} />
            {/* {renderErrorMessage("password")} */}
          </div>
          <div className="button-container">
            <button type="submit" >{ isLoading && <img src={loader} alt="loader" />} Đăng nhập</button>
          </div>
          <span>Chưa có tài khoản. <Link to="/dang-ky"> Đăng ký ngay!</Link></span>
        </form>
      </div>
    </div>
  )
}
