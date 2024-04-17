import styled from "@emotion/styled";
import React, { useEffect, useState } from "react";

import { motion } from "framer-motion";
import { OrderViewStyle } from "../../styles/ol/orderStyle";

import { Navigate, useNavigate } from "react-router-dom";
import {
  deleteOne,
  getOrderListPage,
  postOne,
} from "../../api/orderapi/orderListApi";
import { PagiWarp } from "../../styles/product/ProductGridStyle";
import { Pagination } from "antd";
import CancelOrderModal from "../../components/modal/CancelOrderModal";
import MealModal from "../../components/modal/MealModal";
import {
  ButtonContainer,
  OpenModalButton,
} from "../../styles/modal/productModalStyle";
import { API_SERVER_HOST } from "../../util/util";
import ReturnOrderModal from "../../components/modal/ReturnOrderModal";
import { OpenOrderbt } from "../../styles/modal/orderModalStyle";

const initState = {
  createdAt: "",
  idetails: 0,
  iorder: 0,
  refundFl: 0,
  reviewFl: 0,
  items: [
    {
      idetails: 0,
      price: 0,
      processState: "",
      productCnt: 0,
      productNm: "",
      repPic: "",
    },
  ],
};
const OrderView = () => {
  const [orderData, setOrderData] = useState([initState]);
  const [isOpen, setIsOpen] = useState([]);

  const [dateButton, setDateButton] = useState();
  const [activeDate, setActiveDate] = useState();
  const [optionButton, setOptionButton] = useState(0);
  const [retutnData, setRetutnData] = useState();

  const iorderNavi = useNavigate();

  // 페이지 네이션 ==================================================
  const [currentPage, setCurrentPage] = useState(0);
  const itemsPerPage = 6;
  // 현재 페이지에 해당하는 데이터 추출
  const offset = currentPage * itemsPerPage;
  const currentData = orderData.slice(offset, offset + itemsPerPage);
  // 페이지 변경 시 호출되는 함수
  const handlePageChange = page => {
    setCurrentPage(page); // Ant Design Pagination은 1부터 시작하므로 1을 빼줍니다.
  };
  // 페이지 네이션 ==================================================

  // 모달 ==================================================
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedOrderId, setSelectedOrderId] = useState();
  // 모달 열기
  const openModal = orderId => {
    setModalOpen(true);
    setSelectedOrderId(orderId);
  };

  // 모달 닫기
  const closeModal = () => {
    setModalOpen(false);
  };
  // 모달 ==================================================
  const handleOpen = index => {
    setIsOpen(item => {
      const updatedOrder = [...item];
      updatedOrder[index] = !updatedOrder[index];
      return updatedOrder;
    });
  };

  const handleDateButton = buttonType => {
    setActiveDate(buttonType);
    setDateButton(buttonType); // dateButton 상태 업데이트
    // fetchData(); // 변경된 값으로 데이터를 다시 가져옴
  };
  const handleState = e => {
    const selectedOption = e.target.value;
    setOptionButton(selectedOption);
    // console.log("옵션버튼", selectedOption);
  };

  const fetchData = () => {
    getOrderListPage({
      orderParam: {
        list_flag: 1,
        process_state_code: optionButton,
        date: dateButton,
      },
      successFn,
      failFn,
      errorFn,
    });
  };

  const successFn = data => {
    // console.log("successFn : ", data);
    setOrderData(data);
  };

  const failFn = data => {
    // console.log("failFn : ", data);
    alert("failFn : 데이터 호출에 실패하였습니다.");
  };

  const errorFn = data => {
    // console.log("errorFn : ", data);
    alert("서버상태 불안정 그래서, 데모테스트했음.");
    setOrderData(data);
  };

  useEffect(() => {
    setIsOpen(Array(orderData.length).fill(false));
  }, [orderData]); // orderData가 업데이트될 때마다 isOpen을 초기화

  useEffect(() => {
    fetchData();
  }, [dateButton, optionButton]);

  // 상태에 따른 버튼 출력
  const makeStateBt = (_orders, _iOrder, _iDetails) => {
    return (
      <>
        {_orders.processState === "배송완료" ? (
          <button className="orderButton2">
            {/* 반품처리 {_orders.idetails}|{_orders.productCnt}|{_orders.price} */}
            <OpenOrderbt onClick={() => openModalGoodPopup(_orders)}>
              반품신청
            </OpenOrderbt>
          </button>
        ) : null}
        {/* ================================== */}
        {_orders.processState === "배송준비중" ? (
          <button className="orderButton2">
            {/* 주문취소 {_orders.iorder} */}
            {/* 주문취소 {_iOrder} */}
            <OpenOrderbt onClick={() => openModalCancel(_iOrder)}>
              주문취소
            </OpenOrderbt>
          </button>
        ) : null}
      </>
    );
  };

  const DateBt = styled.button`
    /* border: none; */
    background: #fff;
    color: ${props => (props.active ? "#e9b25f" : "#bababa")};
    text-align: center;
    font-family: Noto Sans KR;
    font-size: 12px;
    height: 35px;
    cursor: pointer;
  `;

  const [returnGoodPopup, setReturnGoodPopup] = useState(false);
  const [returnGoodPopupData, setReturnGoodPopupData] = useState(null);
  // const handleReturnOrder = (iDetails, iPrice, iProductCount) => {
  const handleReturnOrder = (_iDetails, _returncontents) => {
    // console.log("반품신청", _iDetails);
    const sendData = {
      contents: _returncontents,
      refundCnt: _iDetails.productCnt,
      refundPrice: _iDetails.price,
    };
    // console.log(sendData);
    postOne(_iDetails.idetails, {
      idetailData: sendData,
      successFn: successFn_Return,
      failFn: failFn_Return,
      errorFn: errorFn_Return,
    });
  };

  const successFn_Return = data => {
    // console.log("반품신청 successFn : ", data);
    closeModalGoodPopup();
    fetchData();
    handlePageChange(1);
  };

  const failFn_Return = data => {
    // console.log("반품신청 failFn : ", data);
    alert("failFn : 반품신청  호출에 실패하였습니다.");
  };

  const errorFn_Return = data => {
    // console.log("반품신청 : ", data);
    alert("서버상태 불안정 반품신청 데모테스트했음.");
  };

  const closeModalGoodPopup = () => {
    setReturnGoodPopup(false);
  };

  const openModalGoodPopup = _idetails => {
    // console.log("=============================", _idetails);
    setReturnGoodPopupData(_idetails);
    setReturnGoodPopup(true);
  };

  const [modalOpenCancel, setModalOpenCancel] = useState(false);
  const [cancelGoodPopupData, setCancelGoodPopupData] = useState(0);
  const closeModalCancel = () => {
    // console.log("closeModalCancel");
    setModalOpenCancel(false);
    setCancelGoodPopupData(0);
  };
  const openModalCancel = _iOrder => {
    // console.log("openModalCancel : ", _iOrder);
    setCancelGoodPopupData(_iOrder);
    setModalOpenCancel(true);
  };
  const handleCancelOrder = () => {
    // console.log("handleCancelOrder : ", cancelGoodPopupData);
    // console.log("주문취소", cancelGoodPopupData);
    deleteOne({
      iorder: cancelGoodPopupData,
      successFn: successFn_Cancel,
      failFn: failFn_Cancel,
      errorFn: errorFn_Cancel,
    });
    setModalOpenCancel(false);
  };

  const successFn_Cancel = data => {
    // console.log("successFn_Cancel : ", data);
    setModalOpenCancel(false);
    fetchData();
    handlePageChange(1);
  };

  const failFn_Cancel = data => {
    // console.log("failFn_Cancel : ", data);
    alert("failFn : 데이터 호출에 실패하였습니다.");
  };

  const errorFn_Cancel = data => {
    // console.log("errorFn_Cancel : ", data);
    alert("서버상태 불안정 그래서, 데모테스트했음.");
    // setOrderData(data);
  };

  // 주문취소
  // `http://112.222.157.156:5223/api/order?iorder=1`;
  // const handleCancelOrder = _iOrder => {
  //   console.log("주문취소", _iOrder);
  //   handleCancelOrder(false);
  //   // deleteOne({
  //   //   iorder: _iOrder,
  //   //   successFn,
  //   //   failFn,
  //   //   errorFn,
  //   // });
  // };

  return (
    <OrderViewStyle>
      {modalOpenCancel && (
        <CancelOrderModal
          closeModal={closeModalCancel}
          handleCancelOrder={handleCancelOrder}
          // setModalOpenCancel={setModalOpenCancel}
          // onClick={() => handleCancelOrder(_iOrder)}
          // closeModal={closeModal}
          // orderData={_iOrder}
        />
      )}

      {returnGoodPopup && (
        <ReturnOrderModal
          closeModal={closeModalGoodPopup}
          idetailData={returnGoodPopupData}
          handleReturnOrder={handleReturnOrder}
        />
      )}

      <div className="inwrap">
        <div className="order-info">
          <div className="orderin">
            <div className="date-select">
              <select className="languages" onChange={handleState}>
                <option value="1">전체 주문처리상태</option>
                <option value="2">입금전</option>
                <option value="3">배송준비중</option>
                <option value="4">배송중</option>
                <option value="5">배송완료</option>
              </select>

              {/* <OpenModalButton onClick={openModal}>
                주문취소하라고
              </OpenModalButton>
              {modalOpen && (
                <CancelOrderModal
                  closeModal={closeModal}
                  handleCancelOrder={handleCancelOrder}
                  orderData={orderData}
                />
              )} */}

              {/* <ButtonContainer>
                <OpenModalButton onClick={openModal}>🥣</OpenModalButton>
                {modalOpen && <MealModal closeModal={closeModal} />}
              </ButtonContainer> */}

              <div>
                <DateBt
                  onClick={() => handleDateButton(1)}
                  active={activeDate === 1}
                >
                  오늘
                </DateBt>
                <DateBt
                  onClick={() => handleDateButton(2)}
                  active={activeDate === 2}
                >
                  1주일
                </DateBt>
                <DateBt
                  onClick={() => handleDateButton(3)}
                  active={activeDate === 3}
                >
                  1개월
                </DateBt>
                <DateBt
                  onClick={() => handleDateButton(4)}
                  active={activeDate === 4}
                >
                  3개월
                </DateBt>
                <DateBt
                  onClick={() => handleDateButton(5)}
                  active={activeDate === 5}
                >
                  6개월
                </DateBt>
              </div>
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

        {orderData &&
          currentData.map((orders, idx) => (
            <div key={idx} className="order-border">
              <div className="footer-info">
                <div className="footer-info-2">
                  <p>
                    {orders.createdAt}
                    <br /> <span>[{orders.iorder}]</span>
                  </p>
                  <button onClick={() => iorderNavi(`/order/${orders.iorder}`)}>
                    주문상세보기
                  </button>
                </div>

                <div className="itemmap">
                  {orders.items
                    .slice(0, isOpen[idx] ? orders.items.length : 1)
                    .map((ordersItems, itemIndex) => (
                      <div key={itemIndex} className="itme">
                        <div className="itme-img">
                          {/* <img src={ordersItems.repPic} alt="상품" /> */}
                          <img
                            // src={`/pic/product/${orders.iproduct}/${orders.repPic}`}
                            src={`${API_SERVER_HOST}/pic/product/${ordersItems.iproduct}/${ordersItems.repPic}`}
                            alt="상품"
                          />
                        </div>
                        <p className="itme-p">{ordersItems.productNm}</p>

                        {/* <ButtonContainer>
                          <OpenModalButton onClick={openModal}>
                            🥣
                          </OpenModalButton>
                          {modalOpen && <MealModal closeModal={closeModal} />}
                        </ButtonContainer> */}

                        {/* <p>이것은 {orders.iorder}</p> */}
                        <p>{ordersItems.productCnt}</p>
                        <p>{ordersItems.price}</p>
                        <p>{ordersItems.processState}</p>
                        <div className="refl">
                          <div className="itme-bt">
                            {ordersItems.reviewFl === 0 ? (
                              <button
                                className="orderButton"
                                onClick={() =>
                                  iorderNavi(
                                    `/reviewadd/${ordersItems.iproduct}/${ordersItems.idetails}/${orders.iorder}`,
                                  )
                                }
                              >
                                리뷰작성
                              </button>
                            ) : (
                              <div
                                className="itme-bt"
                                style={{ width: "100px" }}
                              >
                                {/* 빈 요소, 아무 내용이 없으므로 공백이나 다른 텍스트가 들어가도 좋습니다. */}
                              </div>
                            )}

                            {makeStateBt(
                              ordersItems,
                              orders.iorder,
                              orders.idetails,
                            )}
                          </div>
                        </div>
                      </div>
                    ))}
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
        <PagiWarp>
          <Pagination
            current={currentPage}
            onChange={handlePageChange}
            total={orderData.length}
            pageSize={itemsPerPage}
            className="pagination"
          />
        </PagiWarp>
      </div>
    </OrderViewStyle>
  );
};

export default OrderView;
