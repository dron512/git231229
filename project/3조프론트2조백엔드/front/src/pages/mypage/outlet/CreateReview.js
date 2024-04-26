import { ConfigProvider, Table } from "antd";
import React, { useState } from "react";
import { reviewData } from "../../../mock/CrtRvwData";
import { Common } from "../../../styles/CommonCss";
import { TableCustom } from "../../../styles/common/tableCss";
import RvModal from "../../../components/mypage/RvModal";
import { BasicBtR } from "../../../styles/basic/basicBt";

// const onChange = (pagination, filters, sorter, extra) => {
//   console.log("params", pagination, filters, sorter, extra);
// };
const CreateReview = () => {
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
      dataIndex: "name",
      render: () => (
        <img style={{ width: "80px" }} src="/images/moon.jpg" alt="리뷰 작성" />
      ),
    },
    {
      title: "제품명 | 주문번호",
      dataIndex: "test",
      render: () => (
        <div>
          <p>하여튼 주문명</p>
          <p>12121212-1212121</p>
        </div>
      ),
    },
    {
      title: "주문일자",
      dataIndex: "date",
    },
    {
      title: "매장명",
      dataIndex: "math",
    },
    {
      title: "주문방식",
      dataIndex: "order",
    },
    {
      title: "리뷰작성",
      button: <button>ddldldd</button>,
      render: () => <BasicBtR onClick={handleShowModal}>리뷰 작성</BasicBtR>,
    },
  ];
  return (
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
        dataSource={reviewData}
        pagination={false}
      />
      {showModal && <RvModal onClose={handleCloseModal} />}
    </ConfigProvider>
  );
};

export default CreateReview;
