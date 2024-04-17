import React, { useEffect, useState } from "react";
import ProductCard from "./ProductCard";
import styled from "@emotion/styled";
import CommunityTitle from "../../components/basic/CommunityTitle";
import { Pagination } from "antd";
import LowHighBt from "../../components/product/LowHighBt";
import {
  GridContainer,
  MealButton,
  PagiWarp,
  ProductWrap,
} from "../../styles/product/ProductGridStyle";
import { getProductPage } from "../../api/product/productApi";
import useCustomLogin from "../../hooks/useCustomLogin";
import { useNavigate } from "react-router";

const initState = {
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

const BreastfeedingProduct = () => {
  const [productData, setProductData] = useState([]);
  const [listProductData, setlistProductData] = useState([]);
  const [activeCategory, setActiveCategory] = useState(0);
  const [activeSubcategory, setActiveSubcategory] = useState(1);
  const [currentPage, setCurrentPage] = useState(0);
  const [itemsPerPage] = useState(16);
  const [serverData, setServerData] = useState(initState);

  // soltby====================================
  const [sortBy, setSortBy] = useState(0); // 기본값으로 최신순(0)을 설정
  const [activeLHFilter, setActiveLHFilter] = useState(0);

  const handleChangeSortBy = newSortBy => {
    // console.log("newSortBy", newSortBy);
    setSortBy(newSortBy);
    // 여기서 다른 작업을 수행할 수도 있습니다.
  };

  useEffect(() => {
    fetchData();
  }, [sortBy]);
  // soltby end====================================

  useEffect(() => {
    fetchData();
  }, [activeSubcategory]);

  const fetchData = () => {
    // const tempObj = {
    //   imiddle: activeSubcategory,
    //   imain: 0,
    //   sortBy: sortBy,
    //   page: 1,
    // };
    // console.log(tempObj);
    getProductPage({
      productParam: {
        imiddle: activeSubcategory,
        imain: 5,
        sortBy: sortBy,
        page: 1,
      },
      successFn,
      failFn,
      errorFn,
    });
  };

  const successFn = data => {
    console.log("successFn : ", data);
    setProductData(data);
    // setServerData(Array(data.products.length).fill(false));
  };
  const failFn = data => {
    console.log("failFn : ", data);
    alert("failFn : 데이터 호출에 실패하였습니다.");
  };

  const errorFn = data => {
    console.log("errorFn : ", data);
    alert("서버상태 불안정 그래서, 데모테스트했음.");
    setProductData(data);
    // setServerData(Array(data.products.length).fill(false));
  };
  // 이동 함수
  const iproductNavi = useNavigate();
  const handleClickLowHigh = filter => {
    setActiveLHFilter(filter);
  };
  const handleCheckboxChange = index => {
    setServerData(prevProductlist => {
      const updatedProduct = [...prevProductlist];
      updatedProduct[index] = !updatedProduct[index];
      return updatedProduct;
    });
  };

  const handleSubcategoryClick = subcategory => {
    setSortBy(0);
    setActiveLHFilter(0);
    setActiveSubcategory(subcategory);
    setCurrentPage(1);
  };

  const handlePageChange = page => {
    setCurrentPage(page);
  };

  return (
    <ProductWrap>
      <div>
        <div className="protitle">
          <CommunityTitle
            maintxt="모유/수유용품"
            // 이이이
            subtxt="배송 및 상품관련 공지사항을 확인해 주세요."
          />
        </div>

        <div>
          <MealButton
            onClick={() => handleSubcategoryClick(1)}
            active={activeSubcategory === 1}
          >
            수유용품
          </MealButton>
          <MealButton
            onClick={() => handleSubcategoryClick(2)}
            active={activeSubcategory === 2}
          >
            모유용품
          </MealButton>
          {/* <MealButton
            onClick={() => handleSubcategoryClick(3)}
            active={activeSubcategory === 3}
          >
            중분류3
          </MealButton>
          <MealButton
            onClick={() => handleSubcategoryClick(4)}
            active={activeSubcategory === 4}
          >
            중분류4
          </MealButton> */}
        </div>

        <LowHighBt
          onChangeSortBy={handleChangeSortBy}
          activeLHFilter={activeLHFilter}
          setActiveLHFilter={setActiveLHFilter}
        />

        <GridContainer itemsPerPage={itemsPerPage}>
          {productData.map(product => (
            <ProductCard
              onClick={() => iproductNavi(`/item/${product.iproduct}`)}
              key={product.iproduct}
              product={product}
              onCheckboxChange={handleCheckboxChange}
            />
          ))}
        </GridContainer>
        <PagiWarp>
          <Pagination
            current={currentPage}
            onChange={handlePageChange}
            total={productData.length}
            pageSize={itemsPerPage}
            className="pagination"
          />
        </PagiWarp>
      </div>
    </ProductWrap>
  );
};

export default BreastfeedingProduct;
