import styled from "@emotion/styled";
import { Input } from "antd";
import { Common } from "./CommonCss";
export const Wrap = styled.div`
  position: relative;
  max-width: ${props => props.maxw + "px"};
`;
export const P30 = styled.p`
  font-size: 30px;
`;
export const PB30 = styled.p`
  font-size: 30px;
  font-weight: bold;
`;

export const P20 = styled.p`
  font-size: 20px;
`;
export const PB20 = styled.p`
  font-size: 20px;
  font-weight: bold;
`;
export const P16 = styled.p`
  font-size: 16px;
`;
export const PB16 = styled.p`
  font-size: 16px;
  font-weight: bold;
`;
export const P13 = styled.p`
  font-size: 13px;
`;

export const SignWrap = styled.div`
  border-top: 1px solid ${Common.color.p900};
  border-bottom: 1px solid ${Common.color.p900};
  padding: 80px 0 80px 0;
  margin-bottom: 40px;
`;
