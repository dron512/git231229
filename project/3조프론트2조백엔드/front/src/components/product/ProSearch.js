import React from "react";
import { ProSearchForm } from "../../styles/common/searchCss";

const ProSearch = ({
  selecteOption,
  onChangeOption,
  searchText,
  onSearchText,
  onSubmit,
}) => {
  return (
    <div>
      <ProSearchForm>
        <div className="search-wrap">
          <div className="search-info">
            <input
              type="text"
              placeholder="검색어를 입력해주세요"
              className="search-word"
              value={searchText}
              onChange={onSearchText}
            ></input>
            <button className="search-bt" onClick={onSubmit}>
              <img src="./images/search.png" />
            </button>
          </div>
          <div className="line"></div>
          <select value={selecteOption} onChange={onChangeOption}>
            <option value={0}>인기순</option>
            <option value={1}>높은 가격순</option>
            <option value={2}>낮은 가격순</option>
          </select>
        </div>
      </ProSearchForm>
    </div>
  );
};

export default ProSearch;
