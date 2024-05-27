import styled from "@emotion/styled/macro";
import React from "react";
import { Common } from "../CommonCss";

export const DropdownWrapper = styled.div`
  position: relative;
  display: inline-block;
  img {
    width: 27px;
  }
`;

export const DropdownContent = styled.div`
  /* display: ${open ? "block" : "none"}; */
  display: ${props => (props.isOpen ? "block" : "none")};
  position: absolute;
  background-color: ${Common.color.p000};
  min-width: 215px;

  right: -100%;
  top: calc(100% + 19px);
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 9999;
  border-radius: 10px;
  font-size: 10px;
  &::before {
    content: "";
    position: absolute;
    top: -2em; /* 드롭다운 위로 1em만큼 이동 */
    left: -1em;
    right: -5em;
    bottom: -1em; /* 드롭다운 아래로 1em만큼 이동 */
    background-color: transparent;
    /* background-color: rebeccapurple; */
    z-index: -1;
    cursor: pointer;
  }
  .profile {
    padding: 30px 30px 20px 30px;
    p {
      margin-bottom: 5px;
    }
  }
  .line {
    width: 80%;
    height: 2px;
    justify-content: center;
    margin: 0 auto;
    background-color: ${Common.color.p800};
  }
`;

export const ItemBack = styled.div`
  padding: 10px 0;
  /* border-top: 1px solid #2e2e2e; */
`;

export const DropdownItem = styled.a`
  color: ${Common.color.p900}; /* 수정: 색상 코드 앞에 # 추가 */
  padding: 12px 30px;

  text-decoration: none;
  display: block;
  cursor: pointer;
  &:hover {
    background-color: #2e2e2e;
    color: #e1e1e1;
  }
`;
