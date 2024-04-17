import React, { useEffect, useState } from "react";
import { getPage } from "../../api/mypage/mypageApi";
import MyPageInfo from "../../components/mypage/MyPageInfo";
import UserInfoBt from "../../components/userinfo/UserInfoBt";
import useCustomLogin from "../../hooks/useCustomLogin";
import {
  InfoBt,
  InfoBtWrap,
  InfoHead,
  InfoWrap,
  MyPageHeader,
  MyPageWrap,
  MyWishWrap,
  ProductWrap,
} from "../../styles/mypage/mypagestyle";
import ProductCard from "../../components/common/ProductCard";
import { useNavigate } from "react-router-dom";
const MyPage = () => {
  const navigate = useNavigate();
  const [productData, setProductData] = useState([]);
  const { moveToPath } = useCustomLogin();

  const myWishList = (productData && productData.myWishList) || [];

  const elementsPerRow = 4;

  const groupedData = myWishList.reduce((result, item, index) => {
    const chunkIndex = Math.floor(index / elementsPerRow);

    if (!result[chunkIndex]) {
      result[chunkIndex] = []; // 초기화
    }

    result[chunkIndex].push(item);
    return result;
  }, []);

  const handleClickAddress = e => {
    navigate("/address");
  };

  const handleClickModify = e => {
    navigate("/modifypw");
  };

  const handleClickReview = e => {
    navigate("/review");
  };

  const handleClickOl = e => {
    navigate("/ol");
  };

  useEffect(() => {
    getPage({ successFn, failFn, errorFn });
  }, []);

  const successFn = result => {
    setProductData(result);
    if (setProductData === 0) {
      // console.log("0입니다");
    }
    // console.log(result);
  };
  const failFn = result => {
    // console.log(result);
  };
  const errorFn = result => {
    // console.log(result);
  };

  // console.log(myWishList);

  return (
    <MyPageWrap>
      <MyPageHeader>
        <h2>My-Page</h2>
      </MyPageHeader>
      <UserInfoBt
        handleClickAddress={handleClickAddress}
        handleClickModify={handleClickModify}
        productData={productData}
      ></UserInfoBt>
      <InfoHead>
        <InfoWrap>
          <MyPageInfo productData={productData} />
        </InfoWrap>
      </InfoHead>
      <InfoBtWrap>
        <InfoBt onClick={() => handleClickReview()}>내가 작성한 리뷰</InfoBt>
        <InfoBt onClick={() => handleClickOl()}>주문내역 조회하기</InfoBt>
      </InfoBtWrap>
      <ProductWrap>
        <h2>Wish-List</h2>
        <h3>*찜은 최대 12개까지만 가능합니다</h3>
      </ProductWrap>
      <MyWishWrap>
        <div>
          {groupedData.map((row, rowIndex) => (
            <div key={rowIndex} style={{ display: "flex" }}>
              {row.map(item => (
                <ProductCard key={item.iproduct} product={item} />
              ))}
            </div>
          ))}
        </div>
      </MyWishWrap>
    </MyPageWrap>
  );
};

export default MyPage;
