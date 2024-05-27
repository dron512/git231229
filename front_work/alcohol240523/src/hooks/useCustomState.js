import React, { useState } from "react";

export const useCustomState = () => {
  const [searchText, setSearchText] = useState("");

  // 검색어 텍스트
  const handleSearchText = e => {
    setSearchText(e.target.value);
    // console.log("검색어 입력", searchText);
  };

  // 검색버튼
  const handleClickSubmit = e => {
    e.preventDefault();
    setSearchText("");
    // fetchData();
    console.log("나 돋보기 버튼", searchText);
  };

  return handleSearchText, handleClickSubmit;
};

export default useCustomState;
