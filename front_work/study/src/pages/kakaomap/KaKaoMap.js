import React, { useEffect, useMemo, useRef, useState } from "react";
import styled from "styled-components";
import TextField from '@mui/material/TextField';
import { Button } from "@mui/material";

const MapContainer = styled.div`
    width: 700px;
    height: 400px;
`;

const { kakao } = window;

//불러오는 부모페이지에서 props로 location={pageDetail}전달
export const KakaoMap = ({ initlocation }) => {
    const inputRefx = useRef(35);
    const inputRefy = useRef(127);
    const inputRefKeyWord = useRef('');

    initlocation = initlocation || { location_x: 35, location_y: 127 }; //초기값 설정
    const [location, setLocation] = useState(initlocation); //초기값 설정

    const searchMap = (map,keyword) => {
        var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
        var ps = new kakao.maps.services.Places();
    
        // 키워드로 장소를 검색합니다
        ps.keywordSearch(keyword, placesSearchCB);
    
        // 키워드 검색 완료 시 호출되는 콜백함수 입니다
        function placesSearchCB(data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {
    
                // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                // LatLngBounds 객체에 좌표를 추가합니다
                var bounds = new kakao.maps.LatLngBounds();
    
                for (var i = 0; i < data.length; i++) {
                    displayMarker(data[i]);
                    bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
                }
    
                // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
                map.setBounds(bounds);
            }
        }
    
        // 지도에 마커를 표시하는 함수입니다
        function displayMarker(place) {
    
            // 마커를 생성하고 지도에 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: new kakao.maps.LatLng(place.y, place.x)
            });
    
            // 마커에 클릭이벤트를 등록합니다
            kakao.maps.event.addListener(marker, 'click', function () {
                // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
                infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
                infowindow.open(map, marker);
            });
        }
    }
    
    const drawMap = (keyword) => {
        var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
        var options = {
            center: new kakao.maps.LatLng(
                location.location_x,
                location.location_y
            ), //지도의 중심좌표
            level: 3,
        };
        var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        var markerPosition = new kakao.maps.LatLng(
            location.location_x,
            location.location_y
        ); //해당 위치 마커 표시
        var marker = new kakao.maps.Marker({
            position: markerPosition,
        });
        marker.setMap(map);
    
        if(keyword === undefined || keyword === '') return;
        else searchMap(map,keyword);
    }

    useEffect(drawMap, [location]);

    const showPosition = () => {
        setLocation({ location_x: inputRefx.current.value, location_y: inputRefy.current.value })
    }
    
    const showNowPosition = () => {
        navigator.geolocation.getCurrentPosition((position) => {
            setLocation({ location_x: position.coords.latitude, location_y: position.coords.longitude })
        });
    }

    useMemo(() => {
        return showNowPosition();
    }, []);

    return (
        <div>
            <MapContainer id="map"></MapContainer>
            <div style={{ display: "flex", flexDirection: "column", padding: "1rem", gap:".5rem"}}>
                <TextField id="standard-basic" label="위도" variant="standard" inputRef={inputRefx} />
                <TextField id="standard-basic" label="경도" variant="standard" inputRef={inputRefy} />
                <Button variant="contained" onClick={showPosition}>
                    위치바꾸기
                </Button>
                <Button variant="contained" onClick={showNowPosition}>
                    현재위치로
                </Button>
                <TextField id="standard-basic" label="검색" variant="standard" inputRef={inputRefKeyWord} />
                <Button variant="contained" onClick={()=>{drawMap(inputRefKeyWord.current.value)}}>
                    검색
                </Button>
            </div>
        </div>
    );
};