import { useEffect, useState } from "react";
import { Circle, Map, MapMarker, Polyline } from "react-kakao-maps-sdk";
import axios from "axios";

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

const marketInfo = async () => {
  var infos = [
    {
      id: 0,
      marketname: "",
      address: "",
      delivery: "",
      opentime: "",
      closetime: "",
      phonenumber: "",
    },
  ];

  infos = await axios.get("http://localhost:8080/map/address");

  return infos;
};

const Info = async (marker, index) => {
  const result = await marketInfo();
  for (let i = 0; i < result.data.length; i++) {
    if (index - (result.data.length - 1) === result.data[i].id) {
      return (document.getElementById("test").innerHTML =
        "이름 = " +
        result.data[i].marketname +
        " 주소 = " +
        result.data[i].address);
    }
  }
};

const Maps = () => {
  const [loading, setLoading] = useState(true); // 로딩 중 여부 상태

  const [addrs, setAddrs] = useState([
    {
      position: {
        lat: 0,
        lng: 0,
      },
    },
  ]);

  // 현재 좌표가져오기
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

  useEffect(() => {
    mygeo();

    const getMarkerInfo = async () => {
      const result = await marketInfo();
      if (result.data != null) {
        markers.splice(0, 1);
        // addrs.splice(0, 1);
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
    getMarkerInfo();
  }, [markers]);

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <div className="map_wrap">
        <div>
          <Map
            center={point}
            style={{
              width: "100%",
              height: "500px",
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
                size: [24, 35],
              }}
            ></MapMarker>
            {markers.map((marker, index) => {
              if (markers !== null) {
                return (
                  <MapMarker
                    key={index}
                    position={marker.position}
                    clickable={true}
                    onClick={() => Info(marker, index)}
                  />
                );
              }
            })}
          </Map>
          <div className="custom_mygps">
            <button
              onClick={() => {
                mygeo();
              }}
            >
              내위치
            </button>
          </div>
        </div>
      </div>
      <div id="aaaa"></div>
      <div id="test">{Info}</div>
    </>
  );
};

export default Maps;
