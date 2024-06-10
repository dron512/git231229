import React, { useState } from "react";
import { BasicBtR } from "../../styles/basic/basicBt";
import { ConfigProvider } from "antd";
import { Common } from "../../styles/CommonCss";
import { TableCustom } from "../../styles/common/tableCss";
import { reviewData } from "../../mock/CrtRvwData";
import RvModal from "../mypage/RvModal";
import { OrderSTableData } from "../../mock/OrderTableData";

const OrderShipPage = () => {
  const [showModal, setShowModal] = useState(false);
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
      render: (text, record) => (
        <img
          style={{ width: "80px", height: "80px" }}
          src={record.pic}
          alt="리뷰 작성"
        />
      ),
    },
    {
      title: "제품명",
      dataIndex: "productNm",
    },
    {
      title: "배달장소",
      dataIndex: "address",
      render: (text, record) => (
        <div
          style={{
            width: "150px",
            wordWrap: "break-word",
            textAlign: "center",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <p>{record.address}</p>
        </div>
      ),
    },

    {
      title: "주문일자",
      dataIndex: "date",
    },
    {
      title: "매장명",
      dataIndex: "storeNm",
    },
    {
      title: "주문번호",
      dataIndex: "orderNumber",
    },
    {
      title: "주문방식",
      dataIndex: "order",
    },
    {
      title: "결제금액",
      dataIndex: "price",
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
          dataSource={OrderSTableData}
          pagination={false}
        />
      </ConfigProvider>
    </div>
  );
};

export default OrderShipPage;
