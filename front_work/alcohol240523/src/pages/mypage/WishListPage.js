import React, { useEffect, useState } from "react";
import { GridContainer } from "../../styles/product/proWrapCss";
import ProductCard from "../../components/product/ProductCard";
import { getWishList } from "../../api/wishListApi";
import WishCard from "../../components/product/WishCard";

const WishListPage = () => {
  const [wishListData, setWishListData] = useState([]);

  useEffect(() => {
    getWishList({
      successFn: data => {
        setWishListData(data); // 성공 시 데이터 설정
      },
      failFn: data => {
        alert("상품불러오기 실패");
      },
      errorFn: data => {
        alert("서버상태 불안정 다음에 상품불러오기 시도");
      },
    });
  }, []);
  return (
    <div>
      <GridContainer>
        {wishListData.map(product => (
          <WishCard key={product.code} data={product} />
        ))}
      </GridContainer>
    </div>
  );
};

export default WishListPage;
