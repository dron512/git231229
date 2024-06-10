import React, { useEffect, useState } from "react";
import MyPageContent from "../../styles/mypage/MyPage";
import { SERVER_URL } from "../../api/config";
import jwtAxios from "../../util/jwtUtil";
import { buttonPrimaryStyle } from "../../styles/sign/signArea";
import Address from "../../components/singup/Address";
import { Button, Form, Input, Select } from "antd";
import { Common } from "../../styles/CommonCss";
import { Link, useNavigate } from "react-router-dom";
import Swal from 'sweetalert2/dist/sweetalert2.js'
import 'sweetalert2/src/sweetalert2.scss'



const MyMainPage = () => {
  const [email, setEmail] = useState();
  const [phone, setPhone] = useState();
  const [nickname, setNickname] = useState();

  const [address, setAddress] = useState("");
  const [address2, setAddress2] = useState("");

  const navigate = useNavigate();

  useEffect(()=>{
    const fetchData = async()=>{
      jwtAxios.get(`${SERVER_URL}/user/info`)
      .then(result=>{
        setEmail(result.data.email);
        setPhone(result.data.phone);
        setNickname(result.data.nickname);
        setAddress(result.data.address);
        setAddress2(result.data.address2);
      })
      .catch(e=>{
        Swal.fire(
          // {
          //   title: "회원수정",
          //   text: "<p style='font-size:5rem;margin:1rem;'>회원 수정 되었습니다.</p>",
          //   icon: "info"
          // }
          {
          title:"<p style='font-size:4rem;margin:1rem;'>로그인하세요</p>",
          icon: "info",
          width: 600,
          confirmButtonText: `<span style="display:bolck;font-size:4rem;width:200px;padding:1rem;">확인</span>`,
          confirmButtonColor: `${Common.color.f900}`,
        }).then(function(){
          navigate('/sign/in');
        });
      });
    }
    fetchData();
  },[]);

  const doSubmit = () => {
    jwtAxios.put(`${SERVER_URL}/user/updateUser`, {
      "nickname": nickname,
      "phone": phone,
      "address": address,
      "address2": address2
    }).then(data => {
      console.log(data);
      Swal.fire(
        {
        title:"<p style='font-size:4rem;margin:1rem;'>회원 수정 되었습니다.</p>",
        icon: "info",
        width: 600,
        confirmButtonText: `<span style="display:bolck;font-size:4rem;width:200px;padding:1rem;">확인</span>`,
        confirmButtonColor: `${Common.color.f900}`,
      }
    );
    }).catch(e => {
      console.log(e);
    });
  }

  const updateAddressInfo = ({ zonecode, address }) => {
    // 주소 정보 업데이트
    // setZonecode(zonecode);
    setAddress(address);
  };

  return (address) &&(
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
              style={{ height: 60, fontSize: "20px", width: "49%" }}
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
