import styled from "@emotion/styled/macro";
import React, { useEffect, useState } from "react";
import { CardContainer, CardFlex } from "../../styles/main/cardStlye";
import { Common } from "../../styles/CommonCss";

import { useNavigate } from "react-router";
import useCustomMove from '../../hooks/useCustomMove';

const initState = [
  {
    code: 3,
    name: "",
    picture: "",
    price: 45000,
    ratingaverage: 0,
  },
];
const CardSet = ({ data }) => {
  const { moveToDetail } = useCustomMove();
  const navigate = useNavigate();
  const newData = data ? data.slice(0, 3) : [];
  // const [newData, setNewData] = useState(initState);

  const CardsWrapper = styled.div`
    display: flex;
    justify-content: space-around;
  `;

  return (
    <CardsWrapper>
      {newData.map((product, index) => {
        const picSrc = product.picture;
        return (
          <CardContainer key={index}>
            <a
              onClick={() => {
                console.log(product,'evvvvvvvvvvvvvvv')
                moveToDetail(product?.code)
                window.scrollTo(0, 0); // 페이지 상단으로 스크롤 이동
              }}
            >
              <img
                className="card-img"
                src={picSrc}
                alt={product.picture}
              />
            </a>

            <CardFlex>
              <div className="tagform">
                <img src="./images/star.png" alt="star" />
                <p>{product.ratingaverage}</p>
              </div>
            </CardFlex>
            <p className="productNm" style={{ color: Common.color.p900 }}>
              {product.name}
            </p>
            {/* <p className="productNm">{product.content}</p> */}
            <h2 className="price">{product.price}원</h2>
          </CardContainer>
        );
      })}
    </CardsWrapper>
  );
};

export default CardSet;
