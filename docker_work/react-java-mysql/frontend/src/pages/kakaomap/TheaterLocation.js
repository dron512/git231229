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
    const lon = 127.05368251210247; // 
    setPoint({ lat, lon });
  };
  useEffect(() => { }, []);

  return (
    <div>
      <Map
        center={point}
        style={{ width: "500px", height: "360px" }}
      >
        <MapMarker position={{ lat: 33.55635, lng: 126.795841 }}>
          <div style={{ color: "#000" }}>Hello World!</div>
        </MapMarker>
      </Map>
      <button onClick={doMove}>버튼</button>
    </div>
    //핀에 적힐 이름 (위치 이름)
  );
};

export default TheaterLocation;
