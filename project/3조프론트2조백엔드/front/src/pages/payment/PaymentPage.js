import { ConfigProvider, Form, Input } from "antd";
import React, { useState } from "react";
import { TableCustom } from "../../styles/common/tableCss";
import { Common } from "../../styles/CommonCss";
import { PCartData } from "../../mock/CartData";
import Count from "../../components/basic/Count";
import {
  PayHeader,
  PayHeaderR,
  PayWrap,
} from "../../styles/payment/payPageCss";
import { PB20 } from "../../styles/basic";
import { MarginB20 } from "../../styles/common/reviewProductCss";

const PaymentPage = () => {
  const [showModal, setShowModal] = useState(false);
  const [count, setCount] = useState(1);
  const handleCloseModal = () => {
    setShowModal(false);
  };
  const handleShowModal = () => {
    setShowModal(true);
  };

  const columns = [
    {
      title: "이미지",
      dataIndex: "pic",
      render: () => (
        <img style={{ width: "80px" }} src="/images/moon.jpg" alt="리뷰 작성" />
      ),
    },
    {
      title: "상품정보",
      dataIndex: "info",
    },
    {
      title: "수량",
      dataIndex: "count",
      render: () => (
        <div style={{ display: "flex", justifyContent: "center" }}>
          <Count name="productCnt" setCount={setCount} count={count} />
          {/* 수량 카운트 컴포넌트를 이동한 위치 */}
        </div>
      ),
    },
    {
      title: "결제금액",
      dataIndex: "price",
    },
    {
      title: "삭제",
      render: () => <button>삭제</button>,
    },
  ];

  return (
    <PayWrap>
      <PB20>결제하기</PB20>
      <MarginB20 />
      <PayHeader>
        <div style={{ width: "600" }}>
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
              columns={columns}
              dataSource={PCartData}
              pagination={false}
            />
            {/* {showModal && <RvModal onClose={handleCloseModal} />} */}
          </ConfigProvider>
        </div>
        <PayHeaderR>
          <input type="text"></input>
        </PayHeaderR>
      </PayHeader>
    </PayWrap>
  );
};

export default PaymentPage;
