import { ConfigProvider } from "antd";
import React, { useState } from "react";
import { useNavigate } from "react-router";
import { useRecoilState } from "recoil";
import { Common } from "../../styles/CommonCss";
import { PB20 } from "../../styles/basic";
import { TotalPayWrap, TotalTh } from "../../styles/cart/CartTableCss";
import { BigButton, SButton } from "../../styles/common/reviewProductCss";
import { TableCustom } from "../../styles/common/tableCss";
import { cartCountState } from "../../atom/CountState";

const PickUpCart = ({ pickupData }) => {
  const navigate = useNavigate();
  const [cartCount, setCartCount] = useRecoilState(cartCountState);
  const [showModal, setShowModal] = useState(false);
  // const [count, setCount] = useState(1);
  console.log("cart-component : ", pickupData);
  const handleCloseModal = () => {
    setShowModal(false);
  };
  const handleShowModal = () => {
    setShowModal(true);
  };

  const calculatePaymentAmount = (price, amount) => {
    return (price * amount).toLocaleString(); // 콤마를 추가하여 반환합니다.
  };

  const totalOrderAmount = pickupData => {
    let total = 0;
    pickupData.forEach(item => {
      total += item.price * item.amount;
    });
    return total;
  };
  console.log("토탈", totalOrderAmount);

  const columnsH = [
    {
      title: "",
      dataIndex: "key",
    },
    {
      title: "이미지",
      dataIndex: "pic",
      render: () => (
        <img style={{ width: "80px" }} src="/images/moon.jpg" alt="리뷰 작성" />
      ),
    },
    {
      title: "상품정보",
      dataIndex: "name",
    },
    {
      title: "매장",
      dataIndex: "marketname",
    },
    {
      title: "수량",
      dataIndex: "amount",
      render: (text, record) => (
        <div style={{ display: "flex", justifyContent: "center" }}>
          {record.amount}
          {/* <CountKey id={record.key} count={record.amount} /> */}
          {/* {console.log("record.key:", record.key)} */}
          {/* {console.log("record.count:", record.count)} */}
        </div>
      ),
    },
    {
      title: "결제금액",
      dataIndex: "price",
      render: (_, record) => (
        <div style={{ display: "flex", justifyContent: "center" }}>
          {/* {calculatePaymentAmount(record.price, cartCount[record.key])} 원 */}
          {record.price.toLocaleString()}원
        </div>
      ),
    },
    {
      title: "삭제",
      render: (_, record) => (
        <div>
          <SButton>삭제</SButton>
        </div>
      ),
    },
  ];

  return (
    <div>
      <ConfigProvider
        theme={{
          token: {
            colorPrimary: Common.color.p900,
          },
          components: {
            Table: {
              headerBg: "none",
              headerColor: Common.color.p500,
            },
          },
        }}
      >
        <TableCustom
          // rowSelection={rowSelection}
          columns={columnsH}
          dataSource={pickupData}
          pagination={false}
        />
        {/* {showModal && <RvModal onClose={handleCloseModal} />} */}
      </ConfigProvider>
      <div
        style={{
          width: "100%",
          height: "1px",
          background: `${Common.color.p900}`,
        }}
      ></div>
      <TotalPayWrap>
        <TotalTh>
          <PB20>결제금액</PB20>
          <PB20>배송비</PB20>
          <PB20></PB20>
          <PB20>예상결제금액</PB20>
        </TotalTh>
        <TotalTh>
          <PB20>{totalOrderAmount(pickupData).toLocaleString()} 원</PB20>

          <PB20>0원</PB20>
          <PB20>=</PB20>
          <PB20>{totalOrderAmount(pickupData).toLocaleString()} 원</PB20>
        </TotalTh>
      </TotalPayWrap>
      <div
        style={{
          position: "relative",
          display: "flex",
          justifyContent: "center",
          marginTop: "50px",
        }}
      >
        <BigButton
          style={{
            background: `${Common.color.b900}`,
            color: ` ${Common.color.p000}`,
            border: "none",
            fontSize: "16px",
            fontWeight: "normal",
          }}
          onClick={() => navigate(`/paycom`)}
        >
          주문하기
        </BigButton>
      </div>
    </div>
  );
};

export default PickUpCart;
