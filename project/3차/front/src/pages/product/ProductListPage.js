import React, { useEffect, useMemo, useState } from "react";
import { useMutation, useQuery } from "react-query";
import {
  SignAlcholSearch,
  getAlcholType,
  getRecent,
  getUserRecent,
  nonSignAlcholSearch,
} from "../../api/productApi";
import ProductCard from "../../components/product/ProductCard";
import ProductSidebar from "../../components/product/ProductSidebar";
import ProSearch from "../../components/product/ProSearch";
import useCustomLogin from "../../hooks/useCustomLogin";
import { useCustomQuery } from "../../hooks/useCustomQuery";
import {
  GridContainer,
  ProListWrap,
  ProductWrap,
} from "../../styles/product/proWrapCss";


const ProductPage = ({test}) => {
  const { isLogin } = useCustomLogin();
  const { type, sub, search, MoveToSearch } = useCustomQuery();
  const params = { type, sub, search };

  // @AREA  이 부분은 테스트용
  const initState = [
    {
      code: 0,
      name: "",
      price: 0,
      ratingaverage: 0,
      picture: "",
    },
  ];
  const searchInitState = {
    searchcontents: search,
  };
  const [alcoholSearch, setAlcoholSearch] = useState(searchInitState);

  const mainCategory = `${params.type}`;
  const subCategory = `${params.sub}`;

  // const [productData, setProductData] = useState(initState);
  const { data: productData } = useQuery({
    queryKey: ["product/list", params],
    queryFn: () => getAlcholType(mainCategory, subCategory),
  });

  const sideParam = params.type;
  const [searchData, setSearchData] = useState(initState);

  const SearchMutation = useMutation({
    mutationFn: search => nonSignAlcholSearch({ search }),
    onSuccess: result => {
      MoveToSearch(alcoholSearch.searchcontents);
      setSearchData(result);
    },
    onError: () => {},
  });

  // 회원용 서치
  const UserSearchMutation = useMutation({
    mutationFn: search => SignAlcholSearch({ search }),
    onSuccess: result => {
      MoveToSearch(alcoholSearch.searchcontents);
      setSearchData(result);
    },
    onError: () => {},
  });

  const handleChangeSearch =  e => {
    setAlcoholSearch(prevValue => ({
      searchcontents: e.target.value,
    }));
  };

  const [searchText, setSearchText] = useState();
  // const handleClickSearch = () => {
  //   SearchMutation.mutate(alcoholSearch);
  // };

  const handleClickSearch = () => {
    if (isLogin) {
      UserSearchMutation.mutate(alcoholSearch);
    } else {
      SearchMutation.mutate(alcoholSearch);
    }
  };

  // @AREA  Select(Sort) 관련
  const selectInitState = {
    category: "",
  };
  
  const [select, setSelect] = useState(selectInitState);
  const handleClickSelect = e => {
    console.log("선택된 카테고리", e.target.value);
    setSelect(prevValue => ({
      ...prevValue,
      // category는 API가 없어서 임의로 넣은 변수
      category: e.target.value,
    }));
    console.log("선택된 카테고리", select);
  };

  // 최근 검색어
  const { data: recentData, refetch } = useQuery({
    queryKey: [],
    queryFn: () => {
      if (isLogin) {
        getUserRecent();
      }
    },
    enabled: false,
  });

  // const recentData = data;
  // recentData => 일딴 회원기준으로 데이터는 나옴
  console.log("검색어 결과 ", recentData);
  const handleClickRecent = () => {
    console.log("검색바 클릭");
    // setRecentFlag(recnetFlag);
    refetch();
  };

  const searchWord = event => {
    setSearchText(event.target.value);
  };

  useEffect(()=>{
    if(search){
      setAlcoholSearch(prevValue => ({
        ...prevValue,
        searchcontents: search,
      }));
      handleClickSearch();
    }
  },[])

  return (
    <ProductWrap>
      {/* Side-bar Component */}
      { <ProductSidebar type={sideParam} search={search} />}

      {/* Search-bar Component */}
      <ProListWrap>
        <ProSearch
          // @COMMENT Search Props
          onSearchChange={e => handleChangeSearch(e)}
          searchValue={alcoholSearch.searchcontents}
          searchName="searchcontents"
          searchPlaceholder="검색할 주류를 입력해주세요."
          onSearchClick={handleClickSearch}
          // @COMMENT Select Props
          onSelectChange={e => handleClickSelect(e)}
          selectValue={select.category}
          onRecentClick={handleClickRecent}
        />
        {/* <ProSearchForm>
        <div className="search-wrap">
          <div className="search-info">
            <input
              type="text"
              className="search-word"
              placeholder={'검색할 주류를 입력해주세요.'}
              name={'searchcontents'}
              onChange={searchWord}
            />
            <button className="search-bt" onClick={searchAlcohol}>
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
            // onChange={onSelectChange}
          >
            <option value={0}>인기순</option>
            <option value={1}>높은 가격순</option>
            <option value={2}>낮은 가격순</option>
          </select>
        </div>
        </ProSearchForm> */}
        <div></div>

        {/* Content Component (Card) */}
        <GridContainer>
          {productData?.map((product, index) => {
              return <ProductCard key={index} data={product} />;
          })}

          {/* Search - Component */}
          {searchData?.map((product, index) => (
            <ProductCard key={index} data={product} />
          ))}
        </GridContainer>
      </ProListWrap>
    </ProductWrap>
  );
};

export default ProductPage;
