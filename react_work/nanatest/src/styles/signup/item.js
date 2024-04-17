import styled from "styled-components";

export const ItemMain = styled.div`
  width: 1220px;
  margin: 0 auto;

`;

export const ItemWrap = styled.div`
  min-height: 680px;
  display: flex;

  gap: 20px;
  margin-top: 70px;
  .itemimg {
    img {
      width: 500px;
      height: 500px;
    }
  }
  .itemtext {
    font-size: 30px;
  }
  .itemspan {
    font-size: 25px;
    color: #e9b25f;

    span {
      font-size: 25px;
      font-weight: 800;
    }
  }
  .itemFree {
    color: #868686;
    text-align: right;
    font-family: Roboto;
    font-size: 30px;
    font-style: normal;
    font-weight: 400;
    margin-bottom: 20px;
    line-height: 35px;
  }
  .itemOnePrice {
    color: #868686;
    text-align: right;
    font-family: Roboto;
    font-size: 30px;
    font-style: normal;
    font-weight: 400;
    line-height: 35px;
    b {
      color: #868686;
      font-family: Roboto;
      font-size: 60px;
      font-style: normal;
      font-weight: 600;
      line-height: 35px; /* 58.333% */
      letter-spacing: 0.5px;
    }
    span {
      color: #868686;
      font-family: Roboto;
      font-size: 40px;
      font-style: normal;
      font-weight: 500;
      line-height: 35px; /* 87.5% */
      letter-spacing: 0.5px;
    }
  }
`;
export const ItemHeart = styled.div`
  cursor: pointer;
`;
export const ItemHover = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

export const ItemPrice = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
`;
export const ItemInfo = styled.div`
  display: flex;
  font-size: 3rem;
  height: 80px;
  justify-content: center;
  align-items: center;
  gap: 250px;
  cursor: pointer;
  border-top: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  background-color: #f9f9f9;
  div {
    &:hover {
      border-bottom: 3px solid #e9b25f;
      color: #e9b25f;
    }
  }
`;
export const StyledDiv = styled.div`
  display: flex;
  width: 1220px;
  margin-top: 150px;
  color: #868686;
  font-family: "Roboto";
  font-size: 30px;
  font-style: normal;
  font-weight: 400;
  line-height: 35px;
  gap: 150px;
  border-bottom: 1px solid #868686;
  padding-bottom: 50px;
  margin: 0 auto;

  .reviewtext {
    width: 750px;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    .reviewtotal {
      font-size: 20px;
      span {
        font-size: 25px;
        font-weight: 800;
      }
    }
  }
`;
export const StyledButton = styled.button`
  background: transparent;
  border: none;
  cursor: pointer;
  font-size: 30px;
  margin-right: 15px;
  color: #d9d9d9;

  &:hover {
    color: #e9b25f; /* Change the color for hover effect */
  }
`;
