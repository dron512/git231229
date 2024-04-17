import styled from "@emotion/styled";
import React, { useState } from "react";
import OrderDate from "../../components/orderlist/OrderDate";
import DateButton from "../../components/orderlist/DateButton";
import { motion } from "framer-motion";
import { OrderViewStyle } from "../../styles/ol/orderStyle";

const OrderView = () => {
  const orders = [
    {
      createdAt: "2024-01-29 15:41:31",
      iorder: 100006,
      idetails: 84,
      refundFl: 1,
      reviewFl: 1,
      items: [
        {
          productpic: "/assets/images/youtube.svg",
          iorder: 100006,
          iproduct: 1,
          price: 12500,
          processState: "배송중",
          productCnt: 1,
          productNm: "아주아주멋진아이템임",
          // refundFl: 0,
          // reviewFl: 0,
        },
      ],
    },
    {
      createdAt: "2024-01-29 15:41:31",
      iorder: 100006,
      idetails: 84,
      refundFl: 1,
      reviewFl: 0,
      items: [
        {
          productpic: "/assets/images/youtube.svg",
          productNm: "아주아주멋진아이템임1",
          productCnt: 5,
          price: 55500,
          processState: "배송중",
        },
        {
          productpic: "/assets/images/youtube.svg",
          productNm: "아주아주멋진아이템임2",
          productCnt: 5,
          price: 55500,
          processState: "배송중",
        },
        {
          productpic: "/assets/images/youtube.svg",
          productNm: "아주아주멋진아이템임3",
          productCnt: 5,
          price: 55500,
          processState: "배송중",
        },
      ],
    },
    {
      orderNumber: "191231230",
      date: "2024-01-04",
      items: [
        {
          productImage: "/assets/images/youtube.svg",
          productName: "화 ㅈㄴ 나네???",
          quantity: 5,
          productAmount: 45500,
          deliveryStatus: "배송중",
        },
        {
          productImage: "/assets/images/youtube.svg",
          productName: "저거 점 우리가 찍어야 하나?",
          quantity: 3,
          productAmount: 79500,
          deliveryStatus: "배송중",
        },
        {
          productImage: "/assets/images/youtube.svg",
          productName: "일까?",
          quantity: 1,
          productAmount: 15500,
          deliveryStatus: "배송중",
        },
      ],
    },
    {
      createdAt: "2024-01-24 12:37:49",
      iorder: 33,
      idetails: 77,
      refundFl: 1,
      reviewFl: 1,
      items: [
        {
          idetails: 77,
          repPic: "사진",
          productNm: "vel",
          productCnt: 2,
          price: 41214,
          processState: "구매확인",
          refundFl: 1,
        },
        {
          idetails: 78,
          repPic: "사진",
          productNm: "volutpat",
          productCnt: 1,
          price: 35048,
          processState: "구매확인",
        },
        {
          idetails: 13,
          repPic: "사진",
          productNm: "ultrices",
          productCnt: 2,
          price: 40188,
          processState: "구매확인",
        },
      ],
    },
  ];

  const [isOpen, setIsOpen] = useState(orders.map(() => false));

  const handleOpen = idx => {
    setIsOpen(item => {
      const newState = [...item];
      newState[idx] = !newState[idx];
      return newState;
    });
  };

  return (
    <OrderViewStyle>
      <div className="inwrap">
        <div className="order-info">
          <div className="orderin">
            <div className="date-select">
              <select className="languages">
                <option value="">전체 주문처리상태</option>
                <option value="">입금전</option>
                <option value="">배송준비중</option>
                <option value="">배송중</option>
                <option value="">배송완료</option>
                {/* <option value="">환불/취소</option> */}
              </select>
              <DateButton />
              {/* <OrderDate /> */}
            </div>
            <p>
              기간 검색시 지난 주문내역을 조회하실 수 있습니다.
              <br />
              주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수
              있습니다.
              <br />
              취소/교환/반품 신청은 주문 완료일 기준 14일까지 가능합니다.
              <br />
            </p>
          </div>
        </div>
        <div className="footer">
          <p>주문일자 [주문번호]</p>
          <p>이미지</p>
          <p className="footer-p">상품정보</p>
          <p>수량</p>
          <p>상품구매금액</p>
          <p>배송상태</p>
          <p>취소/반품</p>
          <p>리뷰관리</p>
        </div>
        {orders.map((orders, idx) => (
          <div key={idx} className="footer-2">
            <div className="footer-info">
              <div className="footer-info-2">
                <p>
                  {orders.createdAt}
                  <br /> <span>[{orders.iorder}]</span>
                </p>
                <button>주문상세보기{orders.idetails}</button>
              </div>
              <div className="aaa">
                {orders.items
                  .slice(0, isOpen[idx] ? orders.items.length : 1)
                  .map((orders, itemIndex) => (
                    <div key={itemIndex} className="footer-itme">
                      <div className="footer-itme-img">
                        <img src={orders.repPic} alt="상품" />
                      </div>
                      <p className="footer-itme-p">{orders.productNm}</p>
                      <p>{orders.productCnt}</p>
                      <p>{orders.price}</p>
                      <p>{orders.processState}</p>

                      <div className="footer-itme-bt">
                        {orders.refundFl === 1 && <button>주문취소</button>}
                      </div>
                      <div className="footer-itme-bt">
                        <button>주문취소</button>
                      </div>
                    </div>
                  ))}
                <div className="footer-itme-bt">
                  {orders.refundFl === 1 && <button>주문취소</button>}
                  {orders.refundFl === 2 && <button>반품신청</button>}
                  {orders.refundFl === 3 && (
                    <div className="footer-itme-bt" style={{ width: "100px" }}>
                      {/* 빈 요소, 아무 내용이 없으므로 공백이나 다른 텍스트가 들어가도 좋습니다. */}
                    </div>
                  )}
                </div>
              </div>
            </div>
            <div className="dropdown-bt">
              <div>
                <motion.button
                  whileHover={{ scale: 1.1 }}
                  transition={{ type: "spring", stiffness: 500 }}
                  onClick={() => handleOpen(idx)}
                >
                  {isOpen[idx] ? "접기" : "더보기"}
                </motion.button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </OrderViewStyle>
  );
};

export default OrderView;
