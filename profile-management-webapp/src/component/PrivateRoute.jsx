import React from 'react';
import {useSelector} from 'react-redux';
import { Navigate, useLocation } from 'react-router-dom';

export const PrivateRoute = ({children}) => {
  const { isLoggedIn } = useSelector(state => state.auth);
  const location = useLocation();
    // let user = Cookies.get('user');
  //let user = localStorage.user;

  return (
    <>
        {
            isLoggedIn
            ?
            children
            :
            <Navigate to="/" state={{ from: location }} replace />
            // <Navigate to="/" state={{ from: location }} replace />
        }
    </>
  )
}
