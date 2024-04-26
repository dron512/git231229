import React from "react";
import { Link, useNavigate } from "react-router-dom";

export const useCustomMove = () => {
  const navigate = useNavigate();

  const moveToLogin = () => {
    <a href="/login"></a>;
    navigate("/login");
  };
  const moveToMain = () => {
    <a href="/main"></a>;
    // <Link to="/main"></Link>;
    navigate("/");
  };
  return moveToLogin, moveToMain;
};

export default useCustomMove;
