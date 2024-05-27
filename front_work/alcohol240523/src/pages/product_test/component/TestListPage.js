import React from "react";
import SideBar from "./SideBar";
import Map from "./Map";
import { useQuery } from "react-query";
import { getData } from "../productApi";

const TestListPage = () => {
  const params = {};
  const { data } = useQuery({
    queryKey: [params],
    queryFn: () => getData({ params }),
  });
  const handleClick = category => {
    if (category === "wa") {
      console.log("ok");
    } else {
      console.log("no");
    }
  };

  return (
    <div>
      <button onClick={() => handleClick("wa")}>w-a</button>
      <button onClick={() => handleClick("w1")}>w-1</button>
      <button>w-2</button>
      <button>w-3</button>
      <button>w-4</button>
      <button>wine-a</button>
      <button>wine-1</button>
      <button>wine-2</button>
      <button>wine-3</button>
      <button>wine-4</button>
      <button>brand-a</button>
      <button>brand-1</button>
      <button>brand-2</button>
      <button>brand-3</button>
      <button>brand4</button>
      <SideBar />
      <Map />
    </div>
  );
};

export default TestListPage;
