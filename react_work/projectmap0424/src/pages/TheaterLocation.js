//TheaterLocation.js

import { useEffect, useState } from "react";
import { Map, MapMarker } from "react-kakao-maps-sdk";

const TheaterLocation = () => {
  const [point, setPoint] = useState({
    lat: 37.506320759000715,
    lng: 127.05368251210247,
  });
  const doMove = () => {
    const lat = 36.506320759000715; // 위도
    const lon = 126.05368251210247; //
    setPoint({ lat, lon });
  };
  useEffect(() => {}, []);

  return (
    <div>
      <Map
        center={point}
        style={{
          width: "600px",
          height: "500px",
          borderRadius: "20px",
        }}
      >
        //지도에 보여줄 위치 지정 (위도,경도)
        <MapMarker
          style={{ border: "tranparent" }}
          position={{ lat: 37.506320759000715, lng: 127.05368251210247 }}
        >
          //핀 찍힐 위치
          <div
            style={{
              color: "#9971ff",
              fontSize: "19px",
              fontWeight: "700",
              border: "4px solid #9971ff",
              borderRadius: "10px",
              padding: "2.5px",
            }}
          >
            🎬 small box 🎬
          </div>
        </MapMarker>
      </Map>
      <button onClick={doMove}>버튼</button>
    </div>
    //핀에 적힐 이름 (위치 이름)
  );
};

export default TheaterLocation;
