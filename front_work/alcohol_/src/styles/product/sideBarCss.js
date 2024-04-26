import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const SideBar = styled.div`
  width: 10vw;
  margin-right: 40px;
  hr {
    border: 2px solid ${Common.color.p900};
  }
  .side-nav {
    font-size: 16px;

    a {
      color: ${Common.color.p600};
    }
  }
`;
