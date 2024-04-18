import React from "react";
import MainSwiper from "../../components/mainpage/MainSwiper";
import MainRcItem from "../../components/mainpage/MainRcItem";
import MainNoneLoginSwiper from "../../components/mainpage/MainNoneLoginSwiper";
import useCustomLogin from "../../hooks/useCustomLogin";
import MainLoginSwiper from "../../components/mainpage/MainLoginSwiper";

const MainPage = () => {
  const { isLogin } = useCustomLogin();
  console.log("API_SERVER_HOST"+API_SERVER_HOST);
  return (
    <div>
      <MainSwiper />
      {isLogin ? <MainLoginSwiper /> : <MainNoneLoginSwiper />}
      <MainRcItem />
    </div>
  );
};

export default MainPage;
