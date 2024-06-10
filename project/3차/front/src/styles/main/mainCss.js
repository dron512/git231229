import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const MainWrap = styled.div`
  position: relative;

  /* width: 100%; */

  .main-header {
    position: absolute;
    /* display: flex; */
    min-height: 300px;
    width: 100%;
    text-align: center;
    font-size: 50px;
    font-weight: 600;
    padding: 80px 20px;
  }
  .search-wrap {
    position: relative;
    display: flex;
    width: 592px;
    margin: 0 auto;
    /* height: 52px; */
    border: 1px solid ${Common.color.f900};
    border-radius: 5px;
    justify-content: center;
    align-items: center;
  }
  .search-word {
    position: relative;
    width: 500px;
    height: 52px;
    right: 20px;
    border: none;
    /* border: 1px solid ${Common.color.f900}; */
    border-radius: 5px;
    /* font-size: 30px; */
    font-size: 20px;
    /* margin-right: 20px; */
  }
  .search-word::placeholder {
  }
  .search-bt {
    /* position: absolute; */
    position: relative;
    top: -5px;
    left: 15px;
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
