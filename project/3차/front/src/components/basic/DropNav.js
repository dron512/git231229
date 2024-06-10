import styled from "@emotion/styled/macro";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Common } from "../../styles/CommonCss";
import { DropStyle, DropWrap } from "../../styles/basic/dropNavCss";

const DropNav = () => {
  const [isDropdownOpen1, setIsDropdownOpen1] = useState(false);
  const [isDropdownOpen2, setIsDropdownOpen2] = useState(false);
  const [isDropdownOpen3, setIsDropdownOpen3] = useState(false);
  const [isDropdownOpen4, setIsDropdownOpen4] = useState(false);
  const [isDropdownOpen5, setIsDropdownOpen5] = useState(false);

  const [activeSide, setActiveSide] = useState(0);

  const handleMouseEnter1 = () => {
    setIsDropdownOpen1(true);
  };
  const handleMouseLeave1 = () => {
    setIsDropdownOpen1(false);
  };

  const handleMouseEnter2 = () => {
    setIsDropdownOpen2(true);
  };
  const handleMouseLeave2 = () => {
    setIsDropdownOpen2(false);
  };

  const handleMouseEnter3 = () => {
    setIsDropdownOpen3(true);
  };
  const handleMouseLeave3 = () => {
    setIsDropdownOpen3(false);
  };

  const handleMouseEnter4 = () => {
    setIsDropdownOpen4(true);
  };
  const handleMouseLeave4 = () => {
    setIsDropdownOpen4(false);
  };

  const handleMouseEnter5 = () => {
    setIsDropdownOpen5(true);
  };
  const handleMouseLeave5 = () => {
    setIsDropdownOpen5(false);
  };

  return (
    <DropWrap>
      <DropStyle
        isOpen={isDropdownOpen1}
        onMouseEnter={handleMouseEnter1}
        onMouseLeave={handleMouseLeave1}
      >
        <Link to="/product/list?type=위스키">
          <h1>WHISKEY</h1>
        </Link>

        <div className="dropdown-content">
          <Link to="/product/list?type=위스키">ALL</Link>
          <Link to="/product/list?type=위스키&subtype=싱글몰트">싱글몰트</Link>
          <Link to="/product/list?type=위스키&subtype=블렌디드">블렌디드</Link>
          <Link to="/product/list?type=위스키&subtype=버번">버번</Link>
        </div>
      </DropStyle>
      <DropStyle
        isOpen={isDropdownOpen2}
        onMouseEnter={handleMouseEnter2}
        onMouseLeave={handleMouseLeave2}
      >
        <Link to="/product/list?type=와인">
          <h1>WINE</h1>
        </Link>
        <div className="dropdown-content">
          <Link to="/product/list?type=와인">ALL</Link>
          <Link to="/product/list?type=와인&subtype=레드와인">레드 와인</Link>
          <Link to="/product/list?type=와인&subtype=화이트와인">
            화이트 와인
          </Link>
          <Link to="/product/list?type=와인&subtype=스파클링와인">
            스파클링 와인
          </Link>
          <Link to="/product/list?type=와인&subtype=로제와인">로제 와인</Link>
        </div>
      </DropStyle>
      <DropStyle
        isOpen={isDropdownOpen3}
        onMouseEnter={handleMouseEnter3}
        onMouseLeave={handleMouseLeave3}
      >
        <Link to="/product/list?type=리큐르">
          <h1>LIQUEUR</h1>
        </Link>
      </DropStyle>

      <DropStyle
        isOpen={isDropdownOpen5}
        onMouseEnter={handleMouseEnter5}
        onMouseLeave={handleMouseLeave5}
      >
        <Link to="/product/list?type=브랜디">
          <h1>BRANDY</h1>
        </Link>
        <div className="dropdown-content">
          <Link to="/product/list?type=브랜디">ALL</Link>
          <Link to="/product/list?type=브랜디&subtype=꼬냑">꼬냑</Link>
          <Link to="/product/list?type=브랜디&subtype=깔바도스">깔바도스</Link>
          <Link to="/product/list?type=브랜디&subtype=아르마냑">아르마냑</Link>
        </div>
      </DropStyle>
    </DropWrap>
  );
};

export default DropNav;
