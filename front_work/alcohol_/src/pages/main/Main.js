import styled from "@emotion/styled/macro";
import React from "react";
import { Common } from "../../styles/CommonCss";
import CardSet from "../../components/main/CardSet";
import MainTitle from "../../components/main/MainTitle";
import useCustomState from "../../hooks/useCustomState";
import { MainWrap } from "../../styles/main/mainCss";
import { PickUpCard } from "../../styles/main/pickupCardCss";

const Main = () => {
  return (
    <MainWrap>
      <div className="main-header">
        <p>ALCHOHOL HOLIC</p>
        <div
          style={{
            display: "flex",
            position: "relative",
            marginTop: "35px",
          }}
        >
          <div className="search-wrap">
            <input
              type="text"
              placeholder="검색어를 입력해주세요"
              className="search-word"
              // onChange={handleSearchText}
            ></input>
            <button
              className="search-bt"
              // onClick={handleClickSubmit}
            >
              <img src="./images/search.png" />
            </button>
          </div>
        </div>
        {/* <input type="button" className="search-bt" /> */}
      </div>
      <img src="./images/banner.svg"></img>
      <PickUpCard>
        <a href="/배달" style={{ background: Common.color.p200 }}>
          <div className="pickCard">
            <b>배달 & 배송</b>
            <p>자택 배달 & 배송 서비스</p>
          </div>
        </a>
        <a href="/픽업" style={{ background: Common.color.f900 }}>
          <div className="pickCard">
            <b>매장픽업</b>
            <p>
              주변 매장 & 편의점
              <br />
              예약 및 픽업
            </p>
          </div>
        </a>
      </PickUpCard>
      <div style={{ padding: "30px 0" }}>
        <MainTitle mainText="오늘의 추천술" />
        <CardSet />
      </div>
      <div style={{ padding: "30px 0" }}>
        <MainTitle mainText="신제품 출시" />
        <CardSet />
      </div>
      <div style={{ padding: "30px 0" }}>
        <MainTitle mainText="HOT 인기제품" />
        <CardSet />
      </div>
    </MainWrap>
  );
};

export default Main;
