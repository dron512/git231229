import React, { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router";
import {
  getMostProduct,
  getNewProduct,
  getRandProduct,
} from "../../api/mainApi";
import CardSet from "../../components/main/CardSet";
import MainTitle from "../../components/main/MainTitle";
import { Common } from "../../styles/CommonCss";
import { MainWrap } from "../../styles/main/mainCss";
import { PickUpCard } from "../../styles/main/pickupCardCss";
import BasicLayout from "../../layout/BasicLayout";
import { getCookie } from "../../util/cookieUtil";
import axios from "axios";
import { SERVER_URL } from "../../api/config";
import { SignAlcholSearch, nonSignAlcholSearch } from "../../api/productApi";
import useCustomLogin from "../../hooks/useCustomLogin";
import { useCustomQuery } from "../../hooks/useCustomQuery";
import { useMutation } from "react-query";
import { GridContainer } from "../../styles/product/proWrapCss";
import ProductCard from "../../components/product/ProductCard";
import ProductPage from '../product/ProductListPage';
import RecentSearches from "./RecentSearches";

const initState = [
  {
    code: 0,
    name: "",
    maincategory: "",
    subcategory: "",
    content: "",
    aroma: "",
    taste: "",
    finish: "",
    nation: "",
    picture: "",
    price: 0,
  },
];

const searinitState = [
  {
    code: 0,
    name: "",
    price: 0,
    ratingaverage: 0,
    picture: "",
  },
];

const Main = () => {
  const navigate = useNavigate();
  // const [mostData, setMostData] = useState(initState);
  const [mostData, setMostData] = useState([]);
  const [newdata, setNewData] = useState([]);
  const [randdata, setRandData] = useState([]);
  const [searchText, setSearchText] = useState("");
  const [display,setDisplay] = useState('none');
  const searchInitState = {
    searchcontents: "",
  };
  const searchInput = useRef();

  useEffect(() => {
    getRandProduct({
      successFn: data => {
        setRandData(data); // 성공 시 데이터 설정
      },
      failFn: data => {
        alert("most 실패");
      },
      errorFn: data => {
        alert("서버상태 불안정 다음에 most 시도");
      },
    });
  }, []);

  useEffect(() => {
    getMostProduct({
      successFn: data => {
        setMostData(data); // 성공 시 데이터 설정
      },
      failFn: data => {
        alert("most 실패");
      },
      errorFn: data => {
        alert("서버상태 불안정 다음에 most 시도");
      },
    });
  }, []);

  useEffect(() => {
    getNewProduct({
      successFn: data => {
        setNewData(data); // 성공 시 데이터 설정
      },
      failFn: data => {
        alert("most 실패");
      },
      errorFn: data => {
        alert("서버상태 불안정 다음에 most 시도");
      },
    });
    document.addEventListener("click", (event)=>{ 
      if (
        document.activeElement !== searchInput.current
      ) {
        setDisplay('none')
      }
    });
  }, []);

  //========================================

  const { isLogin } = useCustomLogin();
  const { type, sub, search, MoveToSearch } = useCustomQuery();
  const [alcoholSearch, setAlcoholSearch] = useState(searchInitState);
  const [searchData, setSearchData] = useState(searinitState);

  const handleClickSearch = () => {
    navigate('/product/list?type=위스키&search='+searchText)
    // if (isLogin) {
    //   UserSearchMutation.mutate(alcoholSearch);
    // } else {
    //   SearchMutation.mutate(alcoholSearch);
    // }
  };

  const SearchMutation = useMutation({
    mutationFn: search => nonSignAlcholSearch({ search }),
    onSuccess: result => {
      console.log("axios result :", result);
      MoveToSearch(alcoholSearch.searchcontents);
      setSearchData(result);
    },
    onError: () => {},
  });

  // 회원용 서치
  const UserSearchMutation = useMutation({
    mutationFn: search => SignAlcholSearch({ search }),
    onSuccess: result => {
      // console.log("jwtAxios result :", result);
      console.log("search :", search);
      // MoveToSearch(search);

      // setSearchData(result);
    },
    onError: () => {},
  });
  // ===================================================

  // const search = async () => {
  //   if(getCookie('member') !== undefined){
  //     await SignAlcholSearch(searchText);
  //   }else{
  //     await nonSignAlcholSearch(searchText);
  //   }

  // }

  const searchWord = e => {
    setSearchText(e.target.value);
  };

  return (
    <BasicLayout>
      <MainWrap>
        <div className="main-header">
          <p>ALCHOHOL HOLIC</p>
          <div
            style={{
              display: "flex",
              position: "relative",
              marginTop: "35px",
            }}
          >
            <div className="search-wrap">
              <input
                ref={searchInput}
                id="search"
                type="text"
                placeholder="검색어를 입력해주세요"
                className="search-word"
                onChange={searchWord}
                onFocus={()=>{ 
                  setDisplay('block');
                } }
              ></input>
              <button className="search-bt" onClick={handleClickSearch}>
                <img src="./images/search.png" />
              </button>
            </div>
          </div>
          <RecentSearches display={display}/>
          {/* <input type="button" className="search-bt" /> */}
        </div>
        <div style={{paddingTop:"300px"}}>
          <img src="./images/banner.svg"></img>
        </div>
        <PickUpCard>
          <a
            className="pickCard2"
            onClick={() => {
              if (isLogin) {
                navigate(`pick/delivery`);
                window.scroll(0,0);
              }else{
                alert('로그인 후 가능한 서비스입니다.')
                navigate(`sign/in`);
                window.scroll(0,0);
              }
            }}
            style={{ background: Common.color.p200 }}
          >
            <div className="pickCard">
              <b>배달 & 배송</b>
              <p>자택 배달 & 배송 서비스</p>
            </div>
          </a>
          <a
            className="pickCard2"
            onClick={() => {
              if (isLogin) {
                navigate(`pick/pick`);
                window.scroll(0,0);
              }else{
                alert('로그인 후 가능한 서비스입니다.')
                navigate(`sign/in`);
                window.scroll(0,0);
              }
            }}
            style={{
              background: Common.color.f900,
              color: `${Common.color.p000}`,
            }}
          >
            <div className="pickCard">
              <b>매장픽업</b>
              <p>
                주변 매장 & 편의점
                <br />
                예약 및 픽업
              </p>
            </div>
          </a>
        </PickUpCard>
        <div style={{ padding: "30px 0" }}>
          <MainTitle mainText="오늘의 추천술" />
          <CardSet data={randdata} />
        </div>
        <div style={{ padding: "30px 0" }}>
          <MainTitle mainText="신제품 출시" />
          <CardSet data={newdata} />
        </div>
        <div style={{ padding: "30px 0" }}>
          <MainTitle mainText="HOT 인기제품" />
          <CardSet data={mostData} />
        </div>
      </MainWrap>
    </BasicLayout>
  );
};

export default Main;
