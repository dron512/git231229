import styled from "@emotion/styled";
import React from "react";
import { Link } from "react-router-dom";
import { Footerwrap } from "../../styles/basicLay/basicFootStyle";
import LinkCopy from "../../components/basic/LinkCopy";

const BasicFooter = () => {
  return (
    <Footerwrap>
      <div className="foot-head">
        <div className="inwrap">
          <ul className="foot-company">
            <li>
              <Link to="">회사소개</Link>
            </li>
            <li>
              <Link to="">이용약관</Link>
            </li>
            <li>
              <Link to="">개인정보지침관리</Link>
            </li>
            <li>
              <Link to="">쇼핑몰 이용안내</Link>
            </li>
          </ul>

          <ul className="foot-sns">
            <li>
              <Link to="">
                <img
                  src={process.env.PUBLIC_URL + "/assets/images/insta.svg"}
                />
              </Link>
            </li>

            <li>
              <Link to="">
                <img
                  src={process.env.PUBLIC_URL + "/assets/images/youtube.svg"}
                />
              </Link>
            </li>

            <li>
              <Link onClick={LinkCopy} to="">
                <img src={process.env.PUBLIC_URL + "/assets/images/clip.svg"} />
              </Link>
            </li>
          </ul>
        </div>
      </div>

      <div className="foot-body">
        <div className="inwrap-main">
          <div className="cs-center">
            <div className="cs-top">
              <div>
                <p className="bold-font">고객 센터</p>
                <p className="phone">053)572-1005</p>
                <p className="runtime">
                  평일 : 10:00 ~ 17:00
                  <br />
                  점심 : 12:00 ~ 14:00 <br />
                  공휴일 및 토.일요일 휴무
                </p>
              </div>
              <div className="cs-img">
                <img
                  src={process.env.PUBLIC_URL + "/assets/images/cs-call.svg"}
                />
              </div>
            </div>

            <Link to="/" className="cs-nav">
              1대1문의 바로가기
            </Link>
            <Link to="/commu">커뮤니티 바로가기</Link>
          </div>

          <div className="menu">
            <p className="r-font">메뉴</p>
            <ul>
              <li>
                <Link to="/mypage">마이페이지</Link>
              </li>
            </ul>
            <ul>
              <li>
                <Link to="/orderlist">주문조회</Link>
              </li>
            </ul>
            <ul>
              <li>
                <Link to="/cart">장바구니</Link>
              </li>
            </ul>
            <ul>
              <li>
                <Link to="/commu">커뮤니티</Link>
              </li>
            </ul>
          </div>
          <div className="return">
            <p className="r-font">교환 및 반품</p>
            <p>
              보내실 주소
              <br />
              대구광역시 중구 중앙대로 394, 제일빌딩 5F
            </p>
          </div>
        </div>
      </div>
      <div className="foot-info">
        <div className="inwrap">
          <p>
            상호명 (주)나나빛 대표 김주영 대표전화 053)572-1005
            개인정보관리책임자 아무개(amugae@gmail.com)
            <br />
            주소 (41937) 대구광역시 중구 중앙대로 394, 제일빌딩 5F 나나빛
            <br />
            사업자등록번호 123-45-67891 [사업자정보확인] 통신판매업신고
            0000-대구중구-0000
          </p>
          <p>COPYRIGHT @ 나나빛 브랜드 공식몰 ALL RIGHTS RESERVED.</p>
        </div>
      </div>
    </Footerwrap>
  );
};

export default BasicFooter;
