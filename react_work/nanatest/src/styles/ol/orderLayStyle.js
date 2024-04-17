import styled from "@emotion/styled";

export const OrderPageStyle = styled.div`
  max-width: 1280px;
  margin: 0 auto;

  .order-button {
    border-bottom: solid 1px#868686;
  }

  .order-button button {
    width: 150px;
    height: 40px;
    cursor: pointer;
    border: 1px solid transparent;
    background-color: #fff;

    /* background-color: #fff; */
  }
  .active {
    border: 1px solid #666666;
    background-color: #fff;
    /* color: #fff; */
  }
  .button:hover,
  button.active {
    border: 1px solid #666;
  }
`;
