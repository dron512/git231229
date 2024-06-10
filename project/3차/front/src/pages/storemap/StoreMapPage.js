import React, { useEffect, useState } from "react";
import { KakaoMapContext, Map, MapMarker } from "react-kakao-maps-sdk";
import StoreMapInfo from "../../components/storeMap/StoreMapInfo";
import { PB16 } from "../../styles/basic";
import {
  ItemContent,
  ItemWrap,
  MarginB20,
} from "../../styles/common/reviewProductCss";
import { MarketWrap, MyLocation, StoreWrap } from "../../styles/StoreMapCss";
import BasicLayout from "../../layout/BasicLayout";
import { getMarketAddress } from "../../api/marketMapApi";
import axios from "axios";

const geocoder = new window.kakao.maps.services.Geocoder();

// 주소 좌표 변환
const getAddr = addr => {
  return new Promise((resolve, reject) => {
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

var infos = [
  {
    marketcode: 0,
    marketname: "",
    address: "",
    delivery: "",
    opentime: "",
    closetime: "",
    phonenumber: "",
  },
];

// 마켓 정보 가져 옴
const marketInfo = async () => {
  infos = await axios.get("http://threeback.hellomh.site/market/address");

  return infos;
};

const StoreMapPage = () => {
  const [marketData, setMarketData] = useState([]);

  const [loading, setLoading] = useState(true); // 로딩 중 여부 상태

  const [addrs, setAddrs] = useState([
    {
      position: {
        lat: 0,
        lng: 0,
      },
    },
  ]);

  // 처음 내 위치
  const mygeo = () => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function (position) {
        setPoint({
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        });
        setmarkerP({
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        });
      });
    }
  };

  const [point, setPoint] = useState({
    lat: 0,
    lng: 0,
  });

  const [markerP, setmarkerP] = useState({
    lat: 0,
    lng: 0,
  });

  const [markers, setMarkers] = useState(() => {
    return [{ position: { lat: 0, lng: 0 } }];
  });

  // 마켓 마커 찍어줌
  const getMarkerInfo = async () => {
    const result = await marketInfo();
    if (result.data != null) {
      markers.splice(0, 1);
      for (let i = 0; i < result.data.length; i++) {
        await getAddr(result.data[i].address).then(coords => {
          addrs.push({
            position: { lat: coords.lat, lng: coords.lng },
          });
        });
      }
      setMarkers(addrs);

      setLoading(false); // 로딩 상태 업데이트
      return result;
    }
  };

  useEffect(() => {
    mygeo();

    getMarkerInfo();

    // 현재 위치 주소 보여줌
    geocoder.coord2Address(markerP.lng, markerP.lat, function (result, status) {
      if (status === window.kakao.maps.services.Status.OK) {
        document.getElementById("myaddress").innerText =
          result[0].address.address_name;
      }
    });

    // 마켓 목록 보여줌
    getMarketAddress({
      successFn: data => {
        setMarketData(data);
      },
      failFn: data => {
        alert("마켓정보 불러오기 실패");
      },
      errorFn: data => {
        alert("서버 불안정");
      },
    });

  }, [markers]);

  // 맵 로딩시 나옴
  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <BasicLayout>
        <ItemWrap>
          <ItemContent>
            <StoreWrap>
              <div>
                <MyLocation>
                  <PB16 style={{ width: "50px" }}>내 위치</PB16>
                  <PB16 id="myaddress"></PB16>
                </MyLocation>
                <MarginB20 />
                <MarketWrap>
                  {marketData.map((market, index) => (
                    <StoreMapInfo key={index} market={market} />
                  ))}
                </MarketWrap>
              </div>

              <Map
                center={point}
                style={{
                  width: "550px",
                  height: "550px",
                }}
                level={4}
                onDragEnd={map => {
                  const latlng = map.getCenter();

                  setPoint({
                    lat: latlng.getLat(),
                    lng: latlng.getLng(),
                  });
                }}
              >
                <MapMarker
                  position={markerP}
                  image={{
                    src: "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png",
                    size: new window.kakao.maps.Size(24, 35),
                  }}
                ></MapMarker>
                {markers.map((marker, index) => {
                  if (markers !== null) {
                    return (
                      <MapMarker
                        key={index}
                        position={marker.position}
                        clickable={true}
                      >
                      </MapMarker>
                    );
                  }
                })}
              </Map>
            </StoreWrap>
          </ItemContent>
        </ItemWrap>
      </BasicLayout>
    </div>
  );
};

export default StoreMapPage;
