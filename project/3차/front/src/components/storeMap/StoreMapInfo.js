import React from "react";
import { LocationBox, MyLocation } from "../../styles/StoreMapCss";
import { P16, PB16 } from "../../styles/basic";
import { MarginB10, MarginB20 } from "../../styles/common/reviewProductCss";
import styled from "@emotion/styled/macro";

const initState = [
  {
    marketcode: 1,
    marketname: "포도대구동성로점",
    address: "대구광역시 중구 공평동 57-3번지 101호",
    phonenumber: "01011111111",
    delivery: "PickUp",
    opentime: "10:00:00",
    closetime: "22:00:00",
  },
];
const StoreMapInfo = ({ market }) => {
  return (
    <>
      <LocationBox>
        <div className="branch">
          <PB16>{market.marketname}</PB16>
          <PB16>|</PB16>
          <PB16>{market.Branch}</PB16>
        </div>
        <MarginB10 />
        <div>
          <P16>{market.address} </P16>
          <P16>{market.phonenumber}</P16>
        </div>
      </LocationBox>
    </>
  );
};

export default StoreMapInfo;
