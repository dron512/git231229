import React from "react";
import { BorderLinemanager, BorderWrap } from "../../styles/oc/ocstyle";

const OCInfo = ({ data }) => {
  const dataObject = typeof data === "object" ? data : {};
  return (
    <BorderWrap>
      <div className="pageMargin">
        <div className="orderInfoTitle">
          <p>주문정보</p>
        </div>

        <BorderLinemanager>
          <thead>
            <tr>
              <td className="tableName">
                <p>주문자</p>
              </td>
              <td className="tableDesc">
                <p>{dataObject.addresseeNm}</p>
              </td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td className="tableName">
                <p>주문자 연락처</p>
              </td>
              <td className="tableDesc">
                <p>{dataObject.phoneNumber}</p>
              </td>
            </tr>
            <tr>
              <td className="tableName">
                <p>배송지</p>
              </td>
              <td className="tableDesc">
                <p>
                  [{dataObject.zipCode}] {dataObject.address}{" "}
                  {dataObject.addressDetail}{" "}
                </p>
              </td>
            </tr>
            <tr>
              <td className="tableName">
                <p>이메일</p>
              </td>
              <td className="tableDesc">
                <p>{dataObject.email}</p>
              </td>
            </tr>
            <tr className="noBorder">
              <td className="tableName">
                <p>결제수단</p>
              </td>
              <td className="tableDesc">
                <p>{dataObject.paymentOption}</p>
              </td>
            </tr>
          </tbody>
        </BorderLinemanager>
      </div>
    </BorderWrap>
  );
};

export default OCInfo;
