import styled from "@emotion/styled/macro";

export const CounterWrapper = styled.div`
  display: flex;
  align-items: center;
  gap: 10px;
  /* margin-top: 20px; */
  margin: 0 10px 0 10px;
`;

export const CounterValue = styled.div`
  font-size: 16px;
  font-weight: bold;
`;

export const CounterButton = styled.button`
  /* padding: 0px 14px; */
  /* font-size: 30px; */
  width: 30px;
  height: 30px;
  background-color: #fff;
  /* text-align: center; */
  /* width: 30px; */
  /* height: 30px; */
  cursor: pointer;
  border: 1px solid #868686;

  &:hover {
    background-color: #868686;
  }
  img {
    width: 20px;
    height: 20px;
    border: none;
  }
`;
