import React, { useState } from "react";
import { Outlet } from "react-router";
import CommunityTitle from "../../components/basic/CommunityTitle";
import { Commu } from "./styles/commStyle";

const CommunityPage = () => {
  const [maintxt, setMaintxt] = useState("공지사항");
  const [subtxt, setSubtxt] = useState(
    "배송 및 상품관련 공지사항을 확인해 주세요.",
  );
  return (
    <Commu>
      <CommunityTitle maintxt={maintxt} subtxt={subtxt} />
      <Outlet context={{ setMaintxt, setSubtxt }} />
    </Commu>
  );
};

export default CommunityPage;
