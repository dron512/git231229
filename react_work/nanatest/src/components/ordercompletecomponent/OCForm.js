import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getOCPage } from "../../api/orderapi/orderApi";
import useCustomLogin from "../../hooks/useCustomLogin";
import { OcPadding, OcWrap } from "../../styles/oc/ocstyle";
import OCInfo from "./OCInfo";
import OCMessage from "./OCMessage";
import OcDetail from "./OcDetail";

const initState = {
  iorder: "",
  totalProductCnt: "",
  products: [
    {
      productNm: "",
      productCnt: "",
      productTotalPrice: "",
      repPic: "",
    },
  ],
  addresseeNm: "",
  phoneNumber: "",
  zipCode: "",
  address: "",
  addressDetail: "",
  paymentOption: "",
  createdAt: "",
};

const OCForm = () => {
  const { isLogin, loginState } = useCustomLogin();
  const [data, setData] = useState(initState);
  const { iorder } = useParams();

  useEffect(() => {
    // console.log("iorder", iorder);
    const successFn = result => {
      setData(result);
      // console.log(result);
    };
    const failFn = result => {
      // console.log(result);
    };
    const errorFn = result => {
      // console.log("에러에옹", result);
    };

    getOCPage({ iorder, successFn, failFn, errorFn });
  }, []);

  return (
    <>
      {/* {isLogin ? ( */}
      <OcPadding>
        <OcWrap>
          <OCMessage data={data} />
          <OcDetail data={data} />
          <OCInfo data={data} />
        </OcWrap>
      </OcPadding>
      {/* ) : (
       "로그인을 해주세요."
       )} */}
    </>
  );
};

export default OCForm;
