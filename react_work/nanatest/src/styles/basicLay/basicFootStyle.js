import styled from "@emotion/styled";

export const Footerwrap = styled.div`
  .foot-head {
    height: 70px;
    border-top: 2px solid #d68000;
    border-bottom: 1px solid #c5c5c5;
  }
  .inwrap {
    position: relative;
    max-width: 1280px;
    height: 100%;
    /* height: 30px; */
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
  }
  .foot-company {
    display: flex;
    align-items: center;
    font-size: 15px;
    color: #949494;
  }

  .foot-company li {
    float: left;
    margin-right: 8px;
  }
  .foot-company li::after {
    content: "|";
    margin-left: 8px;
    color: #e9e9e9;
  }
  .foot-company li:last-child::after {
    content: "";
  }

  .foot-sns {
    display: flex;
    align-items: center;
    gap: 26px;
  }

  .foot-body {
    border-bottom: 1px solid #c5c5c5;
  }
  .inwrap-main {
    position: relative;
    max-width: 1280px;
    height: 100%;
    margin: 0 auto;
    display: flex;
  }
  .cs-center {
    position: relative;
    background-color: white;
    padding-right: 80px;
    padding-top: 50px;
    padding-bottom: 50px;
  }
  .cs-top {
    display: flex;
  }

  .bold-font {
    font-size: 30px;
    font-weight: 700;
    color: #868686;
  }
  .phone {
    font-size: 40px;
    font-weight: 700;
    margin-bottom: 23px;
    color: #868686;
  }
  .runtime {
    font-size: 17px;
    font-weight: 400;
    color: #949494;
    margin-bottom: 47px;
  }
  .cs-img {
    margin-left: 68px;
    width: 168px;
  }
  .cs-center a {
    display: inline-flex;
    height: 60px;
    /* width: 130px; */
    padding: 23px 54px;
    justify-content: center;
    align-items: center;
    /* gap: 10px; */
    flex-shrink: 0;
    border: 1px solid #e9e9e9;
    margin-right: 10px;
  }
  .cs-nav {
    background: #e9b25f;
    border: none;
    color: #fff;
  }
  .menu {
    width: 321px;
    padding-left: 80px;
    padding-top: 50px;
    /* margin-left: 80px; */
    border-left: 1px solid #d9d9d9;
    border-right: 1px solid #d9d9d9;
  }
  .r-font {
    color: #575757;
    font-size: 20px;
    font-weight: 500;
    padding-bottom: 20px;
  }
  .menu a {
    color: #868686;
    font-size: 15px;
    font-weight: 500;
  }
  .menu li {
    padding-bottom: 20px;
  }
  .return {
    color: #868686;
    font-size: 15px;
    font-weight: 500;
    padding-left: 80px;
    padding-top: 50px;
  }
  .foot-info {
    padding: 40px 0;
  }
  .foot-info p {
    font-size: 12px;
  }
`;
