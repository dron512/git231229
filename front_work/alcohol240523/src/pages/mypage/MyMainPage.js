import React, { useState } from "react";
import MyPageContent from "../../styles/mypage/MyPage";
import { SERVER_URL } from "../../api/config";
import jwtAxios from "../../util/jwtUtil";
import { buttonPrimaryStyle } from "../../styles/sign/signArea";
import Address from "../../components/singup/Address";
import { Button, Form, Input, Select } from "antd";
import { Common } from "../../styles/CommonCss";
import { Link } from "react-router-dom";


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

  const [email, setEmail] = useState();
  const [phone, setPhone] = useState();
  const [nickname, setNickname] = useState();

  const [address, setAddress] = useState("");
  const [address2, setAddress2] = useState("");


  const updateAddressInfo = ({ zonecode, address }) => {
    // 주소 정보 업데이트
    // setZonecode(zonecode);
    setAddress(address);
  };

  return (
    <div style={{ width: '100%' }}>
      <Form name="mypage_update">
        <MyPageContent>내 정보관리</MyPageContent>
        <hr />
        <div style={{ margin: '2rem', width: '100%' }}>
          <h2 style={{ padding: '0.7rem', fontSize: '2rem' }}>필수 정보</h2>
          <div style={{ display: 'flex', flexDirection: 'column' }}>
            <div style={{ width: '100%' }}>
              <Form.Item>
                <Input placeholder='email'
                  disabled
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }} value={email} onChange={(e) => setEmail(e.target.value)} />
              </Form.Item>
              <Form.Item>
                <Input placeholder='phone'
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }}
                  value={phone}
                  onChange={(e) => setPhone(e.target.value)} />
              </Form.Item>
            </div>
            <div style={{ flexGrow: 1 }}>
              <Form.Item>
                <Input placeholder='nickname'
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }}
                  value={nickname}
                  onChange={(e) => setNickname(e.target.value)} />
              </Form.Item>
            </div>
          </div>
        </div>
        <hr style={{ marginBottom: "2rem" }}></hr>
        <div style={{ padding: "2rem" }}>
          <Address onAddressChange={updateAddressInfo} address={address} />
          <Form.Item>
            <Input
              style={{ height: 60, fontSize: "20px", width: "50%" }}
              onChange={e => setAddress2(e.target.value)}
              value={address2}
              placeholder="상세주소"
            />
          </Form.Item>
        </div>
        <Button onClick={doSubmit}
          type="primary"
          style={{
            background: `${Common.color.f900}`,
            width: "50%",
            height: "60px",
            fontSize: "20px",
          }}>회원수정</Button>
      </Form>
      <div style={{marginTop:"2rem"}}>
        <Link to='/mypage/signout' style={{fontSize:"2rem"}}>회원탈퇴</Link>
      </div>
    </div>
  );
};

export default MyMainPage;
