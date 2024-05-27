import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const PickUpCard = styled.div`
  position: relative;
  /* margin: 0 auto; */
  /* justify-content: space-between; */
  justify-content: center;
  gap: 80px;
  display: flex;
  padding: 80px;
  a {
    width: 516px;
    height: 290px;
    background-color: ${Common.color.p000};
    border-radius: 20px;
  }
  .pickCard {
    padding: 50px;
    b {
      font-size: 50px;
    }
    p {
      font-size: 20px;
      font-weight: bold;
      margin-top: 15px;
    }
  }
  .pickCard2 :hover {
    cursor: pointer;
  }
`;
