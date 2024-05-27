import React from "react";

import { useNavigate } from "react-router";
import { Common } from "../../styles/CommonCss";
import { CardFlex } from "../../styles/main/cardStlye";
import { ProCardContainer } from "../../styles/product/proCardCss";
import OptiPlaceholder from "../image-opti/OptiPlaceholder";
import OptiWireframe from "../image-opti/OptiWireframe";
import useCustomMove from "../../hooks/useCustomMove";

const initState = [
  {
    code: 3,
    name: "",
    picture: "",
    price: 45000,
    ratingaverage: 0,
  },
];
const ProductCard = ({ data, showGrade }) => {
  // console.log("받은 데이터", data);
  const { moveToDetail } = useCustomMove();
  const navigate = useNavigate();
  if (data.code !== 0) {
    return (
      <ProCardContainer onClick={() => moveToDetail(data?.code)}>
        <OptiPlaceholder
          alt=""
          width={240}
          height={240}
          placeholder={
            <div>
              <OptiWireframe width={240} height={240} />
            </div>
          }
          src={data?.picture}
        />
        {/* <img className="card-img" src={data?.picture} alt={data?.productNm} /> */}
        {/* <a onClick={() => navigate(`/item`)}>
        </a> */}
        {!showGrade && (
          <CardFlex>
            <div className="tagform">
              <img
                src={process.env.PUBLIC_URL + `/images/star.png`}
                alt="star"
              />
              <p>{data?.ratingaverage}</p>
            </div>
          </CardFlex>
        )}
        {/* <CardFlex>
          <div className="tagform">
            <img src={process.env.PUBLIC_URL + `/images/star.png`} alt="star" />
            <p>{data?.ratingaverage}</p>
          </div>
        </CardFlex> */}
        <p className="productNm" style={{ color: Common.color.p900 }}>
          {data?.name}
        </p>
        {/* <p className="productNm">{product?.subinfo}</p> */}
        {data?.price && <h2 className="price">{data?.price}원</h2>}
      </ProCardContainer>
    );
  }
};

export default ProductCard;
