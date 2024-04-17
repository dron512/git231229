import { ConfigProvider, Radio } from "antd";
import React, { useEffect, useState } from "react";
import {
  Detailadress,
  PostNum,
  Selectadress,
} from "../../styles/payment/paymentaddressstyle";
import { getAddress } from "../../api/address/AddressApi";

const PaymentAdress = ({ handleAddressChange }) => {
  const [serverDataAdd, setServerDataAdd] = useState([]);
  const [selectedadress, setSelectedadress] = useState(null);
  const [showPostNum, setShowPostNum] = useState("");
  const [showAddress, setShowAddress] = useState("");
  const [showDtAddress, setShowDtAddress] = useState("");

  // 배송지 칸에 선택된 값 업데이트와 동시에
  // 부모 컴포넌트로 값을 전달을 해 준다.
  const onRadioChange = e => {
    const selectedValue = e.target.value;
    const selectedAddress = serverDataAdd.find(
      address => address.iaddress === selectedValue,
    );

    if (selectedAddress) {
      setSelectedadress(selectedValue);
      setShowPostNum(selectedAddress.zipCode);
      setShowAddress(selectedAddress.address);
      setShowDtAddress(selectedAddress.addressDetail);
      handleAddressChange(selectedValue);
    }
  };

  useEffect(() => {
    try {
      getAddress({ successFn, failFn, errorFn });
    } catch (error) {
      // console.log("error");
    }
  }, []);
  const successFn = result => {
    setServerDataAdd(result);
    // console.log(result);
  };
  const failFn = result => {
    // console.log(result);
  };
  const errorFn = result => {
    // console.log(result);
  };
  return (
    <ConfigProvider
      theme={{
        components: {
          Radio: {
            // buttonStyle: "solid",
            colorPrimary: "#E9B25F",
          },
        },
      }}
    >
      <div className="deliveryadress">
        <div className="paymentListTitle">
          <p>배송지</p>
        </div>
        <PostNum className="postNum">
          <p>우편번호</p>
          <div className="postNumDiv">
            <i>{showPostNum}</i>
          </div>
          <i>
            *주문 후 배송지 수정이 어려울 수 있습니다. 확인 후 결제 진행
            부탁드립니다.
          </i>
        </PostNum>
        <Detailadress>
          <div>
            <p>{showAddress}</p>
          </div>
          <div>
            <p>{showDtAddress}</p>
          </div>
        </Detailadress>
        <Selectadress>
          <form>
            <div>
              <Radio.Group
                onChange={onRadioChange}
                value={selectedadress}
                style={{ flexDirection: "column" }}
              >
                {serverDataAdd.map(item => (
                  <Radio
                    key={item.iaddress}
                    value={item.iaddress}
                    style={{ marginRight: "0px", padding: 0 }}
                    className="custom-radio"
                  >
                    <div className="adressTextDiv">
                      <p>{`(${item.zipCode}) ${item.address} ${item.addressDetail}`}</p>
                    </div>
                  </Radio>
                ))}
              </Radio.Group>
            </div>
          </form>
        </Selectadress>
      </div>
    </ConfigProvider>
  );
};
export default PaymentAdress;
