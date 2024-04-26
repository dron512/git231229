import React, { useEffect, useState } from "react";
import { P16 } from "../../styles/basic";
import { UlStyle } from "../detail/DetailInfo";
import ListLi from "../detail/ListLi";
import styled from "@emotion/styled/macro";
import { Common } from "../../styles/CommonCss";
import { useRecoilState } from "recoil";
import { placeState } from "../../recoil/atom/placeState";
import {
  PlaceLi,
  PlaceUl,
  PlaceWrap,
} from "../../styles/detail/mapModalPlaceCss";

const MapPlaceInfo = ({ place }) => {
  const [selectedPlaceName, setSelectedPlaceName] = useRecoilState(placeState);

  const handleClick = () => {
    setSelectedPlaceName(place.name);
  };
  return (
    <div>
      <PlaceWrap
        onClick={handleClick}
        isActive={selectedPlaceName === place.name}
      >
        {place.name && <P16>{place.name}</P16>}
        <PlaceUl>
          <PlaceLi>
            <img
              src={process.env.PUBLIC_URL + "/images/address.svg"}
              alt="Address Icon"
            />
            <P16>{place.address}</P16>
          </PlaceLi>
          <PlaceLi>
            <img
              src={process.env.PUBLIC_URL + "/images/call.svg"}
              alt="Call Icon"
            />
            <P16>{place.phoneNumber}</P16>
          </PlaceLi>
          <PlaceLi>
            <img
              src={process.env.PUBLIC_URL + "/images/time.svg"}
              alt="Time Icon"
            />
            <P16>{place.hours}</P16>
          </PlaceLi>
        </PlaceUl>
      </PlaceWrap>
    </div>
  );
};

export default MapPlaceInfo;
