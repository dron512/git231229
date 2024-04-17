import styled from "styled-components";

// ReviewPageCom.js
export const ReviewWrap = styled.div`
  width: 1440px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  hr {
    color: #868686;
  }
`;
export const ReviewBody = styled.div`
  width: 1150px;
`;
export const ReviewTitle = styled.div`
  width: 600px;
  padding-top: 50px;
  padding-bottom: 50px;
  span {
    color: #e9b25f;
    font-size: 70px;
    font-weight: 500;
    margin-bottom: 10px;
  }
`;
export const ReviewHeader = styled.div`
  display: flex;
  justify-content: space-between;
  .orderListBt {
    width: 420px;
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 25px;
    span {
      font-size: 20px;
      color: #868686;
    }
  }
`;
export const ReviewList = styled.div`
  margin-top: 30px;
  margin-bottom: 30px;
  .listHeader {
    display: flex;
    justify-content: space-between;
  }
  .nameScore {
    width: 310px;
    font-size: 30px;
    display: flex;
    justify-content: space-between;
    text-align: center;
    line-height: 50px;
    p {
      color: #868686;
    }
  }
  .productName {
    display: flex;
    justify-content: space-between;
    line-height: 50px;
    gap: 15px;
    p {
      width: 400px;
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 1;
      overflow: hidden;
      text-overflow: ellipsis;
      font-size: 20px;
      color: #868686;
      text-align: left;
    }
    i {
      font-size: 30px;
      font-style: normal;
      color: #868686;
    }
  }
  .productReview {
    display: flex;
    justify-content: space-between;
    gap: 50px;
    margin-top: 15px;
    p {
      text-align: justify;
      font-size: 25px;
      color: #868686;
    }
    .reviewRight {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
    }
    .buttonDiv {
      display: flex;
      justify-content: end;
      button {
        height: 50px;
        width: 100px;
      }
    }
  }
`;

export const ReviewImgSection = styled.div`
  width: 230px;
  height: 230px;
`;

export const ReviewFooter = styled.div`
  margin-top: 40px;
  margin-bottom: 40px;
  width: 1150px;
  height: 80px;
  justify-content: center;
  align-items: center;
  display: flex;
`;

// ReviewAddCom.js

export const ReviewAddWrap = styled.div`
  width: 1440px;
  display: flex;
  align-items: center;
  justify-content: center;
  i {
    font-size: 12px;
    font-style: normal;
    color: #42b0ff;
  }
  .productInfo {
    display: flex;
    justify-content: space-between;
    gap: 40px;
    img {
      width: 170px;
      height: 170px;
    }
  }
  .productInfoText {
    width: 930px;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    p {
      width: 930px;
      font-size: 20px;
      line-height: 30px;
    }
  }
  .ant-input-data-count {
    bottom: -40px;
  }
  .antdUploadDiv {
    margin-top: 60px;
    display: "flex";
  }
  .buttonDiv {
    width: 140px;
    height: 140px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    font-size: 20px;
  }
`;

export const ReviewAddTitle = styled.div`
  width: 1150px;
  padding-top: 50px;
  padding-bottom: 50px;
  span {
    color: #e9b25f;
    font-size: 70px;
    font-weight: 500;
    margin-bottom: 10px;
  }
  p {
    color: #c5c5c5;
    font-size: 30px;
  }
`;

export const RateAddBox = styled.div`
  margin-top: 30px;
  margin-bottom: 30px;
  width: 1150px;
  height: 100px;
  border: 1px solid #e9b25f;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 35px 40px;
  p {
    font-size: 30px;
    font-weight: 600;
    color: #e9b25f;
  }
  // Rate .. 색이 바뀐다
  /* span {
    color: #E9B25F;
  } */
`;
