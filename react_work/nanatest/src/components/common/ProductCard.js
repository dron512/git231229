// ProductCard.js

import React, { useState } from "react";
import useCustomMove from "../../hooks/useCustomMove";
import {
  CardContainer,
  CardContainer2,
  CardFlex,
  HeartButton,
  TagStyle,
} from "../../styles/product/productCardStyle";
import { API_SERVER_HOST } from "../../util/util";
import useCustomLogin from "../../hooks/useCustomLogin";
import MainHeartBt from "../mainpage/MainHeartBt";

const initData = {
  iproduct: 0,
  productNm: "",
  price: 0,
  rcFl: 0,
  popFl: 0,
  newFl: 0,
  reviewCnt: 0,
  likeProduct: 0,
  repPic: "",
};
const ProductCard = ({ product }) => {
  const [isHeartChecked, setHeartChecked] = useState(product.likeProduct === 1);

  const handleHeartButtonClick = () => {
    const newValue = !isHeartChecked ? 1 : 0;
    setHeartChecked(!isHeartChecked);
    // console.log(newValue);
  };

  const { moveToObj } = useCustomLogin();
  const moveToProduct = product => {
    moveToObj(`/item/${product.iproduct}?page=1`);
  };
  return (
    <CardContainer2>
      <img
        className="card-img"
        src={
          product.repPic === ""
            ? process.env.PUBLIC_URL + "/assets/images/defaultitemimg.svg"
            : `${API_SERVER_HOST}/pic/product/${product.iproduct}/${product.repPic}`
        }
        alt={product.productNm}
        onClick={() => {
          moveToProduct(product);
        }}
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
          <MainHeartBt item={product} />
        </div>
      </CardFlex>
      <p className="productNm">{product.productNm}</p>
      <h2 className="price">{product.price}원</h2>
    </CardContainer2>
  );
};

export default ProductCard;
