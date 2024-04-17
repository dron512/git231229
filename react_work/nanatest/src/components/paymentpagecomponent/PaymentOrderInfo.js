import { ConfigProvider, Input } from "antd";
import React, { useEffect, useState } from "react";
import { getPayItemList } from "../../api/paymentapi/paymentapi";
import {
  OrderInfo,
  OrderProduct,
  PaymentInfo,
  TotalOrder,
} from "../../styles/payment/paymentstyle";
import { useParams } from "react-router";
import { API_SERVER_HOST } from "../../util/util";
import styled from "styled-components";

const PaymentOrderInfo = ({ handleOrderInfoChange }) => {
  const { iorder } = useParams();

  const [orderInfo, setOrderInfo] = useState({
    iorder: "",
    addresseeNm: "",
    email: "",
    phoneNumber: "",
    products: [
      {
        iproduct: 0,
        productNm: "",
        productCnt: 0,
        productTotalPrice: 0,
        repPic: "",
      },
    ],
    totalProductCnt: 0,
    totalOrderPrice: 0,
  });

  const successFn = result => {
    const updatedOrderInfo = result.data;
    setOrderInfo(updatedOrderInfo);
    handleOrderInfoChange(updatedOrderInfo);
    // console.log(result);
  };

  const failFn = result => {
    // console.log(result);
  };

  const errorFn = result => {
    // console.log("에러에옹", result);
  };

  useEffect(() => {
    console.log("iorder from URL:", iorder);

    getPayItemList({ iorder, successFn, failFn, errorFn });
  }, [iorder]);

  // 넘길 값 콘솔로 확인하기
  // console.log("수령인", orderInfo.addresseeNm);
  // console.log("이메일", orderInfo.email);
  // console.log("전화번호", orderInfo.phoneNumber);

  const handleInputChange = (e, key) => {
    // Input 값이 변경될 때마다 state를 업데이트
    setOrderInfo(prevState => ({
      ...prevState,
      [key]: e.target.value,
    }));
    handleOrderInfoChange({
      ...orderInfo, // 현재 orderInfo 값
      [key]: e.target.value, // 업데이트된 값만 추가
    });
  };

  return (
    <PaymentInfo>
      <ConfigProvider
        theme={{
          components: {
            Button: {
              // colorPrimary: "#00b96b",
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
        <OrderInfo className="orderInfo">
          <div className="paymentListTitle">수령인 정보</div>
          <div className="InfoDetail">
            <div>
              <p>이름</p>
            </div>

            <Input
              maxLength={20}
              style={{
                borderRadius: "0px",
                outline: "none",
                boxShadow: "none",
                height: "40px",
              }}
              spellCheck={false}
              value={orderInfo.addresseeNm}
              onChange={e => handleInputChange(e, "addresseeNm")}
            />
          </div>
          <div className="InfoDetail">
            <div>
              <p>이메일</p>
            </div>

            <Input
              maxLength={20}
              style={{
                borderRadius: "0px",
                outline: "none",
                boxShadow: "none",
                height: "40px",
              }}
              spellCheck={false}
              value={orderInfo.email}
              onChange={e => handleInputChange(e, "email")}
            />
          </div>
          <div className="InfoDetail">
            <div>
              <p>전화번호</p>
            </div>

            <Input
              type="tel"
              maxLength={20}
              style={{
                borderRadius: "0px",
                outline: "none",
                boxShadow: "none",
                height: "40px",
              }}
              spellCheck={false}
              value={orderInfo.phoneNumber}
              onChange={e => handleInputChange(e, "phoneNumber")}
            />
          </div>
        </OrderInfo>
        <hr />
        <div className="paymentListTitle">주문상품</div>
        <div className="주문상품">
          {orderInfo.products.map(product => (
            <OrderProduct key={product.productNm}>
              <div className="productImgDesc">
                <div>
                  <img
                    src={
                      product.repPic === ""
                        ? process.env.PUBLIC_URL +
                          "/assets/images/defaultitemimg.svg"
                        : `${API_SERVER_HOST}/pic/product/${product.iproduct}/${product.repPic}`
                    }
                    alt={product.productNm}
                  />
                </div>

                <div className="productNameTex">
                  <div className="pdName">{product.productNm}</div>
                  <div className="pdTex">
                    <p>배송비 무료</p>
                  </div>
                </div>
              </div>

              <div className="countPrice">
                <p>{product.productCnt} 개</p>
                <b>{product.productTotalPrice.toLocaleString()} 원</b>
              </div>
            </OrderProduct>
          ))}
        </div>
        <hr />
        <TotalOrder className="총 주문 금액">
          <div className="paymentListTitle">총 주문 금액</div>
          <div className="orderPrice">
            <div className="orderPriceDiv">
              <div>주문 상품 수</div>
              <div>{orderInfo.totalProductCnt} 개</div>
            </div>
            <div className="orderPriceDiv">
              <div>주문금액</div>
              <div>{orderInfo.totalOrderPrice.toLocaleString()} 원</div>
            </div>
            <div className="orderPriceDiv">
              <div>할인금액</div>
              <div>0원</div>
            </div>
            <div className="orderPriceDiv">
              <div>배송비</div>
              <div>무료</div>
            </div>
            <div className="orderPriceDiv">
              <div>최종 결제 금액</div>
              <div>{orderInfo.totalOrderPrice.toLocaleString()} 원</div>
            </div>
          </div>
        </TotalOrder>
      </ConfigProvider>
    </PaymentInfo>
  );
};

export default PaymentOrderInfo;
