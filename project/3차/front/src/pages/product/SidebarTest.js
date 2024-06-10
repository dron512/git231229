import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";

const SidebarTest = type => {
  //
  const host = type.type;
  console.log("사이드바 호출 :", host);

  const WhiskeyColumn = ["WHISKEY", "싱글몰트", "블렌디드", "버번"];
  const WineColumn = [
    "Wine",
    "레드와인",
    "화이트와인",
    "스파클링 와인",
    "로제 와인",
  ];
  const LiqueurColumn = ["Liqueur"];
  const BrandyColumn = ["BRANDY", "꼬냑", "깔바도스", "아르마냑"];

  const naviage = useNavigate();
  const [status, setStatus] = useState([]);
  const handleClickAll = host => {
    if (host === "위스키") {
      console.log("host : ", host);
      naviage("/product/list?type=위스키");
    }
  };
  const handleClickSelectOne = host => {
    console.log("host : ", host);
    if (host === "위스키") {
      naviage("/product/list?type=위스키&subtype=싱글몰트");
    }
  };
  const handleClickSelectTwo = host => {
    console.log("host : ", host);
    if (host === "위스키") {
      naviage("/product/list?type=위스키&subtype=브랜디드");
    }
  };
  const handleClickSelectThree = host => {
    console.log("host : ", host);
    if (host === "위스키") {
      naviage("/product/list?type=위스키&subtype=버번");
    }
  };

  useEffect(() => {
    let resultColumn;
    if (host === "위스키") {
      console.log("위스키입니다.");
      resultColumn = WhiskeyColumn;
    } else if (host === "와인") {
      console.log("와인입니다.");
      resultColumn = WineColumn;
    } else if (host === "브랜디") {
      console.log("브랜디");
      resultColumn = BrandyColumn;
    } else if (host === "리큐르") {
      console.log("리큐르");
      resultColumn = LiqueurColumn;
    } else {
      console.log("No match");
    }
    console.log("result", resultColumn);
    setStatus(resultColumn);
  }, [host]);

  return (
    <div>
      <button onClick={() => handleClickAll(host)}>{status?.[0]}</button>
      <button onClick={() => handleClickSelectOne(host)}>{status?.[1]}</button>
      <button onClick={() => handleClickSelectTwo(host)}>{status?.[2]}</button>
      <button onClick={() => handleClickSelectThree(host)}>
        {status?.[3]}
      </button>
      {/* <button onClick={() => handleClickSelectThree(host)}>{status?.[4]}</button> */}
    </div>
  );
};

export default SidebarTest;
