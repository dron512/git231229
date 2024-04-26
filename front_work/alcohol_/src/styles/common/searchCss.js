import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const ProSearchForm = styled.div`
  .search-wrap {
    position: relative;
    display: flex;
    width: 100%;
    height: 50px;
    border: 1px solid ${Common.color.f900};
    border-radius: 10px;
    align-items: center;
    margin-bottom: 80px;
    .line {
      width: 1px;
      height: 100%;
      background: ${Common.color.f900};
      /* margin-right: 20px; */
    }
    select {
      border: none;
      width: 160px;
      padding: 8px 24px 8px 8px; /* 오른쪽에 내림 버튼을 위한 공간 추가 */
      -webkit-appearance: none;
      -moz-appearance: none;
      background-image: url("./images/down.svg");
      background-repeat: no-repeat;
      background-position: right 8px center; /* 내림 버튼 아이콘을 오른쪽에 위치 */
      cursor: pointer;
      font-size: 16px;
    }
  }
  .search-info {
    position: relative;
    display: flex;
    width: 85%;
    input {
      border: none;
      width: 92%;
      font-size: 16px;
      margin-left: 30px;
    }
  }

  .search-bt {
    /* position: absolute; */
    position: relative;
    /* top: -5px;
      left: 15px; */
    background-repeat: no-repeat;
    cursor: pointer;
    border: none;
    background-color: transparent;
    background-position: center;

    img {
      width: 25px;
      height: auto;
    }
  }
`;
