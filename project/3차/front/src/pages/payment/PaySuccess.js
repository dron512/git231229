import React from "react";
import { ProListWrap } from "../../styles/product/proWrapCss";
import { HeaderNavWrap } from "../../styles/product/proNavCss";
import { P13, P16, PB20, PB30 } from "../../styles/basic";
import {
  DetailBigKeyword,
  InfoTable,
  LineP500,
  PayCenter,
  PayTitleCenter,
  PayUserInfo,
  WrapMargin250,
} from "../../styles/payment/payComCss";
import {
  MarginB10,
  MarginB20,
  MarginB40,
} from "../../styles/common/reviewProductCss";
import { Common } from "../../styles/CommonCss";

const PayComplet = () => {
  return (
    <div>
      <WrapMargin250>
        <ProListWrap>
          <PayTitleCenter>
            <img src={process.env.PUBLIC_URL + "/images/payComicon.svg"} />
            <MarginB40 />
            <PB30>결제가 완료되었습니다!</PB30>
            <P16 style={{ color: `${Common.color.p400}` }}>
              아래에서 상세 결제 내역을 확인할 수 있습니다.
            </P16>
          </PayTitleCenter>
          <MarginB40 />
          <div style={{ borderBottom: `2px solid ${Common.color.p900}` }}>
            <PB20 style={{ color: `${Common.color.f900}` }}>결제 요약정보</PB20>
            <MarginB10 />
          </div>

          <PayUserInfo>
            {/* <LineP500 /> */}
            <PB20>구매자 정보</PB20>
          </PayUserInfo>

          <DetailBigKeyword>
            <div className="left">
              <P16>닉네임</P16>
            </div>
            <div className="right">
              <P16>하찮은 고라니</P16>
            </div>
            <div
              className="left"
              style={{ borderLeft: `1px solid ${Common.color.p400}` }}
            >
              <P16>전화번호</P16>
            </div>
            <div className="right">
              <P16>010-1234-1234</P16>
            </div>
          </DetailBigKeyword>

          {/* 결제주문------------------------------------------------------------------------- */}
          <PayUserInfo>
            <MarginB40 />

            <PB20>결제/주문 요약정보</PB20>
          </PayUserInfo>
          <DetailBigKeyword>
            <div className="left" style={{ width: "88px" }}>
              <P16>구매처</P16>
            </div>
            <div className="right">
              <P16>그린고라니샵</P16>
            </div>
          </DetailBigKeyword>
          <DetailBigKeyword>
            <div className="left" style={{ width: "88px" }}>
              <P16>주문제품</P16>
            </div>
            <div className="right">
              <P16>
                나는 술을 좋아하는 고라니 1set, 아무도 말릴 수 없는 고라니주
                1set 외 3
              </P16>
            </div>
          </DetailBigKeyword>
          <DetailBigKeyword>
            <div className="left" style={{ width: "88px" }}>
              <P16>주소지</P16>
            </div>
            <div className="right">
              <P16>[12345] 대구 중구 달성로 123 그린아파트 101동 404호</P16>
            </div>
          </DetailBigKeyword>

          <DetailBigKeyword>
            <div className="left">
              <P16>결제수단</P16>
            </div>
            <div className="right">
              <P16>토스뱅크</P16>
            </div>
            <div
              className="left"
              style={{ borderLeft: `1px solid ${Common.color.p400}` }}
            >
              <P16>결제금액</P16>
            </div>
            <div className="right">
              <P16>180,000원</P16>
            </div>
          </DetailBigKeyword>
        </ProListWrap>
      </WrapMargin250>
    </div>
  );
};

export default PayComplet;
