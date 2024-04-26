import React from "react";
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
    render: () => <button>리뷰 작성</button>,
  },
];
const MyMainPage = () => {
  return (
    <div>
      <div>dasdasd나는 마이페이지 메인이영</div>
    </div>
  );
};

export default MyMainPage;
