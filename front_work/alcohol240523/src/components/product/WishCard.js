import React, { useEffect, useState } from "react";

import { useNavigate } from "react-router";
import { Common } from "../../styles/CommonCss";
import { CardFlex } from "../../styles/main/cardStlye";
import { ProCardContainer } from "../../styles/product/proCardCss";
import OptiPlaceholder from "../image-opti/OptiPlaceholder";
import OptiWireframe from "../image-opti/OptiWireframe";
import useCustomMove from "../../hooks/useCustomMove";
import { deleteWish, getWishList } from "../../api/wishListApi";

const initState = [
  {
    code: 1,
    name: "벤리악 12년 700ml",
    picture: "http://threeback.hellomh.site/images/01.jpg",
  },
];
const WishCard = ({ data }) => {
  // console.log("받은 데이터", data);
  const [wishCode, setWishCode] = useState(data.code);
  const { moveToDetail } = useCustomMove();
  const navigate = useNavigate();

  const fetchData = code => {
    console.log("상품 코드2:", wishCode);
    deleteWish({
      code: {
        code: code,
      },
      successFn,
      failFn,
      errorFn: data => {
        alert("서버상태 불안정 다음에 상품불러오기 시도");
      },
    });
  };

  const successFn = data => {
    // setWishCode(data);
  };
  const failFn = data => {
    alert("failFn : 데이터 호출에 실패하였습니다.");
  };

  return (
    // <ProCardContainer onClick={() => moveToDetail(data?.code)}>
    <ProCardContainer>
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
        onClick={() => moveToDetail(data?.code)}
      />

      <CardFlex>
        <div className="tagform">
          <button className="wish-bt" onClick={() => fetchData(data.code)}>
            <img src={process.env.PUBLIC_URL + `/images/star.png`} alt="star" />
          </button>

          <p className="productNm" style={{ color: Common.color.p900 }}>
            {data?.name}
          </p>
        </div>
      </CardFlex>

      {/* <p className="productNm" style={{ color: Common.color.p900 }}>
        {data?.name}
      </p> */}
    </ProCardContainer>
  );
};
export default WishCard;
