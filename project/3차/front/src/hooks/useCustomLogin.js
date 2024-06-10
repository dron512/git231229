import { Navigate, useNavigate } from "react-router-dom";
import { useRecoilState, useResetRecoilState } from "recoil";

import { postLogin } from "../api/signUpApi";
import { removeCookie, setCookie } from "../util/cookieUtil";
import { atomSignState } from "../atom/loginState";

const useCustomLogin = () => {
  // 패스 이동하기
  const navigate = useNavigate();

  // Recoil 로그인 Atom 불러오기
  const [loginState, setLoginState] = useRecoilState(atomSignState);

  // Recoil 로그인 atom 리셋하기
  const resetSignState = useResetRecoilState(atomSignState);

  // const isLogin = loginState && loginState.email ? true : false;
  const isLogin =
    loginState && Object.keys(loginState).length > 0 ? true : false;

  // 로그인 기능
  // const doLogin = async ({ loginParam, successFn, failFn, errorFn }) => {
  //   const result = await postLogin({ loginParam, successFn, failFn, errorFn });
  //   saveAsCookie(result);
  //   moveToPath("/");

  //   return result;
  // };

  const doLogin = async ({ loginParam }) => {
    const result = await postLogin({ loginParam });
    saveAsCookie(result);
    moveToPath("/");
    // navigate("/main");

    return result;
  };
  const saveAsCookie = result => {
    setLoginState(result);

    setCookie("member", JSON.stringify(result), 1);
  };
  // console.log("쿠키에 저장된 정보:", loginState, isLogin);

  // 로그아웃 기능
  const doLogout = () => {
    removeCookie("member");
    resetSignState();
    moveToPath("/");
    // 로그아웃이 되면 버튼업데이트를 위해 새로고침
    window.location.reload();
  };

  // 패스이동 기능
  const moveToPath = path => {
    navigate({ pathname: path }, { replace: true });
  };

  // 로그인 페이동 기능
  const moveToLogin = () => {
    console.log("페이지 이동");
    return <Navigate replace to="/login" />;
  };

  return {
    loginState,
    isLogin,
    doLogin,
    doLogout,
    moveToPath,
    moveToLogin,
    saveAsCookie,
  };
};

export default useCustomLogin;
