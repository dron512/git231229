import React from "react";
import { UserInformBt } from "../../styles/userinfo/userinfobtstyle";

export const UserInfoBt = ({
  handleClickAddress,
  handleClickModify,
  productData,
}) => {
  return (
    <UserInformBt>
      <img
        src={process.env.PUBLIC_URL + "/assets/images/userInfo.svg"}
        style={{ marginLeft: "20px" }}
      />
      <div>
        <h2 style={{ marginRight: "80px" }}>
          저희 쇼핑몰을 이용해 주셔서 감사합니다 {productData.nm} 님은 [신입맘]
          회원이십니다.
        </h2>

        <h2>0원이상 구매시 1.5%을 추가적립 받으실 수 있습니다.</h2>
      </div>
      <div>
        <button
          style={{ backgroundColor: "#c5c5c5", marginRight: "20px" }}
          onClick={handleClickAddress}
        >
          주소정보 관리하기
        </button>
        <button
          style={{ marginRight: "30px" }}
          onClick={() => handleClickModify()}
        >
          회원정보 수정하기
        </button>
      </div>
    </UserInformBt>
  );
};

export default UserInfoBt;
