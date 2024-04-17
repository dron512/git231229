import styled from "@emotion/styled";

export const OrderViewStyle = styled.div`
  .inwrap {
    position: relative;
    max-width: 1280px;
    height: 100%;
    margin: 0 auto;

    justify-content: space-between;
  }
  .order-info {
    position: relative;
    width: 100%;
    height: 251px;
    border: 1px solid #d9d9d9;
    background: #fff;
    text-align: center;
    justify-content: center;

    margin-top: 60px;
    display: flex;
    align-items: center;
    margin-bottom: 70px;
  }
  .orderin {
    width: 100%;
  }
  .date-select {
    margin: 20px;
    position: relative;
    display: flex;
    justify-content: center;
    gap: 30px;
    align-items: center;
    justify-items: center;
  }
  .date-select button {
    width: 50px;
    height: 29px;
    border: 1px solid #d4c7c7;
    background: #f2f2f2;
    cursor: pointer;
  }
  .date-select select {
    width: 130px;
    height: 29px;
    background: #fff;
  }
  .orderin p {
    line-height: 20px;
    font-size: 12px;
    color: #868686;
  }
  .footer {
    border-top: 1px solid #868686;
    border-bottom: 1px solid #868686;
    display: flex;
    justify-content: space-between;
    color: #868686;
    text-align: center;
    font-family: Roboto;
    font-size: 12px;
    font-style: normal;
    font-weight: 400;
    line-height: 15px; /* 125% */
    letter-spacing: 0.5px;
    padding: 30px 20px;
    p {
      width: 8.5%;
    }
    .footer-p {
      width: 40%;
    }
  }

  .footer-info {
    display: flex;
    align-items: center;
    color: #868686;
    text-align: center;
    font-family: Roboto;
    font-size: 12px;
    font-style: normal;
    font-weight: 400;
    line-height: 15px; /* 125% */
    letter-spacing: 0.5px;
    padding: 30px 20px;
  }
  .footer-info-2 {
    width: 8.5%;
    button {
      background: transparent;
      border: 1px solid #868686;
      cursor: pointer;
      width: 100%;
      border-radius: 5px;
      color: #868686;
      text-align: center;
      font-family: Roboto;
      font-size: 12px;
      font-style: normal;
      font-weight: 400;
      line-height: 24px; /* 200% */
      letter-spacing: 0.5px;
    }
  }
  .order-border {
    border: 1px solid #868686;
    border-top: none;
  }
  .itemmap {
    position: relative;
    display: flex;
    /* width: 900px; */
    flex-direction: column;
    gap: 20px;
  }
  .itme {
    display: flex;
    justify-content: space-between;
    align-items: center;
    /* padding-right: 50px; */
    /* margin-right: 50px; */

    width: 1120px;
    .itme-img {
      width: 50px;
      height: 50px;
      background-color: #868686;
      margin-left: 50px;
    }
    img {
      width: 50px;
      height: 50px;
    }
    .itme-p {
      width: 500px;
      margin-left: 50px;
    }
    p {
      width: 121px;
      /* gap: 10px; */
      /* margin-right: 20px; */
      /* margin-left: 30px; */
      /* margin-right: 30px; */
    }
  }

  .refl {
    position: relative;
    display: flex;
    /* width: 150px; */
    /* margin-left: 10px; */
    /* padding-right: 30px; */
    /* width: 300px; */

    .itme-bt {
      /* width: 9.3%; */
      width: 200px;
      display: flex;
      /* margin-left: 10px; */
      /* padding-left: 100px; */
      /* padding-right: 20px; */
      /* padding-left: 10px; */

      .orderButton {
        background: transparent;
        border: 1px solid #868686;

        border-radius: 5px;
        cursor: pointer;
        /* width: 80%; */
        width: 80px;
        color: #868686;
        text-align: center;
        font-size: 12px;
        font-style: normal;
        font-weight: 400;
        line-height: 24px;
        letter-spacing: 0.5px;
        /* margin-right: 25px; */
        margin-left: 20px;
      }
      .orderButton2 {
        background: transparent;
        border: none;

        border-radius: 5px;
        cursor: pointer;
        /* width: 80%; */
        width: 80px;
        color: #868686;
        text-align: center;
        font-size: 12px;
        font-style: normal;
        font-weight: 400;
        line-height: 24px;
        letter-spacing: 0.5px;
        /* margin-right: 25px; */
        margin-left: 20px;
      }
    }
  }
  .dropdown-bt {
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
    button {
      border-radius: 5px;
      background: transparent;
      border: 1px solid #868686;
      cursor: pointer;
      width: 100px;
      color: #868686;
      text-align: center;
      font-family: Roboto;
      font-size: 12px;
      font-style: normal;
      font-weight: 400;
      line-height: 24px;
      letter-spacing: 0.5px;
    }
  }
`;

export const ReturnViewStyle = styled.div`
  .inwrap {
    position: relative;
    max-width: 1280px;
    height: 100%;
    margin: 0 auto;

    justify-content: space-between;
  }
  .order-info {
    position: relative;
    width: 100%;
    height: 251px;
    border: 1px solid #d9d9d9;
    background: #fff;
    text-align: center;
    justify-content: center;

    margin-top: 60px;
    display: flex;
    align-items: center;
    margin-bottom: 70px;
  }
  .orderin {
    width: 100%;
  }
  .date-select {
    margin: 20px;
    position: relative;
    display: flex;
    justify-content: center;
    gap: 30px;
    align-items: center;
    justify-items: center;
  }
  .date-select button {
    width: 50px;
    height: 29px;
    border: 1px solid #d4c7c7;
    background: #f2f2f2;
    cursor: pointer;
  }
  .date-select select {
    width: 130px;
    height: 29px;
    background: #fff;
  }
  .orderin p {
    line-height: 20px;
    font-size: 12px;
    color: #868686;
  }
  .footer {
    border-top: 1px solid #868686;
    border-bottom: 1px solid #868686;
    display: flex;
    justify-content: space-between;
    color: #868686;
    text-align: center;
    font-family: Roboto;
    font-size: 12px;
    font-style: normal;
    font-weight: 400;
    line-height: 15px; /* 125% */
    letter-spacing: 0.5px;
    padding: 30px 20px;
    p {
      width: 8.5%;
    }
    .footer-p {
      width: 40%;
    }
  }

  .footer-info {
    display: flex;
    align-items: center;
    color: #868686;
    text-align: center;
    font-family: Roboto;
    font-size: 12px;
    font-style: normal;
    font-weight: 400;
    line-height: 15px; /* 125% */
    letter-spacing: 0.5px;
    padding: 30px 20px;
  }
  .footer-info-2 {
    width: 8.5%;
    button {
      background: transparent;
      border: 1px solid #868686;
      cursor: pointer;
      width: 100%;
      border-radius: 5px;
      color: #868686;
      text-align: center;
      font-family: Roboto;
      font-size: 12px;
      font-style: normal;
      font-weight: 400;
      line-height: 24px; /* 200% */
      letter-spacing: 0.5px;
    }
  }
  .order-border {
    border: 1px solid #868686;
    border-top: none;
  }
  .itemmap {
    position: relative;
    display: flex;
    width: 100%;
    flex-direction: column;
    gap: 20px;
  }
  .itme {
    display: flex;
    justify-content: space-between;
    align-items: center;
    /* padding-right: 50px; */
    /* margin-right: 50px; */
    /* width: 1000px; */
    .itme-img {
      width: 50px;
      height: 50px;
      background-color: #868686;
      margin-left: 75px;
    }
    img {
      width: 50px;
      height: 50px;
    }
    .itme-p {
      width: 500px;
      margin-left: 50px;
    }
    p {
      width: 110px;
      /* gap: 10px; */
      /* margin-right: 20px; */
      /* margin-left: 30px; */
      /* margin-right: 30px; */
    }
  }

  .refl {
    display: flex;
    /* width: 150px; */
    margin-left: 10px;
    /* padding-right: 30px; */
    .itme-bt {
      /* width: 9.3%; */
      width: 97px;

      button {
        background: transparent;
        border: 1px solid #868686;
        border-radius: 5px;
        cursor: pointer;
        width: 80%;
        color: #868686;
        text-align: center;

        font-size: 12px;
        font-style: normal;
        font-weight: 400;
        line-height: 24px;
        letter-spacing: 0.5px;
      }
    }
  }
  .dropdown-bt {
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
    button {
      border-radius: 5px;
      background: transparent;
      border: 1px solid #868686;
      cursor: pointer;
      width: 100px;
      color: #868686;
      text-align: center;
      font-family: Roboto;
      font-size: 12px;
      font-style: normal;
      font-weight: 400;
      line-height: 24px;
      letter-spacing: 0.5px;
    }
  }
`;
