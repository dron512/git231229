import { Button, ConfigProvider } from "antd";
import React, { useState } from "react";
import { putOrderPage } from "../../api/paymentapi/paymentapi";
import {
  ModalButton,
  ModalPop,
  PaymentBody,
  PaymentFooter,
  PaymentHeader,
  PaymentWrap,
} from "../../styles/payment/paymentstyle";
import PayMethod from "./PayMethod";
import PaymentAdress from "./PaymentAdress";
import PaymentOrderInfo from "./PaymentOrderInfo";
import styled from "styled-components";
import useCustomLogin from "../../hooks/useCustomLogin";

const Payment = () => {
  const { moveToPath } = useCustomLogin();
  const [checkInfoPlz, setCheckInfoPlz] = useState(false);
  const [resultTitle, setResultTitle] = useState("");
  const [resultContent, setResultContent] = useState("");
  const [formData, setFormData] = useState({
    iorder: 0,
    iaddress: 0,
    addresseeNm: "",
    phoneNumber: 0,
    email: 0,
    ipaymentOption: 0,
  });

  // 배송지
  const handleAddressChange = selectedAddress => {
    setFormData({ ...formData, iaddress: selectedAddress });
    // console.log("나는 부모컴포넌트 주소 : ", selectedAddress);
    // console.log("나는 formData 주소 : ", selectedAddress);
  };

  //수령인 정보
  const handleOrderInfoChange = orderInfo => {
    setFormData({
      ...formData,
      iorder: orderInfo.iorder,
      addresseeNm: orderInfo.addresseeNm,
      phoneNumber: orderInfo.phoneNumber,
      email: orderInfo.email,
    });
    // console.log("나는 부모컴포넌트 유저정보 : ", orderInfo);
  };

  // 결제수단
  const handlebuyMethodChange = buyMethod => {
    setFormData({ ...formData, ipaymentOption: buyMethod });
    // console.log("나는 부모컴포넌트 결제수단 : ", buyMethod);
  };

  const handleSubmit = async () => {
    // 필수 값들 확인
    // console.log(formData);
    if (formData.iaddress === 0) {
      // console.log("iaddress 필수 값이 누락되었습니다.");
      setResultTitle("배송지를 선택해 주세요.");
      setCheckInfoPlz(true);
      return;
    }

    if (formData.addresseeNm === "") {
      // console.log("addresseeNm 필수 값이 누락되었습니다.");
      setCheckInfoPlz(true);
      setResultTitle("수령인 정보를 입력해 주세요.");
      return;
    }

    if (formData.phoneNumber === 0) {
      setResultTitle("수령인 정보를 입력해 주세요.");
      setCheckInfoPlz(true);
      return;
    }

    if (formData.email === "") {
      setResultTitle("수령인 정보를 입력해 주세요.");
      setCheckInfoPlz(true);
      return;
    }

    if (formData.ipaymentOption === 0) {
      setResultTitle("결제수단을 선택해 주세요.");
      setCheckInfoPlz(true);
      return;
    }

    // 나머지 코드는 여기에 작성
    try {
      const result = await putOrderPage({
        formData,
        successFn,
        failFn,
        errorFn,
      });
      // 성공적으로 처리되면 추가 작업 수행
      // console.log("formData.iorder", formData);
      moveToPath(`/order/${formData.iorder}`);
    } catch (error) {
      // console.log("PUT 요청 에러:", error);
      // 에러 처리 로직 추가
    }
  };

  const successFn = data => console.log("PUT API 성공", data);
  const failFn = error => console.log("PUT API 실패", error);
  const errorFn = (errorMsg, error) =>
    console.log("PUT API 서버에러", errorMsg, error);

  const callFN = () => {
    // 모달 닫기
    setCheckInfoPlz(false);
  };

  return (
    <PaymentWrap>
      {checkInfoPlz ? (
        <ModalPop>
          <div className="modalBack">
            <h1>{resultTitle}</h1>
            <ModalButton>
              <button onClick={callFN}>확인</button>
            </ModalButton>
          </div>
        </ModalPop>
      ) : null}
      <PaymentBody>
        <ConfigProvider
          theme={{
            components: {
              Button: {
                colorPrimary: "#E9B25F",
                colorPrimaryActive: "#CB8C2E",
                colorPrimaryBorder: "#E9B25F",
                colorPrimaryHover: "#DF9E3C",
              },
              Radio: {
                // buttonStyle: "solid",
                colorPrimary: "#E9B25F",
              },
              Input: {
                colorPrimary: "#E9B25F",
                activeBorderColor: "#E9B25F",
                hoverBorderColor: "#E9B25F",
              },
            },
          }}
        >
          <PaymentHeader className="paymentHeader">
            <p>주문 및 결제</p>
          </PaymentHeader>
          <hr />
          <div className="paymentMain">
            {/* ===== 배송지 선택 ===== */}
            <PaymentAdress handleAddressChange={handleAddressChange} />

            <hr />
            {/* ===== 수령자 정보 ===== */}
            <PaymentOrderInfo handleOrderInfoChange={handleOrderInfoChange} />
            <hr />

            <PayMethod handlebuyMethodChange={handlebuyMethodChange} />
          </div>
          <hr />
          <PaymentFooter>
            {/* 모달 띄우기 */}
            <Button style={{ width: "250px", height: "50px" }}>
              <p>주문취소</p>
            </Button>
            <Button
              type="primary"
              style={{ width: "250px", height: "50px" }}
              onClick={handleSubmit}
            >
              <p>주문하기</p>
            </Button>
          </PaymentFooter>
        </ConfigProvider>
      </PaymentBody>
    </PaymentWrap>
  );
};
export default Payment;
