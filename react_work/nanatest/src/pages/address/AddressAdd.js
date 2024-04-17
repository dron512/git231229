import { Button, Form } from "antd";
import React, { useState } from "react";
import styled from "styled-components";
import { postAddress } from "../../api/address/AddressApi";
import AddressDetailed from "../../components/address/AddressDeatail";
import useCustomLogin from "../../hooks/useCustomLogin";
import { AddressTitleWrap } from "../../styles/address/addressinfostyle";
import { Outlet } from "react-router";
import BasicLayout from "../../layouts/BasicLayout";
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

const initState = {
  zonecode: "",
  address: "",
  addressDetail: "",
};

const AddressAdd = () => {
  const [serverData, setServerData] = useState(initState);
  const [zonecode, setZonecode] = useState(initState);
  const [address, setAddress] = useState(initState);

  const updateAddressInfo = ({ zonecode, address }) => {
    // 주소 정보 업데이트
    setZonecode(zonecode);
    setAddress(address);
  };

  const { moveToPath } = useCustomLogin();
  const { moveToPrev } = useCustomMove();
  const onFinish = values => {
    setServerData({ ...values });
    values.address = address;
    values.zipCode = zonecode;
    // console.log("Success:", values);
    postAddress({ values, successFn, failFn, errorFn });
  };
  const onFinishFailed = errorInfo => {
    // console.log("Failed:", errorInfo);
  };

  const [resultTitle, setResultTitle] = useState("");
  const [resultContent, setResultContent] = useState("");
  const [reDirect, setReDirect] = useState(0);
  const [modalStyle, setModalStyle] = useState({});
  const [modalStyleBk, setModalStyleBk] = useState({});

  const successFn = result => {
    setModalStyle({});
    setModalStyleBk({});
    setResultTitle("추가 성공");
    setResultContent("주소추가에 성공하였습니다.");
    setReDirect(0);
  };
  const failFn = result => {
    setResultTitle("추가 실패");
    setResultContent("주소추가에 실패하였습니다");
    setReDirect(1);
  };
  const errorFn = result => {
    setModalStyle({ color: "red" });
    setModalStyleBk({ background: "red" });

    setResultTitle("추가 실패");
    setResultContent("주소는 최대3개만 추가할수있습니다");
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

  const PrevBt = () => {
    moveToPrev();
  };
  return (
    <div>
      <AddressTitleWrap>
        {resultTitle && (
          <ResultModal
            title={resultTitle}
            content={resultContent}
            callFN={closeModal}
            errorbt={modalStyle}
            errorbk={modalStyleBk}
          />
        )}
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
          addressDetail: serverData.addressDetail,
        }}
        autoComplete="off"
        onFinish={onFinish}
        onFinishFailed={onFinishFailed}
      >
        <AddressDetailed onAddressChange={updateAddressInfo} />
        <AddressBtWrap>
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
              주소 추가하기
            </Button>
          </Form.Item>
        </AddressBtWrap>
      </Form>
      <Outlet />
    </div>
  );
};
export default AddressAdd;
