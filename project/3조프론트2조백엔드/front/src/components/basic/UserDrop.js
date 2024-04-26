import styled from "@emotion/styled/macro";
import React, { useState } from "react";
import { Common } from "../../styles/CommonCss";
import { Flex } from "antd";

const UserDrop = () => {
  const [open, setOpen] = useState(false);

  const DropdownWrapper = styled.div`
    position: relative;
    display: inline-block;
    img {
      width: 27px;
    }
  `;

  const DropdownContent = styled.div`
    display: ${open ? "block" : "none"};
    position: absolute;
    background-color: ${Common.color.p000};
    min-width: 215px;

    right: -100%;
    top: calc(100% + 19px);
    box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
    z-index: 9999;
    border-radius: 10px;
    font-size: 10px;
    &::before {
      content: "";
      position: absolute;
      top: -2em; /* 드롭다운 위로 1em만큼 이동 */
      left: -1em;
      right: -5em;
      bottom: -1em; /* 드롭다운 아래로 1em만큼 이동 */
      background-color: transparent;
      /* background-color: rebeccapurple; */
      z-index: -1;
    }
    .profile {
      padding: 30px 30px 20px 30px;
      p {
        margin-bottom: 5px;
      }
    }
    .line {
      width: 80%;
      height: 2px;
      justify-content: center;
      margin: 0 auto;
      background-color: ${Common.color.p800};
    }
  `;

  const ItemBack = styled.div`
    padding: 10px 0;
    /* border-top: 1px solid #2e2e2e; */
  `;

  const DropdownItem = styled.a`
    color: ${Common.color.p900}; /* 수정: 색상 코드 앞에 # 추가 */
    padding: 12px 30px;

    text-decoration: none;
    display: block;
    &:hover {
      background-color: #2e2e2e;
      color: #e1e1e1;
    }
  `;

  return (
    <DropdownWrapper
      onMouseEnter={() => setOpen(true)}
      onMouseLeave={() => setOpen(false)}
    >
      <a href="/mypage">
        <img src={process.env.PUBLIC_URL + "/images/user.png"} />
      </a>

      <DropdownContent>
        <div className="profile">
          <div style={{ display: "flex", marginBottom: "10px" }}>
            <p style={{ marginRight: "5px" }}>반갑습니다</p>
            <p
              style={{
                marginRight: "3px",
                fontWeight: "600",
              }}
            >
              000
            </p>
            <p>님</p>
          </div>
          {/* <a className="profile-a">프로필 전환 &gt;</a> */}
          <p>현재 배송지</p>
          <p>대구광역시 중구 달성로123</p>
        </div>
        <div className="line"></div>
        <ItemBack>
          <DropdownItem href="/mypage">마이페이지</DropdownItem>
          <DropdownItem href="#about">주문/배송</DropdownItem>
          <DropdownItem href="#contact">리뷰작성</DropdownItem>
          <DropdownItem href="#logout">위시리스트</DropdownItem>
          <DropdownItem href="#logout">고객센터</DropdownItem>
          <DropdownItem href="#logout" style={{ color: Common.color.p300 }}>
            로그아웃
          </DropdownItem>
        </ItemBack>
      </DropdownContent>
    </DropdownWrapper>
  );
};

export default UserDrop;
