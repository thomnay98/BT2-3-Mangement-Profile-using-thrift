/* eslint-disable import/no-anonymous-default-export */
import * as types from '../constants/ActionTypes';

const initialState = {
    isLoggedIn: false,
    user: null
};

export default function (state = initialState, action) {
    const { type, payload } = action;

    switch (type) {
        case types.REGISTER_SUCCESS:
          return {
            ...state,
            isLoggedIn: false,
          };
        case types.REGISTER_FAIL:
          return {
            ...state,
            isLoggedIn: false,
          };
        case types.LOGIN_SUCCESS:
          return {
            ...state,
            isLoggedIn: true,
            user: payload.user,
          };
        case types.LOGIN_FAIL:
          return {
            ...state,
            isLoggedIn: false,
            user: null,
          };
        case types.ACCESS_SUCCESS:
          return {
            ...state,
            isLoggedIn: true,
            user: payload.user,
          };
        case types.ACCESS_FAIL:
          return {
            ...state,
            isLoggedIn: false,
            user: null,
          };
        case types.LOGOUT:
          return {
            ...state,
            isLoggedIn: false,
            user: null,
          };
        default:
          return state;
      }
}