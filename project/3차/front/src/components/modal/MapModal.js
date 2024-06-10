import React, { useEffect, useState } from "react";
import { Map, MapMarker } from "react-kakao-maps-sdk";
import { dummyData } from "../../mock/PlaceData";
import { PB20 } from "../../styles/basic";
import {
  CloseBt,
  MapModalWrap,
  MapWrap,
  Place,
  RvModalStyle,
} from "../../styles/detail/mapModalWrapCss";
import MapPlaceInfo from "./MapPlaceInfo";
import { useQuery } from "react-query";
import { getMarketPath } from "../../api/productApi";
// const { TextArea } = Input;

export const MapModal = ({ onClose, code }) => {
  console.log("code입니다. : ", code);

  const { data: marketData } = useQuery({
    queryFn: () => getMarketPath({ code }),
  });
  // const marketData = data;
  console.log("받은 데이터 : ", marketData);

  // const onChange = e => {
  //   console.log("Change:", e.target.value);
  // };
  const [selectedIndex, setSelectedIndex] = useState(null);

  const transMapAddress = marketData => {
    console.log("load : ", marketData);
    return marketData?.map(item => item.address);
  };
  const mapAddress = transMapAddress(marketData);
  console.log("주소 슛 :", mapAddress);

  const handlePlaceClick = index => {
    setSelectedIndex(index);
  };

  // @AREA 주소 변환

  // 주소를 좌표로 바꾸는거
  const getAddr = addr => {
    return new Promise((resolve, reject) => {
      const geocoder = new window.kakao.maps.services.Geocoder();

      geocoder.addressSearch(`${addr}`, function (result, status) {
        if (status === window.kakao.maps.services.Status.OK) {
          const coords = {
            lat: result[0].y,
            lng: result[0].x,
          };
          resolve(coords);
        } else reject(status);
      });
    });
  };
  const [resultPath, setResultPath] = useState([]);
  useEffect(() => {
    if (mapAddress && !resultPath.length) {
      // resultPath가 비어있을 때만 실행
      Promise.all(mapAddress.map(addr => getAddr(addr)))
        .then(coordsArray => {
          console.log("변환된 좌표:", coordsArray);
          setResultPath(coordsArray);
        })
        .catch(error => {
          console.error("주소 변환 중 오류 발생:", error);
        });
    }
  }, [mapAddress, resultPath]);

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
            {resultPath?.map((item, index) => (
              <MapMarker
                key={index}
                position={{ lat: `${item.lat}`, lng: `${item.lng}` }}
              ></MapMarker>
            ))}

            <MapMarker // 마커를 생성합니다
              position={{
                // 마커가 표시될 위치입니다
                lat: 35.8683476,
                lng: 128.5940482,
              }}
            />

            <MapMarker
              position={{ lat: 35.86956707277221, lng: 128.59432657224625 }}
            ></MapMarker>
            <MapMarker
              position={{ lat: 35.86933415574914, lng: 128.59557688236237 }}
            ></MapMarker>
          </Map>
          <Place>
            <PB20 style={{fontSize:'1.5rem'}}>판매처 선택</PB20>
            {marketData?.map((place, index) => (
              <MapPlaceInfo
                key={index}
                place={place}
                onClose={onClose}
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
