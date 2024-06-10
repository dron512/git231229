import { ConfigProvider, Table } from "antd";
import React, { useEffect, useState } from "react";
import { Common } from "../../styles/CommonCss";
import { TableCustom } from "../../styles/common/tableCss";
import RvModal, { RvDelete } from "../../components/mypage/RvModal";
import { StarRev } from "../../styles/common/StarCss";
import { getReviewList } from "../../api/reviewApi";
import { BasicBtR } from "../../styles/basic/basicBt";

const onChange = (pagination, filters, sorter, extra) => {
  console.log("params", pagination, filters, sorter, extra);
};

const initState = [
  {
    name: "더 페이머스 그라우스 700ml",
    writing: "져라ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ",
    grade: 4,
    picture: "",
  },
];
const MyReview = () => {
  const [myReviewData, setmyReviewData] = useState(initState);

  const [showModal, setShowModal] = useState(false);
  const [modalKey, setModalKey] = useState();

  const handleCloseModal = () => {
    setShowModal(false);
  };
  const handleShowModal = index => {
    setShowModal(true);
    setModalKey(index);
  };
  
  useEffect(() => {
    getReviewList({
      successFn: data => {
        setmyReviewData(data);
      },
      failFn: data => {
        alert("most 실패");
      },
      errorFn: data => {
        alert("서버상태 불안정 다음에 시도");
      },
    });
  }, []);

  const fetchData = () => {
    getReviewList({
      successFn: data => {
        setmyReviewData(data);
      },
      failFn: data => {
        alert("most 실패");
      },
      errorFn: data => {
        alert("서버상태 불안정 다음에 시도");
      },
    });
  };

  const columns = [
    {
      title: "이미지",
      dataIndex: "name",
      render: (text, record) => (
        <div>
          <img
            style={{ width: "80px", marginBottom: "10px" }}
            src={process.env.PUBLIC_URL + record.picture}
            alt="리뷰 작성"
          />
          <StarRev>
            {Array.from({ length: record.grade }, (_, index) => (
              <img
                key={index}
                src={process.env.PUBLIC_URL + "/images/star.png"}
                alt="star"
              />
            ))}
          </StarRev>
        </div>
      ),
    },
    {
      title: "제품명",
      dataIndex: "productNm",
      render: (text, record) => (
        <div>
          <p>{record.name}</p>
        </div>
      ),
    },
    {
      title: "내용",
      dataIndex: "content",
      render: (text, record,index) => (
        <div
          style={{
            width: "600px",
            wordWrap: "break-word",
            textAlign: "center",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <p>{record.writing}</p>
        </div>
      ),
    },
    {
      title: "리뷰삭제",
      button: <button>ddldldd</button>,
      render: (text, record, index) => (
        <BasicBtR onClick={() => handleShowModal(index)}>리뷰 삭제</BasicBtR>
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
        // rowSelection={rowSelection}
        columns={columns}
        dataSource={myReviewData}
        pagination={false}
      />
      {showModal && (
        <RvDelete
          onClose={handleCloseModal}
          code={myReviewData[modalKey]}
          refreshData={fetchData}
        />
      )}
    </ConfigProvider>
  );
};

export default MyReview;
