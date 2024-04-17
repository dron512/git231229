import React, { useState } from "react";
import { Pagination } from "antd";
import styled from "styled-components";
const PaginationCom = () => {
  const Pagi = styled.div`
    background-color: red;
    margin: 0;
  `;
  const [current, setCurrent] = useState(3);
  const onChange = page => {
    // console.log(page);
    setCurrent(page);
  };
  return <Pagination current={current} onChange={onChange} total={50} />;
};
export default PaginationCom;
