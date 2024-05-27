import React from "react";
import { useRecoilState } from "recoil";
import { P16 } from "../../styles/basic";
import {
  PlaceLi,
  PlaceUl,
  PlaceWrap,
  Placehead,
} from "../../styles/detail/mapModalPlaceCss";
import { placeState } from "../../atom/placeState";
import { stockState } from "../../atom/stockState";

const MapPlaceInfo = ({ place, onClose }) => {
  const [selectedPlaceName, setSelectedPlaceName] = useRecoilState(placeState);
  const [selectedStockNum, setSelectedStockNum] = useRecoilState(stockState);
  const handleClick = () => {
    setSelectedPlaceName(place.marketname);
    setSelectedStockNum(place.stocknumber);
    onClose();
  };
  console.log("ffff ff :", place);
  return (
    <div>
      <PlaceWrap
        onClick={handleClick}
        isActive={selectedPlaceName === place.marketname}
      >
        <Placehead>
          {place.marketname && <P16>{place.marketname}</P16>}
        </Placehead>

        <PlaceUl>
          <PlaceLi>
            <img
              src={process.env.PUBLIC_URL + "/images/address.svg"}
              alt="Address Icon"
            />

            <P16>{place?.address}</P16>
          </PlaceLi>
          <PlaceLi>
            <img
              src={process.env.PUBLIC_URL + "/images/call.svg"}
              alt="Call Icon"
            />
            <P16>{place?.phonenumber}</P16>
          </PlaceLi>
          <PlaceLi>
            <img
              src={process.env.PUBLIC_URL + "/images/time.svg"}
              alt="Time Icon"
            />
            <P16>{place?.opentime}</P16>
          </PlaceLi>
        </PlaceUl>
      </PlaceWrap>
    </div>
  );
};

export default MapPlaceInfo;
