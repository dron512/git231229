import React, { useEffect, useState } from "react";
import SideBt from "../../components/basic/SideBt";
import SideTitle from "../../components/basic/SideTitle";
import mainProductData from "../../mock/mainProductData.json";
import ProductCard from "../../components/product/ProductCard";
import { SideBar } from "../../styles/product/sideBarCss";
import {
  GridContainer,
  ProListWrap,
  ProductWrap,
} from "../../styles/product/proWrapCss";
import ProSearch from "../../components/product/ProSearch";
import { useLocation, useNavigate } from "react-router-dom";

const ProductPage = () => {
  // side => Param의 숫자인거임
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const side = parseInt(queryParams.get("side"));

  const navigate = useNavigate();

  const [activeSide, setActiveSide] = useState(side);
  const [selecteOption, setSelecteOption] = useState(0);
  const [searchText, setSearchText] = useState("");

  const handleOption = e => {
    const newValue = parseInt(e.target.value);
    setSelecteOption(prevState => newValue);
    console.log("글씨", newValue);
  };
  const handleSearchText = e => {
    setSearchText(e.target.value);
    // console.log("검색어 입력", searchText);
  };

  const handleClick = sideId => {
    setActiveSide(sideId);
    console.log("선택된 사이드바", sideId);
    // query도 바껴야함 지금 안바뀜
    navigate(`/product?side=${sideId}`);
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

  useEffect(() => {
    console.log("검색어,정렬", searchText, selecteOption);
    setActiveSide(side);
  }, [searchText, selecteOption, side]);

  return (
    <ProductWrap>
      <SideBar>
        <SideTitle sideTitle="WHISKEY" />
        <hr />
        <div className="side-nav">
          {console.log(`activeSide ${activeSide}`)}
          <SideBt
            sidenNm="ALL"
            sideId={0}
            active={activeSide === 0} // 고유 숫자와 비교
            onClick={() => handleClick(0)} // 고유 숫자 전달
          />
          <SideBt
            sidenNm="분류1"
            sideId={1}
            active={activeSide === 1}
            onClick={() => handleClick(1)}
          />
          <SideBt
            sidenNm="분류2"
            sideId={2}
            active={activeSide === 2}
            onClick={() => handleClick(2)}
          />
        </div>
      </SideBar>
      <ProListWrap>
        {/* 검색어, 정렬 */}
        <ProSearch
          selecteOption={selecteOption}
          onChangeOption={handleOption}
          searchText={searchText}
          onSearchText={handleSearchText}
          onSubmit={handleClickSubmit}
        />
        <GridContainer>
          {mainProductData.map((product, index) => (
            <ProductCard key={index} product={product} />
          ))}
        </GridContainer>
      </ProListWrap>
    </ProductWrap>
  );
};

export default ProductPage;
