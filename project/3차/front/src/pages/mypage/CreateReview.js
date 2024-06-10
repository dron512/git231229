import { ConfigProvider } from "antd";
import React, { useEffect, useState } from "react";
import { getReviewcheck } from "../../api/reviewApi";
import RvModal from "../../components/mypage/RvModal";
import { Common } from "../../styles/CommonCss";
import { BasicBtR } from "../../styles/basic/basicBt";
import { TableCustom } from "../../styles/common/tableCss";

// const onChange = (pagination, filters, sorter, extra) => {
//   console.log("params", pagination, filters, sorter, extra);
// };
const initState = [
  {
    code: 3,
    name: "조니워커 블랙 700ml",
    purchaseday: "2024-05-02",
    marketname: "포도대구동성로점",
    delivery: "PickUp",
    picture: "",
  },
];
const CreateReview = () => {
  const [showModal, setShowModal] = useState(false);
  const [reviewListData, setReviewListData] = useState(initState);
  const [modalKey, setModalKey] = useState();
  const handleCloseModal = () => {
    setShowModal(false);
  };
  const handleShowModal = code => {
    setShowModal(true);
    setModalKey(code);
    console.log("모달로 전달되는 코드 값:", code);
  };

  useEffect(() => {
    getReviewcheck({
      successFn: data => {
        setReviewListData(data);
      },
      failFn: data => {
        alert("실패");
      },
      errorFn: data => {
        alert("서버상태 불안정 다음에 시도");
      },
    });
  }, []);

  const columns = [
    {
      title: "이미지",
      dataIndex: "name",
      render: (text, record) => (
        <img style={{ width: "80px" }} src={record.picture} alt="리뷰 작성" />
      ),
    },
    {
      title: "제품명 | 주문번호",
      dataIndex: "test",
      render: (text, record) => (
        <div>
          <p>{record.name}</p>
        </div>
      ),
    },
    {
      title: "주문일자",
      dataIndex: "purchaseday",
    },
    {
      title: "매장명",
      dataIndex: "marketname",
    },
    {
      title: "주문방식",
      dataIndex: "delivery",
    },
    {
      title: "리뷰작성",
      button: <button>ddldldd</button>,
      render: (text, record, index) => (
        <BasicBtR onClick={() => handleShowModal(index)}>
          리뷰 작성
        </BasicBtR>
      ),
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
        columns={columns}
        dataSource={reviewListData}
        pagination={false}
      />
      {showModal && (
        <RvModal 
        onClose={handleCloseModal} 
        code={reviewListData[modalKey]} />
      )}
    </ConfigProvider>
  );
};

export default CreateReview;
