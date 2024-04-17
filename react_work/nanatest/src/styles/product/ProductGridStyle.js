import styled from "@emotion/styled";

export const ProductWrap = styled.div`
  .protitle {
    padding-bottom: 38px;
    padding-top: 38px;
  }
`;
export const MealButton = styled.button`
  border: 1px solid ${props => (props.active ? "#e9b25f" : "#d9d9d9")};
  background: #fff;
  color: ${props => (props.active ? "#e9b25f" : "#bababa")};
  text-align: center;
  font-size: 25px;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
  width: 25%;
  height: 75px;
  cursor: pointer;
  margin-bottom: 50px;
`;

export const GridContainer = styled.div`
  /* width: 1280px; */
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  // itemsPerPage에 따라 동적으로 행의 수 계산
  gap: 20px;
  /* margin: 20px; */
  > * {
    grid-column: span 1;
    grid-row: span 1; /* 각 카드가 1행을 차지하도록 수정 */
  }
`;

export const PagiWarp = styled.div`
  /* width: 100%; */
  width: 1280px;
  /* height: 200px; */
  display: flex;
  justify-content: center;
  padding-bottom: 50px;
  padding-top: 50px;
  margin: 0 auto;
`;

export const ModalPagiWarp = styled.div`
  /* width: 100%; */
  /* width: 1280px; */
  /* height: 200px; */
  display: flex;
  justify-content: center;
  /* margin-top: 100px; */
  /* margin-bottom: 100px; */
  /* margin: 0 auto; */
  /* margin-bottom: 500px; */
  position: absolute;
  top: 90%;
  left: 35%;
`;
