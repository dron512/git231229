import styled from "@emotion/styled/macro";
import React from "react";
import { Common } from "../styles/CommonCss";

const BasicFooter = () => {
  const FooterWrap = styled.div`
    position: relative;
    display: flex;
    /* height: 233px; */
    background-color: ${Common.color.b900};
    padding: 5rem;
    justify-content: space-between;
    h1 {
      color: ${Common.color.p000};
    }
    .footer-inner {
      width: 130rem;
      margin: 0 auto;
      height: 35rem;
    }
    .company-nav {
      display: flex;
      margin: 3rem 0;
      a {
        color: ${Common.color.p000};
        font-size: 1.3rem;
        font-weight: 600;
      }
      li {
        display: flex;
      }
      .l {
        margin: 0 1rem;
        color: ${Common.color.p000};
        font-size: 1.3rem;
        cursor: default;
      }
    }
    .left-p {
      font-size: 1.3rem;
      color: ${Common.color.p100};
    }
    .right-info {
      display: flex;
      margin-right: 5rem;
      align-items: center;
      p {
        color: ${Common.color.p100};
        margin: 1rem 0;
        font-size: 1.3rem;
      }
    }
  `;
  return (
    <FooterWrap>
      <div className="footer-inner">
        <div className="left-info">
          {/* <div className="left-logo"> */}
          <a href="">
            <h1>ALCHOHOL</h1>
            <h1>FREE</h1>
          </a>
          {/* </div> */}
          <ul className="company-nav">
            <li>
              <a href="/paycom">
                <p>매장안내</p>
              </a>
              <p className="l">|</p>
            </li>
            <li>
              <a href="/">
                <p>공지사항</p>
              </a>
              <p className="l">|</p>
            </li>
            <li>
              <a href="/">
                <p>개인정보처리방침</p>
              </a>
              <p className="l">|</p>
            </li>
            <li>
              <a href="/">
                <p>이용약관</p>
              </a>
            </li>
          </ul>
          <div className="left-p">
            <p>주식회사 그린 | 대표 그린아트 | 대구광역시 중구</p>
            <p>사업자번호 : 105-87-52430사업자정보확인</p>
            <p>통신판매번호 : 제 2011-서울마포-1083호</p>
            <p>개인정보보호책임자 : 그린아트</p>
            <p>개인정보보호책임자 : 그린아트</p>
            <p>대표전화(유료) : 02-1644-7710 | 이메일 : aaaa@gmail.com</p>
          </div>
        </div>
        <div className="right-info">
          <div>
            <p>고객전화유료</p>
            <h1>010-111-1111</h1>
            <p>vdfasdfsdf</p>
          </div>
        </div>
      </div>
    </FooterWrap>
  );
};

export default BasicFooter;
