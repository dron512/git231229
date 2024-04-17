import React from "react";
import { useNavigate } from "react-router";
import {
  ErrorBt,
  ErrorImg,
  ErrorLogo,
  ErrorMainTxt,
  ErrorSubTxt,
  ErrorWrap,
} from "../../styles/errorpage/errorpagestyle";

const ErrorPage = () => {
  const navigate = useNavigate();

  const handleClickMain = () => {
    navigate("/");
  };
  return (
    <ErrorWrap>
      <ErrorImg>
        <img src={process.env.PUBLIC_URL + "/assets/images/ErrorImg.svg"} />
      </ErrorImg>
      <ErrorLogo>
        <img src={process.env.PUBLIC_URL + "/assets/images/logo.svg"} />
      </ErrorLogo>
      <ErrorMainTxt>원하시는 페이지를 찾을 수 없습니다.</ErrorMainTxt>
      <ErrorSubTxt>
        찾으려는 페이지의 주소가 잘못 입력되었거나 주소의 변경 혹은 삭제로
        사용하실 수 없습니다.
        <br />
        입력하신 주소가 정확한지 다시 한번 확인 부탁드립니다.
      </ErrorSubTxt>
      <ErrorBt
        onClick={() => {
          handleClickMain();
        }}
      >
        홈 바로가기
      </ErrorBt>
    </ErrorWrap>
  );
};

export default ErrorPage;
