import { Button, Form } from "antd";
import React, { useEffect, useState } from "react";
import { Link, Outlet, useLocation } from "react-router-dom";
import styled from "styled-components";
import { deleteOne, putAdress } from "../../api/address/AddressApi";
import AddressDetailed from "../../components/address/AddressDeatail";
import useCustomLogin from "../../hooks/useCustomLogin";
import { AddressTitleWrap } from "../../styles/address/addressinfostyle";
import useCustomMove from "../../hooks/useCustomMove";
import ResultModal from "../../components/signup/ResultModal";

const AddressBtWrap = styled.div`
  display: flex;
  justify-content: space-between;
  width: 1157px;
  margin: 0 auto;
  border-top: 1px solid #868686;
  padding-top: 28px;
  margin-bottom: 282px;
  button {
    width: 203px;
    height: 70px;
    background: #e9b25f;
    color: #fff;
    font-size: 20px;
    font-weight: 500;
    border: none;
  }
`;

const AddressHeadWrap = styled.div`
  width: 1157px;
  height: 80px;
`;

const initState = {
  zonecode: "",
  address: "",
  addressDetail: "",
};

const AddressModify = () => {
  const location = useLocation();
  const item = location.state;

  const [serverData, setServerData] = useState(initState);
  const [zonecode, setZonecode] = useState(initState);
  const [address, setAddress] = useState(initState);

  const { loginState, moveToPath } = useCustomLogin();
  const { moveToPrev } = useCustomMove();
  useEffect(() => {
    setServerData({ ...loginState });
  }, [loginState]);

  const updateAddressInfo = ({ zonecode, address }) => {
    // 주소 정보 업데이트
    setZonecode(zonecode);
    setAddress(address);
  };

  const onFinish = values => {
    // console.log("values", values);
    setServerData({ ...values });
    values.address = address;
    values.zipCode = zonecode;
    // console.log("Success:", values);
    putAdress({ iaddress: item.iaddress, values, successFn, failFn, errorFn });
  };
  const onFinishFailed = errorInfo => {
    console.log("Failed:", errorInfo);
  };
  const successFn = result => {
    setModalStyle({});
    setModalStyleBk({});
    setResultTitle("수정 성공");
    setResultContent("주소수정에 성공하였습니다.");
    setReDirect(0);
  };
  const failFn = result => {
    setResultTitle("수정 실패");
    setResultContent("주소수정에 실패하였습니다");
    setReDirect(1);
  };
  const errorFn = result => {
    setModalStyle({ color: "red" });
    setModalStyleBk({ background: "red" });

    setResultTitle("수정 실패");
    setResultContent("서버에 오류가 있어 잠시후 재시도해주세요");
    setReDirect(1);
  };

  const handleClickRemove = () => {
    deleteOne({
      iaddress: item.iaddress,
      successFn: successFnDel,
      failFn: failFnDel,
      errorFn: errorFnDel,
    });
  };

  const PrevBt = () => {
    moveToPath("/address");
  };

  const [resultTitle, setResultTitle] = useState("");
  const [resultContent, setResultContent] = useState("");
  const [reDirect, setReDirect] = useState(0);
  const [modalStyle, setModalStyle] = useState({});
  const [modalStyleBk, setModalStyleBk] = useState({});

  const successFnDel = result => {
    setModalStyle({});
    setModalStyleBk({});
    setResultTitle("삭제 성공");
    setResultContent("주소삭제에 성공하였습니다.");
    setReDirect(0);
  };
  const failFnDel = result => {
    setResultTitle("삭제 실패");
    setResultContent("주소삭제에 실패하였습니다");
    setReDirect(1);
  };
  const errorFnDel = result => {
    setModalStyle({ color: "red" });
    setModalStyleBk({ background: "red" });

    setResultTitle("삭제 실패");
    setResultContent("서버에 오류가 있어 잠시후 재시도해주세요");
    setReDirect(1);
  };

  const closeModal = () => {
    // 팝업닫기
    setResultTitle("");
    setResultContent("");

    if (reDirect === 0) {
      // 목록가기
      // navigate(`/modify`);
      // console.log(serverResult);
      // moveToMain();
      moveToPath("/address");
    } else {
      // 팝업닫기
    }
  };

  return (
    <div>
      <AddressHeadWrap />
      {resultTitle && (
        <ResultModal
          title={resultTitle}
          content={resultContent}
          callFN={closeModal}
          errorbt={modalStyle}
          errorbk={modalStyleBk}
        />
      )}
      <AddressTitleWrap>
        <div>
          <h2>ADDRESS</h2>
        </div>
        <div>
          <p>
            주소 추가는 <span>최대 3개</span>까지만 가능합니다
          </p>
        </div>
      </AddressTitleWrap>
      <Form
        name="Address"
        initialValues={{
          remember: true,
          zipCode: serverData.zipCode,
          address: serverData.address,
          addressDetail: item.addressDetail,
        }}
        autoComplete="off"
        onFinish={onFinish}
        onFinishFailed={onFinishFailed}
      >
        <AddressDetailed onAddressChange={updateAddressInfo} item={item} />
        <AddressBtWrap>
          <div>
            <Form.Item>
              <Button
                type="primary"
                htmlType="button"
                onClick={() => PrevBt()}
                style={{
                  width: "203px",
                  height: "70px",
                  background: "#d9d9d9",
                  color: "#868686",
                  fontSize: "20px",
                  fontWeight: 500,
                  border: "none",
                }}
              >
                뒤로가기
              </Button>
            </Form.Item>
          </div>
          <div style={{ display: "flex", gap: "30px" }}>
            <Form.Item>
              <Button
                type="primary"
                htmlType="button"
                onClick={handleClickRemove}
                style={{
                  width: "203px",
                  height: "70px",
                  fontSize: "20px",
                  fontWeight: 500,
                  border: "1px solid #FF4E4E",
                  background: "#FFF",
                  color: "#FF4E4E",
                }}
              >
                주소 삭제하기
              </Button>
            </Form.Item>
            <Form.Item>
              <Button
                type="primary"
                htmlType="submit"
                style={{
                  width: "203px",
                  height: "70px",
                  background: "#e9b25f",
                  color: "#fff",
                  fontSize: "20px",
                  fontWeight: 500,
                  border: "none",
                }}
              >
                주소 수정하기
              </Button>
            </Form.Item>
          </div>
        </AddressBtWrap>
      </Form>
      <Outlet />
    </div>
  );
};
export default AddressModify;
