import React, { useEffect, useState } from "react";
import ProSearch from "../../components/product/ProSearch";
import ProductCard from "../../components/product/ProductCard";
import {
  GridContainer,
  ProListWrap,
  ProductWrap,
} from "../../styles/product/proWrapCss";

import HeaderNavPull from "../../components/basic/HeaderNavPull";
import { PB30 } from "../../styles/basic";
import { MarginB40 } from "../../styles/common/reviewProductCss";
import { HeaderNavWrap } from "../../styles/product/proNavCss";
import { getPickProduct } from "../../api/pickProductApi";
const initState = [
  {
    code: 3,
    name: "",
    picture: "",
    price: 45000,
    ratingaverage: 0,
  },
];
const ProductPickPage = ({ titleTest, apiFunction }) => {
  const [selecteOption, setSelecteOption] = useState(0);
  const [searchText, setSearchText] = useState("");
  const [pickData, setPickData] = useState([initState]);

  const handleOption = e => {
    const newValue = parseInt(e.target.value);
    setSelecteOption(prevState => newValue);
    console.log("글씨", newValue);
  };
  const handleSearchText = e => {
    setSearchText(e.target.value);
    // console.log("검색어 입력", searchText);
  };

  // 검색 버튼 클릭시 처리
  const handleClickSubmit = e => {
    e.preventDefault();
    setSearchText("");
    // setSelecteOption(0);

    // 사용자는 검색을 했다.
    // fetchData();
    console.log("나 돋보기 버튼", searchText, selecteOption);
  };

  // useEffect(() => {
  //   // console.log("검색어,정렬", searchText, selecteOption);
  // }, [searchText, selecteOption]);

  useEffect(() => {
    apiFunction({
      successFn: data => {
        setPickData(data); // 성공 시 데이터 설정
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
    <ProductWrap>
      <ProListWrap>
        <HeaderNavWrap>
          <PB30>{titleTest}</PB30>
        </HeaderNavWrap>
        <MarginB40 />
        <HeaderNavPull />
        <MarginB40 />
        {/* 검색어, 정렬 */}
        <ProSearch
          selecteOption={selecteOption}
          onChangeOption={handleOption}
          searchText={searchText}
          onSearchText={handleSearchText}
          onSubmit={handleClickSubmit}
        />
        <GridContainer>
          {pickData.map(product => (
            <ProductCard key={product.code} data={product} />
          ))}
        </GridContainer>
      </ProListWrap>
    </ProductWrap>
  );
};

export default ProductPickPage;
