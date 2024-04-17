import React, { useState } from "react";
import LowHighBt from "../product/LowHighBt";
import styled from "@emotion/styled";
import { SearchBt, SearchWrap } from "../../styles/search/searchFormStyle";

const SearchForm = () => {
  const [isProperty, setIsProperty] = useState([]);

  const handleClickSearch = value => {
    if (value === "") {
      setIsProperty([""]);
    } else if (isProperty.length === 0) {
      setIsProperty([""]);
    } else if (isProperty.includes(value)) {
      setIsProperty(isProperty.filter(e => e !== value));
    } else if (isProperty.length > 0) {
      setIsProperty([...isProperty.filter(e => e !== ""), value]);
    } else {
      setIsProperty([""]);
    }
  };
  return (
    <SearchWrap>
      <div className="srech-init">
        <div className="searchWord">
          <h1>검색어</h1>
        </div>

        <div className="cateBt">
          <h1>카테고리</h1>
          <div className="mealwrap">
            <div className="input-cate">
              <h2>이유식</h2>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("장난감")}
                active={isProperty.includes("장난감")}
              >
                초기(4~6개월)
              </SearchBt>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("이유식초기")}
                active={isProperty.includes("이유식초기")}
              >
                중기(7~9개월)
              </SearchBt>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("이유식중기")}
                active={isProperty.includes("이유식중기")}
              >
                후기(10~12개월)
              </SearchBt>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("이유식후기")}
                active={isProperty.includes("이유식후기")}
              >
                완료기(12~24개월)
              </SearchBt>
            </div>
            <div className="input-cate">
              <h2>유아가전</h2>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("살균기")}
                active={isProperty.includes("살균기")}
              >
                살균기
              </SearchBt>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("기타제품")}
                active={isProperty.includes("기타제품")}
              >
                기타제품
              </SearchBt>
            </div>
            <div className="input-cate">
              <h2>놀이용품</h2>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("유아교구")}
                active={isProperty.includes("유아교구")}
              >
                유아교구
              </SearchBt>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("애착인형")}
                active={isProperty.includes("애착인형")}
              >
                애착인형
              </SearchBt>
            </div>
            <div className="input-cate">
              <h2>위생용품</h2>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("기저귀")}
                active={isProperty.includes("기저귀")}
              >
                기저귀
              </SearchBt>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("목욕용품")}
                active={isProperty.includes("목욕용품")}
              >
                목욕용품
              </SearchBt>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("기타 위생용품")}
                active={isProperty.includes("기타 위생용품")}
              >
                기타 위생용품
              </SearchBt>
            </div>
            <div className="input-cate">
              <h2>모유/수유용품</h2>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("수유용품")}
                active={isProperty.includes("수유용품")}
              >
                수유용품
              </SearchBt>
              <SearchBt
                type="button"
                onClick={() => handleClickSearch("모유용품")}
                active={isProperty.includes("모유용품")}
              >
                모유용품
              </SearchBt>
            </div>
          </div>
        </div>
        <div className="input-price">
          <h1>가격대</h1>
          <input type="text" placeholder="최소 가격" />
          <p>~</p>
          <input type="text" placeholder="최대 가격" />

          <button>검색</button>
        </div>
        <div className="input-search">
          <h1>검색</h1>
          <input type="text" />
        </div>
      </div>
    </SearchWrap>
  );
};

export default SearchForm;
