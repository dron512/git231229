// ProductCard.js

import React, { useEffect, useState } from "react";
import styled from "@emotion/styled";
import {
  CardContainer,
  CardFlex,
  HeartButton,
  TagStyle,
} from "../../styles/product/productCardStyle";
import { useNavigate } from "react-router";

import useCustomLogin from "../../hooks/useCustomLogin";
import { putWish } from "../../api/product/productApi";
import { API_SERVER_HOST } from "../../util/util";

const prefix = `${API_SERVER_HOST}/api/order`;
const ProductCard = ({ product, onselet }) => {
  const { isLogin } = useCustomLogin();
  const [isHeartChecked, setHeartChecked] = useState(product.likeProduct === 1);
  const iproductNavi = useNavigate();

  const handleHeartButtonClick = async () => {
    const newValue = !isHeartChecked ? 1 : 0;
    setHeartChecked(!isHeartChecked);
    // console.log("제품 pk값 내놔 : ", product.iproduct);

    // console.log(newValue);

    try {
      // api.js에 정의된 updateLike 함수를 사용하여 서버에 데이터를 업데이트
      const response = await putWish({
        iproduct: product.iproduct,
        successFn,
        failFn,
        errorFn,
      });

      // console.log("putWish 함수에서 받은 응답:", response);

      if (response !== undefined) {
        // console.log("하트업데이트 성공!", product.iproduct, response);
      } else {
        // console.error("putWish 함수에서 응답이 없습니다.");
      }
    } catch (error) {
      // console.error("하트업데이트 초오비사아아아앙", error);
    }
  };

  const successFn = result => {
    // console.log(result);
  };
  const failFn = result => {
    // console.log("찜 업데이트 실패: ", result);
  };
  const errorFn = result => {
    // console.log("찜 업데이트 에러: ", result);
  };

  return (
    <CardContainer>
      <img
        className="card-img"
        // src={`/pic/${product.iproduct}/${product.repPic}`}
        // src={`${API_SERVER_HOST}/pic/${product.iproduct}/${product.repPic}`}
        src={`${API_SERVER_HOST}/pic/product/${product.iproduct}/${product.repPic}`}
        // src={product.repPic}
        alt={product.repPic}
        // onClick={onselet}
        onClick={() => iproductNavi(`/item/${product.iproduct}?page=1`)}
      />

      <CardFlex>
        <div className="tagform">
          {product.popFl === 1 && (
            <TagStyle
              color="#FF4F4F"
              borderColor="#FF4F4F"
              letter-spacing="0.75px"
            >
              인기상품
            </TagStyle>
          )}
          {product.newFl === 1 && (
            <TagStyle
              color="#4F95FF"
              borderColor="#4F95FF"
              letter-spacing="3px"
            >
              신상품
            </TagStyle>
          )}
        </div>

        <div className="review">
          <p>리뷰{product.reviewCnt}</p>
          <HeartButton
            checked={isHeartChecked}
            onClick={handleHeartButtonClick}
          >
            <img
              src={
                isHeartChecked
                  ? process.env.PUBLIC_URL + "/assets/images/heart.svg"
                  : process.env.PUBLIC_URL + "/assets/images/heartoff.svg"
              }
              alt="heart"
              className="heart-icon"
              style={{ cursor: "pointer" }}
            />
          </HeartButton>
        </div>
      </CardFlex>
      <p className="productNm">{product.productNm}</p>
      <h2 className="price">{product.price.toLocaleString()}원</h2>
    </CardContainer>
  );
};

export default ProductCard;
