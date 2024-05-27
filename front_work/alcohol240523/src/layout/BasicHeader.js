import styled from "@emotion/styled/macro";
import React from "react";
import { Link } from "react-router-dom";
import DropNav from "../components/basic/DropNav";
import NavDropdown from "../components/basic/DropNavNew";
import UserDrop from "../components/basic/UserDrop";
import useCustomLogin from "../hooks/useCustomLogin";
import useCustomMove from "../hooks/useCustomMove";
import { Common } from "../styles/CommonCss";

const BasicHeader = () => {
  const { moveToLogin } = useCustomMove();

  const { doLogout, loginState, isLogin } = useCustomLogin();

  const HeaderWrap = styled.div`
    width: 100%;
    position: relative;
    height: 23rem;
    background-color: ${Common.color.b900};
    padding: 5rem;
    .header-inner {
      width: 130rem;
      margin: 0 auto;
    }
    .topNav {
      position: relative;
      display: flex;
      justify-content: space-between;
      margin-bottom: 4rem;
    }
    .left-logo {
      display: flex;
      /* align-items: center; */

      h1 {
        align-items: center;
        color: ${Common.color.p000};
      }
    }
    .right-top-nav {
      display: flex;
      p {
        margin: 0 0.4rem;
        color: ${Common.color.p000};
        font-size: 1.3rem;
      }
    }
    .rigth-bottom-nav {
      display: flex;
      justify-content: end;
      align-items: center;
      /* margin-top: 5px; */
      img {
        /* margin-left: 18px; */
        margin: 2rem 0 0 1.8rem;
      }
    }
  `;
  return (
    <HeaderWrap>
      <div className="header-inner">
        <div className="topNav">
          <div className="left-logo">
            <Link to="/">
              <div>
                <h1>ALCOHOL</h1>
                <h1>FREE</h1>
              </div>
            </Link>
          </div>
          <div>
            <div className="right-top-nav">
              {/* {console.log("아", loginState, isLogin)} */}
              {isLogin ? (
                <Link onClick={doLogout}>
                  <p>로그아웃</p>
                </Link>
              ) : (
                <>
                  <Link to="/sign/in">
                    <p>로그인</p>
                  </Link>
                  <p>|</p>
                  <Link to="/sign/up">
                    <p>회원가입</p>
                  </Link>
                </>
              )}

              <p style={{ color: Common.color.f900 }}>|</p>
              <Link to="/">
                <p>고객센터</p>
              </Link>
            </div>
            <div className="rigth-bottom-nav">
              <Link to="/storeMap">
                <img
                  src={process.env.PUBLIC_URL + "/images/map.png"} // 수정된 부분
                  style={{ width: "28px", height: "auto" }}
                  alt="map"
                />
              </Link>
              <Link to="/cart">
                <img
                  src={process.env.PUBLIC_URL + "/images/bag.png"} // 수정된 부분
                  style={{ width: "26px", height: "auto" }}
                  alt="bag"
                />
              </Link>
              <Link to="/">
                <img
                  src={process.env.PUBLIC_URL + "/images/heart.png"} // 수정된 부분
                  style={{ width: "26px", height: "auto" }}
                  alt="heart"
                />
              </Link>
              <UserDrop />
            </div>
          </div>
        </div>

        <DropNav />
        <NavDropdown />
      </div>
    </HeaderWrap>
  );
};

export default BasicHeader;
