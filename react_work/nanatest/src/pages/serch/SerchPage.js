import styled from "@emotion/styled";
import React, { useEffect, useMemo, useState } from "react";

import {
  SearchBt,
  SearchGridContainer,
  SearchPagiWarp,
  SearchWrap,
  SearchWrapf,
} from "../../styles/search/searchFormStyle";
import { PagiWarp } from "../../styles/product/ProductGridStyle";
import ProductCard from "../product/ProductCard";
import { SearchBox } from "../../styles/search/resetBtnStyle";
import LowHighBt from "../../components/product/LowHighBt";
import { Pagination } from "antd";
import { postSearchPage } from "../../api/product/searchApi";
import { useLocation } from "react-router";
import { useCallback } from "react";

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

const SearchPage = () => {
  const locationInfo = useLocation();
  // console.log("useNavigate 의 sate 활용해보자", locationInfo);
  const { searchTextInput } = locationInfo.state;
  // console.log(locationInfo.state);

  // 사용자가 버튼을 클릭해서 검색을 요청했는지 플래그 역할
  const [userSearchActive, setUserSearchActive] = useState(false);

  // 카테고리 아이템 출력된 경우 페이지당 16개만 받는 용도
  const [itemsPerPage] = useState(16);

  //  페이지 카운팅
  const [currentPage, setCurrentPage] = useState(0);

  // 상품 리스트 목록
  const [productData, setProductData] = useState([]);

  // start x버튼 (검색을 해야만 x버튼이 보이게)
  const [searchText, setSearchText] = useState(searchTextInput);

  // 가격대 관련
  const [minPrice, setMinPrice] = useState(0);
  const [maxPrice, setMaxPrice] = useState(0);

  // 카테고리 모음 배열 =======================
  const [cateArr, setCateArr] = useState([]);
  const maxCount = 3;

  // 리스트  출력 순서 정렬
  const [sortBy, setSortBy] = useState(0); // 기본값으로 최신순(0)을 설정
  const [activeLHFilter, setActiveLHFilter] = useState(0);

  //  정렬
  const handleChangeSortBy = newSortBy => {
    // console.log("정렬방식", newSortBy);
    setSortBy(newSortBy);
  };

  // 카테고리 모음
  const handleClickAdd = _cate => {
    // 이미 선택된 카테고리인지 확인
    const isAlreadySelected = cateArr.some(
      cat => cat.imiddle === _cate.imiddle && cat.imain === _cate.imain,
    );

    if (isAlreadySelected) {
      // 이미 선택된 카테고리면 해제
      setCateArr(
        cateArr.filter(
          cat => !(cat.imiddle === _cate.imiddle && cat.imain === _cate.imain),
        ),
      );
    } else if (cateArr.length >= maxCount) {
      // 최대 개수 초과 시 알림
      alert("3개까지만 검색 카테고리를 선택할 수 있습니다.");
    } else {
      // 선택되지 않았고 최대 개수에 도달하지 않은 경우 선택
      setCateArr([...cateArr, _cate]);
    }
  };

  // 검색 버튼 클릭시 처리
  const handleClickSearch = e => {
    e.preventDefault();

    setSortBy(0);
    setActiveLHFilter(0);

    // 사용자는 검색을 했다.
    setUserSearchActive(true);
    fetchData();
  };

  // 페이지 선택시 처리
  const handlePageChange = page => {
    setCurrentPage(page);
  };

  const handleInputChange = e => {
    setSearchText(e.target.value);
  };

  const handleResetButtonClick = () => {
    setSearchText("");
  };

  // 서버연동
  const fetchData = () => {
    // 검색 버튼 클릭시만 API 날리기
    if (userSearchActive) {
      // 결과가 오기 전까지는 무효화
      setUserSearchActive(false);
      postSearchPage({
        searchParam: {
          keyword: searchText,
          minPrice: minPrice,
          maxPrice: maxPrice,
          sortBy: sortBy,
          cat: cateArr,
          page: 1,
        },
        successFn,
        failFn,
        errorFn,
      });
    }
  };

  const successFn = data => {
    // 검색 쿼리 날리지 않겠다.
    setUserSearchActive(false);
    // console.log("successFn : ", data);
    setProductData(data);
    // setServerData(Array(data.products.length).fill(false));
  };
  const failFn = data => {
    // 검색 쿼리 날리지 않겠다.
    setUserSearchActive(false);
    // console.log("failFn : ", data);
    alert("failFn : 데이터 호출에 실패하였습니다.");
  };

  const errorFn = data => {
    // 검색 쿼리 날리지 않겠다.
    setUserSearchActive(false);
    // console.log("errorFn : ", data);
    alert("서버상태 불안정 그래서, 데모테스트했음.");
    // setProductData(data.products);
    // setServerData(Array(data.products.length).fill(false));
  };

  useEffect(() => {
    // console.log("sortBy 변경 Effect ", sortBy);
    // console.log("currentPage 변경 Effect ", currentPage);
    fetchData();
  }, [sortBy, currentPage]);

  return (
    <div>
      <SearchWrap>
        <div className="srech-init">
          <div className="border-word">
            <div className="searchWord">
              <h1>검색어: {searchText}</h1>
            </div>

            <div className="cateBt">
              <h1>카테고리</h1>
              <div className="mealwrap">
                <div className="input-cate">
                  <h2>이유식</h2>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 1, imain: 1 })}
                    // active={activeSubcategory === 1}
                    active={cateArr.some(
                      cat => cat.imiddle === 1 && cat.imain === 1,
                    )}
                  >
                    초기(4~6개월)
                  </SearchBt>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 2, imain: 1 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 2 && cat.imain === 1,
                    )}
                  >
                    중기(7~9개월)
                  </SearchBt>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 3, imain: 1 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 3 && cat.imain === 1,
                    )}
                  >
                    후기(10~12개월)
                  </SearchBt>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 4, imain: 1 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 4 && cat.imain === 1,
                    )}
                  >
                    완료기(12~24개월)
                  </SearchBt>
                </div>
                <div className="input-cate">
                  <h2>유아가전</h2>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 5, imain: 2 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 5 && cat.imain === 3,
                    )}
                  >
                    살균기
                  </SearchBt>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 6, imain: 2 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 6 && cat.imain === 2,
                    )}
                  >
                    기타제품
                  </SearchBt>
                </div>
                <div className="input-cate">
                  <h2>놀이용품</h2>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 7, imain: 3 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 7 && cat.imain === 3,
                    )}
                  >
                    유아교구
                  </SearchBt>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 8, imain: 3 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 8 && cat.imain === 3,
                    )}
                  >
                    애착인형
                  </SearchBt>
                </div>
                <div className="input-cate">
                  <h2>위생용품</h2>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 9, imain: 4 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 9 && cat.imain === 4,
                    )}
                  >
                    기저귀
                  </SearchBt>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 10, imain: 4 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 10 && cat.imain === 4,
                    )}
                  >
                    목욕용품
                  </SearchBt>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 11, imain: 4 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 11 && cat.imain === 4,
                    )}
                  >
                    기타 위생용품
                  </SearchBt>
                </div>
                <div className="input-cate">
                  <h2>모유/수유용품</h2>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 12, imain: 5 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 12 && cat.imain === 5,
                    )}
                  >
                    수유용품
                  </SearchBt>
                  <SearchBt
                    type="button"
                    onClick={() => handleClickAdd({ imiddle: 13, imain: 5 })}
                    active={cateArr.some(
                      cat => cat.imiddle === 13 && cat.imain === 15,
                    )}
                  >
                    모유용품
                  </SearchBt>
                </div>
              </div>
            </div>
            <div className="input-price">
              <h1>가격대</h1>
              <input
                type="number"
                placeholder="최소 가격"
                onChange={e => setMinPrice(parseInt(e.target.value))}
              />

              <p>~</p>
              <input
                type="number"
                placeholder="최대 가격"
                onChange={e => setMaxPrice(parseInt(e.target.value))}
              />

              {/* <input type="submit" /> */}
              {/* <button onClick={e => handleClickSearch(e)}>검색</button> */}
            </div>
            <div className="input-search">
              <h1>검색</h1>
              {/* <input type="text" /> */}

              <SearchBox showResetButton={!!searchText}>
                <input
                  type="text"
                  placeholder="검색어를 입력하세요"
                  autoFocus
                  value={searchText}
                  onChange={handleInputChange}
                />
                {/* <button
                  className="btn-reset"
                  type="reset"
                  onClick={handleResetButtonClick}
                >
                  X
                </button> */}
                <button type="button" onClick={e => handleClickSearch(e)}>
                  검색
                </button>
              </SearchBox>
            </div>
          </div>
        </div>
      </SearchWrap>

      <LowHighBt
        onChangeSortBy={handleChangeSortBy}
        activeLHFilter={activeLHFilter}
        setActiveLHFilter={setActiveLHFilter}
        setUserSearchActive={setUserSearchActive}
      />

      <SearchPagiWarp>
        <div className="srech-initf">
          <SearchGridContainer>
            {productData.map(product => (
              <ProductCard key={product.iproduct} product={product} />
            ))}
          </SearchGridContainer>
        </div>
      </SearchPagiWarp>

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
  );
};

export default SearchPage;
