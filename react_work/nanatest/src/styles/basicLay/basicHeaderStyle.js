import styled from "@emotion/styled";

export const HeaderNav = styled.div`
  .inwrap {
    position: relative;
    max-width: 1280px;
    margin: 0 auto;
  }
  .heder-inwrap {
    position: relative;
    display: flex;
    width: 90%;
    height: 150px;
    margin: 0 auto;

    align-items: center;
    justify-content: space-between;
  }
  .header-top-left {
    position: relative;
    height: 50px;
    display: flex;
    align-items: center; /* 세로정렬 */
    justify-content: space-between; /* 여백을 중앙으로 */
  }
  .logo {
    width: 300px;
  }

  /* 상품검색 */

  .header-search {
    position: relative;
    width: 350px;
    height: 50px;
    display: flex;
    align-items: center;
    padding-right: 10px;
    padding-left: 23px;
    border-radius: 25px;
    border: 1px solid #ffe2b6;
    margin-left: 20px;
  }
  .search-form {
    position: relative;
    width: 100%;
    display: flex;
    /* justify-content: space-between; */
    color: #ffe2b6;
  }
  .search-form input::placeholder {
    color: #ffe2b6;
  }
  .search-word {
    position: relative;
    width: 100%;
    border: none;
    font-size: 1.6rem; /* 1.6*(html폰트사이즈 ) */
    font-weight: 700;
    color: #ffe2b6;
  }
  .search-bt {
    position: relative;
    width: 45px;
    height: 45px;
    border: none;
    background-color: transparent;
    background-image: url("../assets/images/btn_search.svg");
    background-repeat: no-repeat;
    background-position: center;
    font-size: 0;
    cursor: pointer;
  }

  .header-top-right {
    position: relative;
    width: 330px;
    display: flex;
    justify-content: space-evenly;
    height: 50px;
    align-items: center;
  }

  .member-menu {
    position: relative;
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    button {
      border: none;
      background: transparent;
      font-size: 1.5rem;
      font-weight: 500;
      color: #868686;
      cursor: pointer;
    }
  }
  .member-menu a {
    position: relative;
    font-size: 1.5rem;
    font-weight: 500;
    color: #868686;
    cursor: pointer;
  }
  .member-menu li a {
    position: relative;
    display: flex;
    align-items: center;
    font-size: 1.5rem;
    font-weight: 500;
    cursor: pointer;
  }

  .head-menu {
    position: relative;
    /* display: flex; */
    justify-content: space-between;
    padding: 17px;
    /* border: 1px solid #ffe2b6; */
    border-top: 1px solid #ffe2b6;
    border-bottom: 1px solid #ffe2b6;
    align-items: center;
  }
  .head-drop {
    position: relative;
    display: flex;
    justify-content: space-between;
    font-size: 20px;
    cursor: pointer;
  }
`;
