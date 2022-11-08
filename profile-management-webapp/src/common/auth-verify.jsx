import React from 'react';
import { useDispatch } from 'react-redux';

import { firstAccess } from "../actions/UserAuthen";

const AuthVerify = () => {
  const dispatch = useDispatch();
  // const navigate = useNavigate();
  // const location = useLocation();

  dispatch(firstAccess())
  .then(res => {
    console.log("res" + res)
    // const from = location.state?.from || "/";
    // Navigate("/thong-tin-ca-nhan", { replace: true });
  })
  .catch((err) => {
    console.log("err" + err)
  });

  // useEffect(() => {
  //   dispatch(firstAccess())
  //   .then(res => {
    
  //     const from = location.state?.from || "/";
  //     navigate(from, { replace: true });
  //   })
  //   .catch((err) => {
  //     console.log("err" + err)
  //   });
  // }, [])

  return (
    <></>
  )
}

export default AuthVerify;
