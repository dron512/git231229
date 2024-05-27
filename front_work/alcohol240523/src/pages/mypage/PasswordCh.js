import React, { useState } from "react";
import MyPageContent from "../../styles/mypage/MyPage";
import { SERVER_URL } from "../../api/config";
import jwtAxios from "../../util/jwtUtil";
import { buttonPrimaryStyle } from "../../styles/sign/signArea";
import Address from "../../components/singup/Address";
import { Button, Form, Input, Select } from "antd";
import { Common } from "../../styles/CommonCss";


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

const doSubmit = () => {
  jwtAxios.put(`${SERVER_URL}/user/update`, {
    "nickname": "dfff",
    "password": "a123456!",
    "phone": "01056215621",
    "address": "주소",
    "address2": "상세주소"
  }).then(data => {
    console.log(data);
  }).catch(e => {
    console.log(e);
  });
}

const MyMainPage = () => {

  const [oldPw, setOldPw] = useState();
  const [newPw, setNewPw] = useState();
  const [newPwCon, setNewPwCon] = useState();

  return (
    <div style={{ width: '100%' }}>
      <Form name="mypage_update">
        <MyPageContent>비밀번호수정</MyPageContent>
        <hr />
        <div style={{ margin: '2rem', width: '100%' }}>
          <h2 style={{ padding: '0.7rem', fontSize: '2rem' }}>필수 정보</h2>
          <div style={{ display: 'flex', flexDirection: 'column' }}>
            <div style={{ width: '100%' }}>
              <Form.Item>
                <Input placeholder='현재비밀번호'
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }} value={oldPw} onChange={(e) => setOldPw(e.target.value)} />
              </Form.Item>
              <Form.Item>
                <Input placeholder='새로운비밀번호'
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }}
                  value={newPw}
                  onChange={(e) => setNewPw(e.target.value)} />
              </Form.Item>
            </div>
            <div style={{ flexGrow: 1 }}>
              <Form.Item>
                <Input placeholder='새로운비밀번호확인'
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }}
                  value={newPwCon}
                  onChange={(e) => setNewPwCon(e.target.value)} />
              </Form.Item>
            </div>
          </div>
        </div>
        <Button onClick={doSubmit}
          type="primary"
          style={{
            background: `${Common.color.f900}`,
            width: "50%",
            height: "60px",
            fontSize: "20px",
          }}>비밀번호수정</Button>
      </Form>
    </div>
  );
};

export default MyMainPage;
