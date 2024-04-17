import React, { useEffect, useState } from "react";
import useCustomLogin from "../../hooks/useCustomLogin";
import {
  AddressBtWrap,
  AddressInfoList,
  AddressInfoWrap,
  AddressTitleWrap,
} from "../../styles/address/addressinfostyle";
import { getAddress } from "../../api/address/AddressApi";
import { Button, Form } from "antd";
import { Outlet } from "react-router-dom";
import ResultModal from "../../components/signup/ResultModal";

const initState = {
  iaddress: [],
  zipcode: "",
  address: "",
  addressDetail: "",
};

export const AddressInfo = () => {
  const { moveToPath, moveToObj } = useCustomLogin();

  const handleClickAdd = e => {
    moveToPath("/address/add");
  };

  const handleClickModify = item => {
    moveToObj(`/address/modify`, item);
    // console.log(item.address, "address");
  };

  const [serverData, setServerData] = useState([]);
  const [resultTitle, setResultTitle] = useState("");
  const [resultContent, setResultContent] = useState("");
  const [reDirect, setReDirect] = useState(0);
  const [modalStyle, setModalStyle] = useState({});
  const [modalStyleBk, setModalStyleBk] = useState({});

  useEffect(() => {
    getAddress({ successFn, failFn, errorFn });
  }, []);

  const successFn = result => {
    setServerData(result);
    // console.log(result);
  };
  const failFn = result => {
    // console.log(result);
  };
  const errorFn = result => {
    // console.log(result);
  };

  return (
    <>
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

      {serverData.map(item => (
        <div key={item.iaddress}>
          <AddressInfoList>
            <AddressInfoWrap>
              <h2>
                ({item.zipCode}) {item.address} {item.addressDetail}
              </h2>

              <button onClick={() => handleClickModify(item)}>
                주소 수정/삭제
              </button>
            </AddressInfoWrap>
          </AddressInfoList>
        </div>
      ))}

      <AddressBtWrap>
        <Form.Item>
          <Button
            type="primary"
            htmlType="button"
            onClick={handleClickAdd}
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
    </>
  );
};

export default AddressInfo;
