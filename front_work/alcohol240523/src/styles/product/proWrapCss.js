import styled from "@emotion/styled/macro";

export const ProductWrap = styled.div`
  padding: 50px 0 50px 0;
  display: flex;
  position: relative;
`;

export const ProListWrap = styled.div`
  position: relative;
  margin: 0 auto;
`;
export const GridContainer = styled.div`
  position: relative;
  width: 100%;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-column-gap: 20px; /* 가로 간격 */
  grid-row-gap: 80px; /* 세로 간격 */
`;
