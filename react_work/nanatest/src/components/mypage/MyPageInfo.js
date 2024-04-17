import React from "react";
import { InfoMain } from "../../styles/mypage/mypagestyle";

const MyPageInfo = ({ productData }) => {
  return (
    <div>
      <InfoMain>
        <div>
          입금전
          <h2>{productData.beforeDeposit}</h2>
        </div>
        <div>
          배송준비중
          <h2>{productData.preparation}</h2>
        </div>
        <div>
          배송중
          <h2>{productData.shipping}</h2>
        </div>
        <div>
          배송완료
          <h2>{productData.completed}</h2>
        </div>
      </InfoMain>
    </div>
  );
};

export default MyPageInfo;
