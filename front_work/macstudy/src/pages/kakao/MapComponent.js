import React, { useEffect, useMemo, useState } from "react";

const { kakao } = window;

//불러오는 부모페이지에서 props로 location={pageDetail}전달
export const MapComponent = () => {
    let initlocation = { location_x: 35, location_y: 127 }; //초기값 설정
    const [location, setLocation] = useState(() => initlocation); //초기값 설정

    const drawMap = () => {
        var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
        var options = {
            center: new kakao.maps.LatLng(
                location.location_x,
                location.location_y
            ), //지도의 중심좌표
            level: 3,
        };

        // 마커 이미지의 이미지 주소입니다
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35);

        // 마커 이미지를 생성합니다    
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        var geoMarkerPosition = new kakao.maps.LatLng(
            location.location_x,
            location.location_y
        );
        var marker;

        // 지도에 표시할 원을 생성합니다
        var circle = new kakao.maps.Circle({
            center: new kakao.maps.LatLng(
                location.location_x,
                location.location_y
            ), // 원의 중심좌표
            radius: 2000, // 미터 단위의 원의 반지름입니다 
            strokeWeight: 5, // 선의 두께입니다 
            strokeColor: '#75B8FA', // 선의 색깔입니다
            strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
            strokeStyle: 'dashed', // 선의 스타일 입니다
        });

        var radius = circle.getRadius(); // 반지름
        const EARTH_RADIUS = 6371.0;

        // 마커를 표시할 위치와 title 객체 배열입니다 
        var positions = [
            {
                title: 'aa',
                latlng: new kakao.maps.LatLng(35.87114676506123, 128.59538148093827)
            },
            {
                title: 'bb',
                latlng: new kakao.maps.LatLng(35.86941595718792, 128.59271179394966)
            },
            {
                title: 'cc',
                latlng: new kakao.maps.LatLng(35.873761808268775, 128.59660754727423)
            },
            {
                title: 'dd',
                latlng: new kakao.maps.LatLng(35.8692273128927, 128.60417791107864)
            },
            {
                title: 'ee',
                latlng: new kakao.maps.LatLng(35.86836599497647, 128.60119346570875)
            },
            {
                title: 'ff',
                latlng: new kakao.maps.LatLng(35.87383708150048, 128.5956900842964)
            },
            {
                title: 'gg',
                latlng: new kakao.maps.LatLng(35.87333963414313, 128.59514865566558)
            },
            {
                title: 'hh',
                latlng: new kakao.maps.LatLng(35.872556730904954, 128.59506652797722)
            },
            {
                title: 'ii',
                latlng: new kakao.maps.LatLng(35.87284625086417, 128.59362192187334)
            },
            {
                title: 'jj',
                latlng: new kakao.maps.LatLng(35.87345103103126, 128.5935454607006)
            },
        ];

        // 각도를 라디안으로 변환하는 함수
        function calculateDistance(lat1, lon1, lat2, lon2) {
            // 위도와 경도를 라디안으로 변환
            const lat1Rad = lat1;
            const lon1Rad = lon1;
            const lat2Rad = lat2;
            const lon2Rad = lon2;
            // 위도와 경도의 차이 계산
            const dLat = lat2Rad - lat1Rad;
            const dLon = lon2Rad - lon1Rad;

            // Haversine 공식을 사용하여 거리 계산
            const a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLon / 2), 2);
            const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            const distance = EARTH_RADIUS * c;

            return distance;
        }

        var distances = [];
        function calculateDistancesFromCurrentLocation(currentLat, currentLon, locations) {
            for (let i = 0; i < positions.length; i++) {
                distances.push(calculateDistance(location.location_x, location.location_y, positions[i].latlng.Ma, positions[i].latlng.La));
            }
            console.log("distances = " + JSON.stringify(distances));
            return distances;
        }

        var distancess = [];

        function calculateDistancesAndShowMarkers() {
            distancess.push(calculateDistancesFromCurrentLocation(location.location_x, location.location_y, positions));

            // 가게들과 중심의 길이가 반경보다 짧으면 보이도록
            for (let i = 0; i < positions.length; i++) {
                if (distancess[i] < radius) {
                    console.log("반경보다 짧으면 마커를 지도에 표시");
                    // 마커를 생성합니다
                    marker = new kakao.maps.Marker({
                        map: map, // 마커를 표시할 지도
                        position: (
                            positions[i].latlng.Ma,
                            positions[i].latlng.La
                        ) // 마커를 표시할 위치
                    });
                } else {
                    console.log("만약 반경을 벗어나면 이전에 생성한 마커를 지도에서 제거");
                    // 만약 반경을 벗어나면 이전에 생성한 마커를 지도에서 제거합니다.
                }
            }
        }

        //     // calculateDistancesAndShowMarkers 함수 호출
        calculateDistancesAndShowMarkers();

        //     //해당 위치 마커 표시
        marker = new kakao.maps.Marker({
            position: geoMarkerPosition, // 마커를 표시할 위치
            image: markerImage // 마커 이미지 
        });

        //     // 지도에 마커 표시
        marker.setMap(map);

        //     // 지도에 원을 표시합니다 
        circle.setMap(map);

        //     // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
        var mapTypeControl = new kakao.maps.MapTypeControl();

        //     // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
        //     // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
        map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

        //     // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
        var zoomControl = new kakao.maps.ZoomControl();
        map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

    }

    const handleSuccess = (pos) => {
        const { latitude, longitude } = pos.coords
        console.log(latitude, longitude);
        setLocation({
            location_x: latitude,
            location_y: longitude,
        });
        drawMap();
    }

    useEffect(() => {
        const { geolocation } = navigator
        if (!geolocation) {
            return
        }
        geolocation.getCurrentPosition(handleSuccess)
    }, [])

    return (
        <div>
            <h1>위도 : {location.location_x}</h1>
            <h1>경도 : {location.location_y}</h1>
            <div id="map" style={{ width: "500px", height: "300px" }}></div>
            <button onClick={() => {
                navigator.geolocation.getCurrentPosition(handleSuccess);
                drawMap();
            }}>내위치 찾기</button>
        </div>
    );
}
export default MapComponent;