/* eslint-disable import/no-anonymous-default-export */
import { legacy_createStore as createStore, applyMiddleware } from "redux";
import { composeWithDevTools } from "redux-devtools-extension";
// import { persistStore, persistReducer } from 'redux-persist';
// import storage from 'redux-persist/lib/storage';
import thunk from "redux-thunk";
import rootReducer from "./reducers/index";

const middleware = [thunk];
// const persistConfig = {
//   key: 'root',
//   storage,
// }

// const pReducer = persistReducer(persistConfig, rootReducer);

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(...middleware))
);

export default store; //= createStore(pReducer, composeWithDevTools(applyMiddleware(...middleware)));
// export const persistor = persistStore(store);

// export default () => {
//   let store = createStore(persistedReducer, composeWithDevTools(applyMiddleware(...middleware)));
//   let persistor = persistStore(store);
//   return { store, persistor }
// };