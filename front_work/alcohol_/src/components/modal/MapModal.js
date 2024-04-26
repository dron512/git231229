import styled from "@emotion/styled/macro";
import React, { useState } from "react";
import { Common } from "../../styles/CommonCss";
import { Button, Flex, Form, Input, Rate } from "antd";
import { BasicBtR } from "../../styles/basic/basicBt";
import { HeartOutlined } from "@ant-design/icons";
import { PB20 } from "../../styles/basic";
import { Map, MapMarker } from "react-kakao-maps-sdk";
import MapPlaceInfo from "./MapPlaceInfo";
import { dummyData } from "../../mock/PlaceData";
import {
  CloseBt,
  MapModalWrap,
  MapWrap,
  Place,
  RvModalStyle,
} from "../../styles/detail/mapModalWrapCss";
const { TextArea } = Input;

export const MapModal = ({ onClose }) => {
  const onChange = e => {
    console.log("Change:", e.target.value);
  };
  const [selectedIndex, setSelectedIndex] = useState(null);

  const handlePlaceClick = index => {
    setSelectedIndex(index);
  };

  return (
    <RvModalStyle>
      <MapModalWrap>
        <div style={{ display: "flex", justifyContent: "end" }}>
          <CloseBt onClick={onClose}>
            <img src={process.env.PUBLIC_URL + "/images/close2.svg"}></img>
          </CloseBt>
        </div>
        <div style={{ display: "flex" }}>
          <div>dd</div>
          <div>ddDD</div>
        </div>
        <MapWrap>
          <Map
            center={{ lat: 35.8683476, lng: 128.5940482 }}
            style={{ width: "500px", height: "100%" }}
          >
            <MapMarker // 마커를 생성합니다
              position={{
                // 마커가 표시될 위치입니다
                lat: 35.8683476,
                lng: 128.5940482,
              }}
              image={{
                src: "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png", // 마커이미지의 주소입니다
                size: {
                  width: 44,
                  height: 49,
                }, // 마커이미지의 크기입니다
                options: {
                  offset: {
                    x: 27,
                    y: 69,
                  }, // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
                },
              }}
            />
            <MapMarker
              position={{ lat: 35.86843379427353, lng: 128.59317740895912 }}
            ></MapMarker>
            <MapMarker
              position={{ lat: 35.86956707277221, lng: 128.59432657224625 }}
            ></MapMarker>
            <MapMarker
              position={{ lat: 35.86933415574914, lng: 128.59557688236237 }}
            ></MapMarker>
          </Map>
          <Place>
            <PB20>판매처 선택</PB20>
            {dummyData.map((place, index) => (
              <MapPlaceInfo
                key={index}
                place={place}
                onClick={() => handlePlaceClick(index)} // 인덱스를 클릭 핸들러에 전달합니다.
                isActive={selectedIndex === index} // 현재 인덱스가 선택된 인덱스와 일치하는지 확인하여 isActive props를 설정합니다.
              />
            ))}
          </Place>
        </MapWrap>
      </MapModalWrap>
    </RvModalStyle>
  );
};

export default MapModal;
