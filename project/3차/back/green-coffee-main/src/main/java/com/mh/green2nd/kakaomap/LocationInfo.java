package com.mh.green2nd.kakaomap;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationInfo {

    @JsonProperty("기준일")
    private String baseDate;

    @JsonProperty("지번주소")
    private String address;

    @JsonProperty("행정동")
    private String dong;
}
