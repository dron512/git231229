import React from "react";
import {
  OCMDesc,
  OCMDiv,
  OCMText,
  OCMWrap,
  OCMtd,
} from "../../styles/oc/ocstyle";

const OCMessage = ({ data }) => {
  const dataObject = typeof data === "object" ? data : {};
  return (
    <OCMWrap>
      <OCMDiv>
        <div>
          <img src={process.env.PUBLIC_URL + "/assets/images/occheck.svg"} />
        </div>
        <OCMtd>
          <OCMText>
            <p>주문이 완료되었습니다!</p>
            <span>
              주문 내역 및 배송에 관한 안내는 주문조회를 통하여 확인 가능합니다.
            </span>
          </OCMText>

          <OCMDesc>
            <p>주문번호 : {dataObject.iorder}</p>
            <p>주문일자 : {dataObject.createdAt}</p>
          </OCMDesc>
        </OCMtd>
      </OCMDiv>
    </OCMWrap>
  );
};

export default OCMessage;
