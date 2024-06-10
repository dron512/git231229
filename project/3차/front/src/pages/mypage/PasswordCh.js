import React, { useState } from "react";
import MyPageContent from "../../styles/mypage/MyPage";
import { SERVER_URL } from "../../api/config";
import jwtAxios from "../../util/jwtUtil";
import { buttonPrimaryStyle } from "../../styles/sign/signArea";
import Address from "../../components/singup/Address";
import { Button, Form, Input, Select } from "antd";
import { Common } from "../../styles/CommonCss";
import { json, useNavigate } from 'react-router-dom';
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { atomSignState } from "../../atom/loginState";
import { removeCookie } from "../../util/cookieUtil";
import { useResetRecoilState } from "recoil";

const MyMainPage = () => {

  const [password, setPassword] = useState();
  const [newPassword, setNewPassword] = useState();
  const [passwordch, setPasswordch] = useState();

  const navigate = useNavigate();
  const resetSignState = useResetRecoilState(atomSignState);


  const doSubmit = () => {
    jwtAxios.put(`${SERVER_URL}/user/updatePw`, {
      password,
      newPassword,
      passwordch
    }).then(data => {
      if (data.data === '비밀번호 수정이 완료되었습니다.') {
        Swal.fire(
          {
          title:"<p style='font-size:4rem;margin:1rem;'>비밀번호 변경되었습니다.</p>",
          icon: "info",
          width: 600,
          confirmButtonText: `<span style="display:bolck;font-size:4rem;width:200px;padding:1rem;">확인</span>`,
          confirmButtonColor: `${Common.color.f900}`,
        });
        removeCookie("member");
        resetSignState();
        navigate('/sign/in');
      }
    }).catch(e => {
      console.log(e);
      Swal.fire(
        {
        title:`<p style='font-size:4rem;margin:1rem;'>
        비밀번호 변경실패!!
        <br>
        ${e.response.errorMessage}
        </p>`,
        icon: "warning",
        width: 600,
        confirmButtonText: `<span style="display:bolck;font-size:4rem;width:200px;padding:1rem;">확인</span>`,
        confirmButtonColor: `${Common.color.f900}`,
      });
    });
  }

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
                // type="password"
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }} value={password} onChange={(e) => setPassword(e.target.value)} />
              </Form.Item>
              <Form.Item>
                <Input placeholder='새로운비밀번호'
                // type="password"
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }}
                  value={newPassword}
                  onChange={(e) => setNewPassword(e.target.value)} />
              </Form.Item>
            </div>
            <div style={{ flexGrow: 1 }}>
              <Form.Item>
                <Input placeholder='새로운비밀번호확인'
                // type="password"
                  style={{
                    width: '40%', fontSize: '2rem',
                    padding: '1rem', margin: '0.5rem'
                  }}
                  value={passwordch}
                  onChange={(e) => setPasswordch(e.target.value)} />
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
