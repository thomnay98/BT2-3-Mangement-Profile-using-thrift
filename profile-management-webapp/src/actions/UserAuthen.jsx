import * as types from '../constants/ActionTypes';
import * as AuthService from '../service/AuthService';

export const register = user => (dispatch) => {
    return AuthService.register(user)
        .then(res => {
            console.log("res redux: " + JSON.stringify(res))
            if(res.data.errrCode >= 0){
                dispatch({
                    type: types.REGISTER_SUCCESS,
                });
            
                dispatch({
                    type: types.SET_MESSAGE,
                    payload: { errC: res.data.errCode, errM: res.data.errMessage},
                });
            
                return Promise.resolve();
            }else{
                dispatch({
                    type: types.REGISTER_FAIL,
                });
            
                dispatch({
                    type: types.SET_MESSAGE,
                    payload: { errC: res.data.errCode, errM: res.data.errMessage},
                });
            
                return Promise.resolve();
            }
        })
        .catch(error => {
            const message =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();

            dispatch({
                type: types.REGISTER_FAIL,
            });

            dispatch({
                type: types.SET_MESSAGE,
                payload: {errC: -201, message},
            });

            return Promise.reject();
        });
}

export const login = user => (dispatch) => {
    return AuthService.login(user)
        .then(res => {
            
            if(res.data.errCode === 0){
                console.log("res redux: " + JSON.stringify(res))
                dispatch({
                    type: types.LOGIN_SUCCESS,
                    payload: {user: res.data.user}
                });
            
                dispatch({
                    type: types.SET_MESSAGE,
                    payload: { errC: res.data.errCode, errM: res.data.errMessage},
                });
            
                return Promise.resolve();
            }else{
                console.log("res redux --: " + JSON.stringify(res))
                dispatch({
                    type: types.LOGIN_FAIL,
                });
            
                dispatch({
                    type: types.SET_MESSAGE,
                    payload: { errC: res.data.errCode, errM: res.data.errMessage},
                });
            
                return Promise.resolve();
            }
        })
        .catch(error => {
            const message =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();

            dispatch({
                type: types.LOGIN_FAIL,
            });

            dispatch({
                type: types.SET_MESSAGE,
                payload: {errC: -201, message},
            });

            return Promise.reject();
        });
}

export const logout = () => (dispatch) => {
    return AuthService.logout()
        .then(res => {
            if(res.data.errrCode === 0){
                dispatch({
                    type: types.LOGOUT,
                });
            
                dispatch({
                    type: types.SET_MESSAGE,
                    payload: { errC: res.data.errCode, errM: res.data.errMessage},
                });
            
                return Promise.resolve();
            }else{
                dispatch({
                    type: types.LOGOUT,
                });
            
                dispatch({
                    type: types.SET_MESSAGE,
                    payload: { errC: res.data.errCode, errM: res.data.errMessage},
                });
            
                return Promise.resolve();
            }
        })
        .catch(error => {
            const message =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();

            dispatch({
                type: types.LOGOUT,
            });

            dispatch({
                type: types.SET_MESSAGE,
                payload: {errC: -201, message},
            });

            return Promise.reject();
        });
}

export const firstAccess = () => (dispatch) => {
    return AuthService.firstAccess()
        .then(res => {
            if(res.data.errCode === 0){
                console.log("res redux: " + JSON.stringify(res))
                dispatch({
                    type: types.ACCESS_SUCCESS,
                    payload: {user: res.data.user}
                });
            
                dispatch({
                    type: types.SET_MESSAGE,
                    payload: { errC: res.data.errCode, errM: res.data.errMessage},
                });
            
                return Promise.resolve();
            }else{
                console.log("res redux --: " + JSON.stringify(res))
                dispatch({
                    type: types.ACCESS_FAIL,
                });
        
                return Promise.resolve();
            }
        })
        .catch(error => {
            const message =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();

            dispatch({
                type: types.ACCESS_FAIL,
            });

            dispatch({
                type: types.SET_MESSAGE,
                payload: {errC: -201, message},
            });

            return Promise.reject();
        });
}
