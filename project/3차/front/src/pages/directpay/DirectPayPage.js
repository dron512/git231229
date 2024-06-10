import BasicLayout from "../../layout/BasicLayout";
import { useLocation } from "react-router-dom";
import { LoginBt } from "../../styles/login/loginCss";

const DirectPayPage = () => {
  const location = useLocation();
  const { info } = location.state || {};
  return (
    <BasicLayout>
      <div className="pay">
        <div className="payline1"></div>
        <div className="buyinfo">
          <h1 className="userinfo">주문정보</h1>
          <h1 className="product-info">상품정보</h1>
          <h2 className="product-name">상품명</h2>
          <h2 className="product-count">수량</h2>
          <h2 className="product-price">결제금액</h2>
          <h2 className="product-market">선택매장</h2>
          <h2 className="product-way">구매방식</h2>
        </div>
        <div className="payline2"></div>
        <div className="info">
          <div className="user">
            <h2>구매자 : {info.nickname}</h2>
            <h2>휴대폰번호 : {info.phone}</h2>
            <h2>배송지 : {info.address}</h2>
            <h2>이메일 : {info.email}</h2>
          </div>
          <div className="product">
            <div className="product-map">
              <img
                className="product-info"
                style={{ width: "100px", height: "100px" }}
                src="/images/alcohol/02.jpg"
                alt="이미지"
              />
              <h2 className="product-name">상품명</h2>
              <h2 className="product-count">수량</h2>
              <h2 className="product-price">결제금액</h2>
              <h2 className="product-market">선택매장</h2>
              <h2 className="product-way">구매방식</h2>
            </div>
            <div className="product-map">
              <img
                className="product-info"
                style={{ width: "100px", height: "100px" }}
                src="/images/alcohol/02.jpg"
                alt="이미지"
              />
              <h2 className="product-name">상품명</h2>
              <h2 className="product-count">수량</h2>
              <h2 className="product-price">결제금액</h2>
              <h2 className="product-market">선택매장</h2>
              <h2 className="product-way">구매방식</h2>
            </div>
            <div className="product-map">
              <img
                className="product-info"
                style={{ width: "100px", height: "100px" }}
                src="/images/alcohol/02.jpg"
                alt="이미지"
              />
              <h2 className="product-name">상품명</h2>
              <h2 className="product-count">수량</h2>
              <h2 className="product-price">결제금액</h2>
              <h2 className="product-market">선택매장</h2>
              <h2 className="product-way">구매방식</h2>
            </div>
          </div>
        </div>
        <div className="payline2"></div>
        <div>
          <h1>주문금액</h1>
          <div className="payline1"></div>
          <div>
            <div className="total">
              <h2>총 상품금액</h2>
              <h2>총 배송비</h2>
              <h2>결제예정금액</h2>
            </div>
            <div className="payline2"></div>
            <div className="total">
              <h1>100,000원</h1>
              <h1>0원</h1>
              <h1>100,000원</h1>
            </div>
            <div className="payline2"></div>
          </div>
        </div>
        <div>
          <h1>결제수단</h1>
          <div className="payline1"></div>
          <div className="paybtndiv">
            <button className='paybtn'>토스결제</button>
          </div>
        </div>
      </div>
    </BasicLayout>
  );
};

export default DirectPayPage;
