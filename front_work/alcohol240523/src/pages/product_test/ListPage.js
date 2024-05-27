import React from "react";
import { useParams, useSearchParams } from "react-router-dom";

const ListPage = () => {
  const { type } = useSearchParams();

  console.log(type);

  //   switch (type) {
  //     case "wine":
  //       console.log("wine");
  //       break;
  //     case "whiskey":
  //       console.log("whiskey");
  //       break;
  //     case "brandy":
  //       console.log("brandy");
  //       break;
  //   }
  return <div>{type} 페이지 입니다.</div>;
};

export default ListPage;
