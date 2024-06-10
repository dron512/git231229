package com.mh.green2nd.custom;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomReqDto {
    private Long menuId;
    private String myname;

    private int size;
    private int ice;
    private int shot;
    private int cream;

}
