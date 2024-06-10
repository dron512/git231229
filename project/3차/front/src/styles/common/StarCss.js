import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const StarRev = styled.div`
  /* padding: 10px 0 20px 0; */
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
`;
