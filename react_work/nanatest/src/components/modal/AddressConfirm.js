import React from "react";
import {
  AddressBtWrap,
  AddressWrap,
} from "../../styles/address/addressconfirmstyle";

const AddressConfirm = () => {
  return (
    <AddressWrap>
      <h2>주소를 삭제하시겠습니까?</h2>
      <AddressBtWrap>
        <button style={{ background: "#F24747", color: "#FFF" }}>네</button>
        <button style={{ background: "#ededed", color: "#868686" }}>
          아니오
        </button>
      </AddressBtWrap>
    </AddressWrap>
  );
};

export default AddressConfirm;
