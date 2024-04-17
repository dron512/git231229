import { configureStore } from "@reduxjs/toolkit";
import loginSlice from "./slices/loginSlice";
// store 가 공용 데이터 보관장소, state 입니다.
export default configureStore({
  reducer: {
    loginSlice: loginSlice,
  },
});
