import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const ItemWrap = styled.div`
  padding: 120px;
`;
export const ItemContent = styled.div`
  position: relative;
  width: 100%;
  display: flex;
  padding-bottom: 30px;
  margin: 0 auto;
  justify-content: space-between;
  img {
    width: 500px;
    height: 500px;
  }
  .information {
    width: 500px;
    height: 500px;
  }
  .starRev {
    padding: 10px 0 20px 0;
    display: flex;
    align-items: center;
    img {
      width: 19px;
      height: 15px;
    }
    a {
      margin-left: 10px;
      font-size: 13px;
      color: ${Common.color.p400};
      text-decoration: underline;
    }
  }
  .line {
    margin: 20px 0 20px 0;
    width: 100%;
    height: 1px;
    background-color: ${Common.color.p200};
    text-align: center;
  }
  .info {
    /* padding: 20px 0 20px 0; */
    display: flex;
    gap: 50px;
    font-size: 16px;
    color: ${Common.color.p600};

    li {
      padding: 10px 0 10px 0;
    }
  }
  .count {
    position: relative;
    display: flex;
    align-items: center;
    width: 100%;
    justify-content: space-between;
    margin-top: 16px;
    .product-name {
      width: 300px;
    }
    p {
      font-size: 16px;
      font-weight: bold;
    }
  }
  .pay-button {
    position: relative;
    display: flex;
    justify-content: space-between;
  }
`;

export const BigButton = styled.button`
  width: 240px;
  height: 49px;
  font-weight: bold;
  cursor: pointer;
  font-size: 2rem
`;
export const SButton = styled.button`
  width: 80px;
  height: 30px;
  font-size: 13px;
  color: ${Common.color.p900};
  background: transparent;
  border: 1px solid ${Common.color.b900};
  cursor: pointer;
`;

export const PlaceBt = styled.button`
  width: 100%;
  height: 30px;
  border: 1px solid ${Common.color.p300};
  background: transparent;
  cursor: pointer;
  /* margin-bottom: 15px; */
`;
export const TotalAmount = styled.div`
  display: flex;
  align-items: center;
  justify-content: end;
  gap: 15px;
  margin-bottom: 20px;
`;
export const ItemLine = styled.div`
  margin: 20px 0 20px 0;
  width: 100%;
  height: 1px;
  background-color: ${Common.color.p200};
  text-align: center;
`;

export const RvWrap = styled.div`
  padding: 20px;
  border-bottom: 1px solid ${Common.color.p200};
`;
export const RvForm = styled.div`
  position: relative;
  display: flex;
  align-items: center;
  gap: 20px;
  justify-content: space-between;
`;
export const MarginB10 = styled.div`
  height: 10px; /* 세로 간격을 설정합니다. */
`;
export const MarginB20 = styled.div`
  height: 20px; /* 세로 간격을 설정합니다. */
`;

export const MarginB30 = styled.div`
  height: 30px; /* 세로 간격을 설정합니다. */
`;

export const MarginB40 = styled.div`
  height: 40px; /* 세로 간격을 설정합니다. */
`;

export const HeartButton = styled.button`
  background: none;
  border: none;
  cursor: pointer;

  img {
    width: 37px;
    height: 31px;
    /* object-fit: cover; */
    cursor: pointer;
  }
`;
