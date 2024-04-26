import React, { useState } from "react";
import { MainWrap } from "../../styles/main/mainCss";
import styled from "@emotion/styled/macro";
import { Common } from "../../styles/CommonCss";
import Count from "../../components/basic/Count";
import { P16, P20, P30, PB20, PB30 } from "../../styles/basic";

import { Flex, Form, Select } from "antd";
import DetailInfo, { UlStyle } from "../../components/detail/DetailInfo";
import ListLi from "../../components/detail/ListLi";
import ReviewProduct from "../../components/detail/ReviewProduct";
import {
  BigButton,
  HeartButton,
  ItemContent,
  ItemLine,
  ItemWrap,
  MarginB20,
  MarginB40,
  PlaceBt,
  TotalAmount,
} from "../../styles/common/reviewProductCss";
import MapModal from "../../components/modal/MapModal";
import { useRecoilValue } from "recoil";
import { placeState } from "../../recoil/atom/placeState";
import { ProductItemData } from "../../mock/ProductitemData";
import { StarRev } from "../../styles/common/StarCss";
import { useNavigate } from "react-router";
import CartModal from "../../components/modal/CartModal";
import {
  GoCartModal,
  GoMapModal,
  GoPlaceModal,
} from "../../components/detail/GoCart";

export const items1 = ["1", "2", "3"];
export const items2 = ["a", "b", "c"];
const DetailedItemPage = () => {
  const navigate = useNavigate();
  const productItem = ProductItemData[0];
  const selectedPlace = useRecoilValue(placeState);
  const [count, setCount] = useState(1);
  const [isHeartChecked, setHeartChecked] = useState(1);

  const [isMapModalOpen, setMapModalOpen] = useState(false);
  const [isCartModalOpen, setCartModalOpen] = useState(false);

  const [showModal, setShowModal] = useState(false);

  // 모달관련
  const handleOpenMapModal = () => {
    setMapModalOpen(true);
  };

  const handleCloseMapModal = () => {
    setMapModalOpen(false);
  };

  const handleOpenCartModal = () => {
    setCartModalOpen(true);
  };

  const handleCloseCartModal = () => {
    setCartModalOpen(false);
  };

  const totalPrice = productItem.price * count;
  const addComma = price => {
    let returnString = price?.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return returnString;
  };
  const formattedPrice = addComma(totalPrice);
  const handleCloseModal = () => {
    setShowModal(false);
  };

  const handleHeartButtonClick = () => {
    const newValue = !isHeartChecked ? 1 : 0;
    setHeartChecked(!isHeartChecked);
    console.log("하트클리이이이잉익", newValue);
  };

  const starImages = Array.from({ length: productItem.stars }, (_, index) => (
    <img
      key={index}
      src={process.env.PUBLIC_URL + "/images/star.png"}
      alt="star"
    />
  ));
  const AA = styled.div`
    display: flex;
    position: relative;
    align-items: center;
    gap: 30px;
    margin-bottom: 20px;
    /* justify-content: space-between; */
  `;

  return (
    <ItemWrap>
      <ItemContent>
        <img src={process.env.PUBLIC_URL + "/images/moon.jpg"} />
        <div className="information">
          <AA>
            <h1>{productItem.name}</h1>
            <HeartButton
              checked={isHeartChecked}
              onClick={handleHeartButtonClick}
            >
              <img
                src={
                  isHeartChecked
                    ? process.env.PUBLIC_URL + "/images/heartOn.svg"
                    : process.env.PUBLIC_URL + "/images/heartOff.svg"
                }
                alt="heart"
                className="heart-icon"
                style={{ cursor: "pointer" }}
              />
            </HeartButton>
          </AA>

          <P16 style={{ color: `${Common.color.p600}` }}>
            상품소개 : {productItem.introduction}
          </P16>
          <div className="starRev">
            <StarRev>{starImages}</StarRev>
            <a href="#리뷰">?리뷰더보기</a>
          </div>
          <h1>{productItem.price}원</h1>
          <div className="line" />
          {/* 맵모달 판매처 선택 버튼 */}
          <GoMapModal />
          <div className="info">
            <ul>
              <li>선택된 판매처</li>
              <li>배송정보</li>
            </ul>
            <ul>
              {selectedPlace ? (
                <li>{selectedPlace}</li>
              ) : (
                <li>판매처를 선택해주세요</li>
              )}
              {/* <li>화이트 와인</li> */}
              <li>
                <select
                  style={{
                    width: "150px",
                    height: "28px",
                    border: `1px solid ${Common.color.p300}`,
                    color: `${Common.color.p600}`,
                    fontSize: "16px",
                    // borderRadius: "5px",
                  }}
                >
                  <option>픽업</option>
                  <option>배송</option>
                </select>
              </li>
            </ul>
          </div>
          {/* <Count /> */}
          <div className="count">
            <p className="product-name">[픽업]{productItem.name}</p>
            <Count name="productCnt" setCount={setCount} count={count} />
            <p>{productItem.price}원</p>
          </div>
          <div className="line" />
          <TotalAmount>
            <P20>총 상품금액</P20>
            <P30 style={{ color: `${Common.color.f900}`, fontWeight: "bold" }}>
              {formattedPrice}원
            </P30>
          </TotalAmount>
          <div className="pay-button">
            <GoCartModal />

            <BigButton
              onClick={() => navigate(`/pay`)}
              style={{
                background: `${Common.color.f900}`,
                border: `1px solid ${Common.color.p000}`,
                color: `${Common.color.p000}`,
              }}
            >
              바로 구매하기
            </BigButton>
          </div>
        </div>
      </ItemContent>
      <ItemLine />

      {/* 상품 info */}
      <div>
        <PB20>Tasting Note</PB20>
        <UlStyle>
          <ListLi items={items1} />
          <ListLi items={items2} />
        </UlStyle>
      </div>
      <ItemLine />

      <div>
        <PB20>Information</PB20>
        <UlStyle>
          <ListLi items={items1} />
          <ListLi items={items2} />
        </UlStyle>
      </div>
      <ItemLine />
      <div>
        <PB20>Category</PB20>
        <UlStyle>
          <ListLi items={items1} />
          <ListLi items={items2} />
        </UlStyle>
      </div>
      <PB30>여기에 상세페이지 </PB30>

      {/* 리뷰 목록 */}
      <div id="리뷰">
        <MarginB40 />
        <MarginB40 />
        <PB20>리뷰()</PB20>
        <ItemLine
          style={{ background: `${Common.color.p600}`, height: "2px" }}
        />
        <ReviewProduct
          userNm="나는고라니1"
          starCount={4}
          review="아주좋아요"
          date="2020 - 20 - 20"
        />
        <ReviewProduct
          userNm="나는고라니2"
          starCount={5}
          review="아주좋아요"
          date="2020 - 20 - 20"
        />
        <ReviewProduct
          userNm="나는고라니3"
          starCount={3}
          review="아주좋아요"
          date="2020 - 20 - 20"
        />
      </div>
    </ItemWrap>
  );
};

export default DetailedItemPage;
