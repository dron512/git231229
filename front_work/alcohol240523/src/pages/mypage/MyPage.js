import React, { useState } from "react";
import { MyWrap, SideWrap } from "../../styles/basic/sideWrap";
import { SideBar } from "../../styles/product/sideBarCss";
import SideTitle from "../../components/basic/SideTitle";
import SideBt from "../../components/basic/SideBt";
import { Outlet, useNavigate } from "react-router-dom";
import SideSubTitle from "../../components/basic/SideSubTitle";
import BasicLayout from "../../layout/BasicLayout";
import { useRecoilState } from "recoil";
import { activeSideState } from "../../atom/activeSideState";

const MyPage = () => {
  const navigate = useNavigate();
  const [activeSide, setActiveSide] = useRecoilState(activeSideState);
  const handleClick = sidenId => {
    setActiveSide(sidenId);
    console.log("선택된 사이드바", sidenId);
  };

  return (
    <BasicLayout>
      <MyWrap>
        <SideBar>
          <div style={{ cursor: "pointer" }}>
            <SideTitle
              sideTitle="마이페이지"
              // onClick={() => navigate(`mymain`)}
            />
          </div>

          <hr />
          <div className="side-nav">
            <SideBt
              sidenNm="마이페이지"
              sidenId={10}
              active={activeSide === "info"}
              onClick={() => {
                navigate("info");
                handleClick("info");
              }}
            />
            <SideBt
              sidenNm="비밀번호수정"
              sidenId={10}
              active={activeSide === "passwordCh"}
              onClick={() => {
                navigate("passwordCh");
                handleClick("passwordCh");
              }}
            />
            <SideSubTitle sideSubTitle="쇼핑정보" />
            <SideBt
              sidenNm="주문배송조회"
              sidenId={0}
              active={activeSide === "order"}
              onClick={() => {
                navigate("order");
                handleClick("order");
              }}
            />
            <SideBt
              sidenNm="상품리뷰"
              sidenId={1}
              active={activeSide === "review"}
              onClick={() => {
                navigate("review");
                handleClick("review");
              }}
              // onClick={() => handleClick(1)}
            />

            {/* --------------------------------------------------------------------- */}
            <SideSubTitle sideSubTitle="상품정보" />
            <SideBt
              sidenNm="위시리스트"
              sidenId={2}
              active={activeSide === "wish"}
              onClick={() => {
                navigate("wish");
                handleClick("wish");
              }}
            />

            {/* --------------------------------------------------------------------- */}
            {/* <SideSubTitle sideSubTitle="회원정보" />
            <SideBt
              sidenNm="내 정보 관리"
              sidenId={3}
              active={activeSide === 3}
              onClick={() => handleClick(3)}
            />
            <SideBt
              sidenNm="배송지 관리"
              sidenId={4}
              active={activeSide === 4}
              onClick={() => handleClick(4)}
            /> */}

            {/* --------------------------------------------------------------------- */}
            {/* <SideSubTitle sideSubTitle="고객센터" />
            <SideBt
              sidenNm="고객센터"
              sidenId={5}
              active={activeSide === 5}
              onClick={() => handleClick(5)}
            /> */}
          </div>
        </SideBar>
        <Outlet />
      </MyWrap>
    </BasicLayout>
  );
};

export default MyPage;
