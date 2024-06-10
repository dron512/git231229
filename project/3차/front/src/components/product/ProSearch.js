import React from "react";
import { ProSearchForm } from "../../styles/common/searchCss";

const ProSearch = ({
  // selecteOption,
  // onChangeOption,
  // searchText,
  // onSearchText,
  // onSubmit,
  // handleClickSearch,
  onSearchChange,
  searchValue,
  searchName,
  // placeholder,
  onSearchClick,
  onSelectChange,
  searchPlaceholder,
  // 최근검색어
  onRecentClick,
}) => {
  return (
    <div>
      <ProSearchForm>
        <div className="search-wrap">
          <div className="search-info">
            <input
              type="text"
              className="search-word"
              placeholder={searchPlaceholder}
              name={searchName}
              value={searchValue}
              onChange={onSearchChange}
              // 테스뚜
              onClick={onRecentClick}
            />
            <button className="search-bt" onClick={onSearchClick}>
              <img src={process.env.PUBLIC_URL + `/images/search.png`} />
            </button>
          </div>

          <div className="line"></div>
          <select
            // value={selecteOption}
            // onChange={onChangeOption}
            // style={{
            //   margin: "0 auto",
            // }}
            onChange={onSelectChange}
          >
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
