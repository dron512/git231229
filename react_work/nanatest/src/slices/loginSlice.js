import { createSlice } from "@reduxjs/toolkit";

// API 서버 연동
// reducer (store 상태 변경) 를 호출할때 지금은 API 호출
import { createAsyncThunk } from "@reduxjs/toolkit";
import { getCookie, removeCookie, setCookie } from "../util/cookieUtil";
import { loginPost } from "../api/login/LoginApi";

// export const 외부함수 = createAsyncThunk("이름", 리듀서함수);
export const loginPostAsync = createAsyncThunk(
  "loginPostAsync",
  async ({ loginParam, successFn, failFn, errorFn }) => {
    try {
      const res = await loginPost({ loginParam, successFn, failFn, errorFn });

      // 결과값을 리턴을 해야 action 에 값이 담기지...
      return res;
    } catch (error) {
      return error;
    }
  },
);

const initState = {
  nm: "",
};

// 쿠키 정보 읽어와서 initState 변경하기
const loadMemberCookie = () => {
  const memberInfo = getCookie("nm");
  return memberInfo || initState;
};

const loginSlice = createSlice({
  name: "loginSlice",
  initialState: loadMemberCookie(),
  reducers: {
    login: (state, action) => {
      // console.log("login.....");
      setCookie("nm", JSON.stringify(action.payload || {}));
      return { nm: action.payload?.nm || "" };
    },
    logout: (state, action) => {
      // console.log("logout.....");
      removeCookie("nm", "/");
      return { ...initState };
    },
  },
  extraReducers: builder => {
    builder
      .addCase(loginPostAsync.fulfilled, (state, action) => {
        // console.log("fulfilled");
        const payload = action.payload || {};
        if (!payload.error) {
          setCookie("nm", JSON.stringify(payload));
          return { nm: payload.nm || "" };
        } else {
          return state;
        }
      })
      .addCase(loginPostAsync.pending, (state, action) => {
        // console.log("pending");
        return state;
      })
      .addCase(loginPostAsync.rejected, (state, action) => {
        // console.log("rejected");
        return state;
      });
  },
});

export const { login, logout } = loginSlice.actions;
export default loginSlice.reducer;
loginSlice.js;
