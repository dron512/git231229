import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const DropWrap = styled.div`
  display: flex;
  justify-content: center;
`;
export const DropStyle = styled.div`
  position: relative;
  display: inline-block;
  text-align: center;
  h1 {
    margin: 0 60px 0 60px;
    color: ${Common.color.p000};
  }
  .dropdown-content {
    display: ${props => (props.isOpen ? "block" : "none")};
    position: absolute;
    background-color: ${Common.color.b900};
    min-width: 160px;
    z-index: 1;
    left: 50%;
    transform: translate(-50%, 0%);
    text-align: center;
    font-size: 13px;
    border-radius: 5px;
  }

  .dropdown-content a {
    color: ${Common.color.p300};
    padding: 18px 16px;
    text-decoration: none;
    display: block;
  }

  .dropdown-content a:hover {
    color: ${Common.color.p000};
    font-weight: 600;
  }
`;
