import React, { useEffect, useState } from "react";
import ProductCard from "./ProductCard";
import styled from "@emotion/styled";
import CommunityTitle from "../../components/basic/CommunityTitle";
import { Modal, Pagination } from "antd";
import LowHighBt from "../../components/product/LowHighBt";
import {
  GridContainer,
  MealButton,
  PagiWarp,
  ProductWrap,
} from "../../styles/product/ProductGridStyle";
import { getProductPage } from "../../api/product/productApi";
import MealModal from "../../components/modal/MealModal";
import AddressConfirm from "../../components/modal/AddressConfirm";
import {
  ButtonContainer,
  OpenModalButton,
} from "../../styles/modal/productModalStyle";

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

const MealProduct = () => {
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

  // 모달 여기 다 넣죠
  const [modalOpen, setModalOpen] = useState(false);

  // 모달 열기
  const openModal = () => {
    setModalOpen(true);
  };

  // 모달 닫기
  const closeModal = () => {
    setModalOpen(false);
  };
  // 모달끝========================================

  const handleChangeSortBy = newSortBy => {
    // console.log("newSortBy", newSortBy);
    setSortBy(newSortBy);
    // 여기서 다른 작업을 수행할 수도 있습니다.
  };

  const handleClickLowHigh = filter => {
    setActiveLHFilter(filter);
  };
  useEffect(() => {
    fetchData();
  }, [sortBy]);
  // soltby end======================================

  useEffect(() => {
    fetchData();
  }, [activeSubcategory]);

  const fetchData = () => {
    getProductPage({
      productParam: {
        imiddle: activeSubcategory,
        imain: 1,
        sortBy: sortBy,
        page: 1,
      },
      successFn,
      failFn,
      errorFn,
    });
  };

  const successFn = data => {
    // console.log("successFn : ", data);
    setProductData(data);
    // setServerData(Array(data.products.length).fill(false));
  };
  const failFn = data => {
    // console.log("failFn : ", data);
    alert("데이터 호출에 실패하였습니다.");
  };

  const errorFn = data => {
    // console.log("errorFn : ", data);
    alert("서버상태 불안정");
    setProductData(data);
    // setServerData(Array(data.products.length).fill(false));
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
            maintxt="이유식"
            // 이이이
            subtxt="배송 및 상품관련 공지사항을 확인해 주세요."
          />
          <ButtonContainer>
            <OpenModalButton onClick={openModal}>🥣</OpenModalButton>
            {modalOpen && <MealModal closeModal={closeModal} />}
          </ButtonContainer>
        </div>

        <div>
          <MealButton
            onClick={() => handleSubcategoryClick(1)}
            active={activeSubcategory === 1}
          >
            초기(4~6개월)
          </MealButton>
          <MealButton
            onClick={() => handleSubcategoryClick(2)}
            active={activeSubcategory === 2}
          >
            중기(7~9개월)
          </MealButton>
          <MealButton
            onClick={() => handleSubcategoryClick(3)}
            active={activeSubcategory === 3}
          >
            후기(10~12개월)
          </MealButton>
          <MealButton
            onClick={() => handleSubcategoryClick(4)}
            active={activeSubcategory === 4}
          >
            완료기(12~24개월)
          </MealButton>
        </div>

        <LowHighBt
          onChangeSortBy={handleChangeSortBy}
          activeLHFilter={activeLHFilter}
          setActiveLHFilter={setActiveLHFilter}
        />

        <GridContainer itemsPerPage={itemsPerPage}>
          {productData.map(product => (
            <ProductCard
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

export default MealProduct;
