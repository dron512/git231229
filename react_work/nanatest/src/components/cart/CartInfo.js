import React from 'react'
import { ProductCartInfo, ProductInfo, ProductInfoWrap, ProductPayInfo } from '../../styles/cart/cartstyle'

const CartInfo = () => {
  return (
    <ProductInfoWrap>
    <h2>이용안내</h2>
    <ProductInfo>
      <ProductCartInfo>
        <p style={{ color: "#000" }}>장바구니 이용안내</p>
        <p>
          · 해외배송 상품과 국내배송 상품은 함께 결제하실 수 없으니 장바구니
          별로 따로 결제해 주시기 바랍니다.
        </p>
        <p>
          · 해외배송 가능 상품의 경우 국내배송 장바구니에 담았다가 해외배송
          장바구니로 이동하여 결제하실 수 있습니다.
        </p>
        <p>
          · 선택하신 상품의 수량을 변경하시려면 수량변경 후 [변경] 버튼을
          누르시면 됩니다.
        </p>
        <p>
          · [쇼핑계속하기] 버튼을 누르시면 쇼핑을 계속 하실 수 있습니다.
        </p>
        <p>
          · 장바구니와 관심상품을 이용하여 원하시는 상품만 주문하거나
          관심상품으로 등록하실 수 있습니다.
        </p>
        <p>
          · 파일첨부 옵션은 동일상품을 장바구니에 추가할 경우 마지막에
          업로드 한 파일로 교체됩니다.
        </p>
      </ProductCartInfo>
      <ProductPayInfo>
        <p style={{ color: "#000" }}>무이자할부 이용안내</p>
        <p>
          · 상품별 무이자할부 혜택을 받으시려면 무이자할부 상품만 선택하여
          [주문하기] 버튼을 눌러 주문/결제 하시면 됩니다.
        </p>
        <p>
          · [전체 상품 주문] 버튼을 누르시면 장바구니의 구분없이 선택된 모든
          상품에 대한 주문/결제가 이루어집니다.
        </p>
        <p>
          · 단, 전체 상품을 주문/결제하실 경우, 상품별 무이자할부 혜택을
          받으실 수 없습니다.
        </p>
        <p>
          · 무이자할부 상품은 장바구니에서 별도 무이자할부 상품 영역에
          표시되어, 무이자할부 상품 기준으로 배송비가 표시됩니다.
        </p>
        <p>
          · 실제 배송비는 함께 주문하는 상품에 따라 적용되오니 주문서 하단의
          배송비 정보를 참고해주시기 바랍니다.
        </p>
      </ProductPayInfo>
    </ProductInfo>
  </ProductInfoWrap>
  )
}

export default CartInfo