import styled from "@emotion/styled/macro";
import React from "react";

const SideSubTitle = ({ sideSubTitle }) => {
  const SideSubTitleStyle = styled.div`
    margin: 30px 0 0 0;
    p {
      font-size: 16px;
      font-weight: bold;
      cursor: default;
    }
  `;
  return (
    <div>
      <SideSubTitleStyle>
        <p>{sideSubTitle}</p>
      </SideSubTitleStyle>
    </div>
  );
};

export default SideSubTitle;
