import React, { useEffect, useState } from "react";
import { HeaderNavWrap } from "../../styles/product/proNavCss";
import HeaderNav from "./HeaderNav";
import { useLocation, useNavigate } from "react-router";
import {
  MarginB10,
  MarginB20,
  MarginB30,
  MarginB40,
} from "../../styles/common/reviewProductCss";
import { useRecoilState } from "recoil";
import { categoryData } from "../../mock/categoryData";
import { queryParamsState } from "../../atom/queryParamsState";

const HeaderNavPull = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [queryParams, setQueryParams] = useRecoilState(queryParamsState);
  const [activeMain, setActiveMain] = useState("위스키"); // 기본값 설정
  const [activeSub, setActiveSub] = useState(null);
  const [selectedOption, setSelectedOption] = useState(0);

  useEffect(() => {
    // URL 쿼리 파라미터 파싱 및 상태 업데이트
    const searchParams = new URLSearchParams(location.search);
    const params = {};
    for (const [key, value] of searchParams) {
      params[key] = value;
    }
    setQueryParams(params);
  }, [location.search, setQueryParams]);

  const handleMainClick = mainId => {
    // 메인 클릭 시 URL 쿼리 파라미터 업데이트
    setActiveMain(mainId);
    setActiveSub(null); // 새로운 메인을 클릭하면 선택한 서브 카테고리를 초기화
    navigate(`/pick?main=${mainId}`);
  };

  const handleSubClick = subId => {
    setActiveSub(subId);
    navigate(`/pick?main=${activeMain}&sub=${subId}`);
  };

  return (
    <div>
      <HeaderNavWrap>
        {categoryData.map((category, index) => (
          <HeaderNav
            key={index}
            mainNm={category.main}
            mainId={category.main}
            active={activeMain === category.main}
            onClick={() => handleMainClick(category.main)}
          />
        ))}
      </HeaderNavWrap>
      <MarginB40 />
      <HeaderNavWrap>
        {activeMain &&
          categoryData
            .find(category => category.main === activeMain)
            ?.subs.map((sub, index) => (
              <HeaderNav
                key={index}
                subNm={sub}
                subId={sub}
                active={activeSub === sub}
                onClick={() => handleSubClick(sub)}
              />
            ))}
        {activeMain === "리큐르" && (
          // 서브카테고리가 없어서 그영역만큼 채우기
          <div style={{ height: "28px" }}></div>
        )}
      </HeaderNavWrap>
    </div>
  );
};

export default HeaderNavPull;
