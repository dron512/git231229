import React, { useState } from "react";
import { MyWrap, SideWrap } from "../../styles/basic/sideWrap";
import { SideBar } from "../../styles/product/sideBarCss";
import SideTitle from "../../components/basic/SideTitle";
import SideBt from "../../components/basic/SideBt";
import { Outlet, useNavigate } from "react-router-dom";
import SideSubTitle from "../../components/basic/SideSubTitle";

const MyPage = () => {
  const navigate = useNavigate();
  const [activeSide, setActiveSide] = useState(0);
  const handleClick = sidenId => {
    setActiveSide(sidenId);
    console.log("선택된 사이드바", sidenId);
  };

  return (
    <div>
      <MyWrap>
        <SideBar>
          <div style={{ cursor: "pointer" }}>
            <SideTitle
              sideTitle="마이페이지"
              onClick={() => navigate(`mymain`)}
            />
          </div>

          <hr />
          <div className="side-nav">
            <SideBt
              sidenNm="마이페이지"
              sidenId={10}
              active={activeSide === 10}
              onClick={() => {
                navigate("mymain");
                handleClick(10);
              }}
            />
            <SideSubTitle sideSubTitle="쇼핑정보" />
            <SideBt
              sidenNm="주문배송조회"
              sidenId={0}
              active={activeSide === 0}
              // onClick={() => handleClick(0)}
              onClick={() => {
                navigate("order");
                handleClick(0);
              }}
            />
            <SideBt
              sidenNm="상품리뷰"
              sidenId={1}
              active={activeSide === 1}
              onClick={() => {
                navigate("review");
                handleClick(1);
              }}
              // onClick={() => handleClick(1)}
            />

            {/* --------------------------------------------------------------------- */}
            <SideSubTitle sideSubTitle="상품정보" />
            <SideBt
              sidenNm="위시리스트"
              sidenId={2}
              active={activeSide === 2}
              onClick={() => handleClick(2)}
            />

            {/* --------------------------------------------------------------------- */}
            <SideSubTitle sideSubTitle="회원정보" />
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
            />

            {/* --------------------------------------------------------------------- */}
            <SideSubTitle sideSubTitle="고객센터" />
            <SideBt
              sidenNm="고객센터"
              sidenId={5}
              active={activeSide === 5}
              onClick={() => handleClick(5)}
            />
          </div>
        </SideBar>
        <Outlet />
      </MyWrap>
    </div>
  );
};

export default MyPage;
