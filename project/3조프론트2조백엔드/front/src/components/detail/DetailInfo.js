import React from "react";
import { PB20, PB30 } from "../../styles/basic";
import styled from "@emotion/styled/macro";
import { Common } from "../../styles/CommonCss";
import ListLi from "./ListLi";

// export const ulStyle styled = {
//   width: "640px",
//   height: "60px",
//   fontSize: "20px",
// };

export const UlStyle = styled.div`
  position: relative;
  display: flex;
  gap: 20px;
  li {
    font-size: 16px;
    margin: 20px 0 20px 0;
    color: ${Common.color.p800};
  }
`;
const DetailInfo = () => {
  const items1 = ["1", "2", "3"];
  const items2 = ["a", "b", "c"];
  return (
    <div>
      <>
        <UlStyle>
          <ListLi items={items1} />
          <ListLi items={items2} />
        </UlStyle>
      </>
    </div>
  );
};

export default DetailInfo;
