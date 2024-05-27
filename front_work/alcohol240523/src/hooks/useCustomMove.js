import React from "react";
import { Link, useNavigate } from "react-router-dom";
import useCustomLogin from "./useCustomLogin";

export const useCustomMove = () => {
  const navigate = useNavigate();
  const { isLogin } = useCustomLogin();

  const moveToLogin = () => {
    <a href="/login"></a>;
    navigate("/login");
  };
  const moveToMain = () => {
    <a href="/main"></a>;
    // <Link to="/main"></Link>;
    navigate("/");
  };

  const moveToDetail = code => {
    if (isLogin) {
      navigate({ pathname: `/product/detail/${code}` });
    } else {
      alert("회원만 접근이 가능합니다. 로그인 페이지로 이동합니다.");
      navigate("/sign/in");
    }
  };
  return { moveToLogin, moveToMain, moveToDetail };
};

export default useCustomMove;
