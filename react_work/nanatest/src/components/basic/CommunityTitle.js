import React from "react";
import { ComTitle } from "../../styles/communitytitlestyle";

export const CommunityTitle = ({ maintxt, subtxt }) => {
  return (
    <ComTitle>
      <h1>{maintxt}</h1>
      <span>{subtxt}</span>
    </ComTitle>
  );
};

export default CommunityTitle;
