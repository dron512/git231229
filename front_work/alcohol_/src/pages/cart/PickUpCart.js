import { ConfigProvider } from "antd";
import React, { useState } from "react";
import { TableCustom } from "../../styles/common/tableCss";
import { PCartData } from "../../mock/CartData";
import { Common } from "../../styles/CommonCss";
import { BasicBtR } from "../../styles/basic/basicBt";
import Count from "../../components/basic/Count";

const PickUpCart = () => {
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
          columns={columns}
          dataSource={PCartData}
          pagination={false}
        />
        {/* {showModal && <RvModal onClose={handleCloseModal} />} */}
      </ConfigProvider>
    </div>
  );
};

export default PickUpCart;
