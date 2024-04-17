// CartPage 컴포넌트

import React, { useEffect, useState } from "react";
import {
  deleteCart,
  getCart,
  patchCart,
  postCart,
} from "../../api/cart/cartApi";
import CartInfo from "../../components/cart/CartInfo";
import CartMainDis from "../../components/cart/CartMainDis";
import CartProduct from "../../components/cart/CartProduct";
import CartSubDis from "../../components/cart/CartSubDis";
import UserInfo from "../../components/userinfo/UserInfo";
import {
  CartTxt,
  ProductBtWrap,
  ProductCartSec,
} from "../../styles/cart/cartstyle";
import useCustomMove from "../../hooks/useCustomMove";
import useCustomLogin from "../../hooks/useCustomLogin";

const CartPage = () => {
  const { moveToPayment } = useCustomMove();
  const [serverData, setServerData] = useState([]);
  const { moveToPath } = useCustomLogin();
  const [totalItemsPrice, setTotalItemsPrice] = useState(0);
  const [totalOrderPrice, setTotalOrderPrice] = useState(0);
  const [deleteEachFlag, setDeleteEachFlag] = useState([]);
  const [selectedItems, setSelectedItems] = useState([]);

  useEffect(() => {
    getCart({ successFn, failFn, errorFn });
  }, []);

  const successFn = result => {
    setServerData(result);
    // console.log(result);
  };
  const failFn = result => {
    // console.log(result);
  };
  const errorFn = result => {
    // console.log(result);
  };

  const handleSelectedItemsChange = selectedItems => {
    // console.log("Selected Item Info:", selectedItems);
    setSelectedItems(selectedItems);
  };

  const handleClickDeleteEach = async () => {
    // console.log("눌리니");
    if (selectedItems.length > 0) {
      const iproducts = selectedItems.map(item => item.iproduct);
      await deleteCart({
        iproduct: iproducts,
        successFn,
        failFn,
        errorFn,
      });
      // 삭제 후 최신 데이터 다시 불러오기
      getCart({ successFn, failFn, errorFn });
    }
  };

  const updateData = result => {
    setServerData(result);
  };
  const calculateTotalPriceOfSelectedItems = selectedItems => {
    // selectedItems가 undefined인 경우 초기값 설정
    selectedItems = selectedItems || [];

    if (selectedItems.length === 0) {
      setTotalItemsPrice(0);
      setTotalOrderPrice(0); // 비동기적으로 업데이트하지 않도록 수정
      return 0;
    }
    const totalPrice = selectedItems.reduce((accumulator, item) => {
      return accumulator + item.totalPrice;
    }, 0);

    // 동기적으로 상태 업데이트
    setTotalItemsPrice(totalPrice);
    setTotalOrderPrice(totalPrice);

    return totalPrice;
  };

  const handleClickOrder = async () => {
    if (selectedItems.length > 0) {
      const totalItemsPrice = calculateTotalPriceOfSelectedItems(selectedItems);

      const products = selectedItems.map(item => ({
        iproduct: item.iproduct,
        productCnt: item.productCnt,
        productTotalPrice: item.totalPrice,
      }));

      await postCart({
        products,
        successFn: successFnPost,
        failFn,
        errorFn,
        totalOrderPrice: totalItemsPrice,
      });
    }

    if (selectedItems.length > 0) {
      const iproducts = selectedItems.map(item => item.iproduct);
      await deleteCart({
        iproduct: iproducts,
        successFn,
        failFn,
        errorFn,
      });
    }
  };

  const successFnPost = result => {
    const iorder = result;
    // console.log(result);
    // console.log(iorder);
    moveToPayment(iorder.result);
  };

  return (
    <div>
      <CartTxt>
        <h2>CART</h2>
      </CartTxt>
      <UserInfo />
      <CartProduct
        serverData={serverData}
        selectedItems={selectedItems}
        setSelectedItems={setSelectedItems}
        setDeleteAllFlag={setDeleteEachFlag}
        onSelectedItemsChange={handleSelectedItemsChange}
        handleClickDeleteEach={handleClickDeleteEach}
        updateData={updateData}
        handleClickOrder={handleClickOrder}
        calculateTotalPriceOfSelectedItems={calculateTotalPriceOfSelectedItems}
      />
      <CartSubDis
        serverData={serverData}
        selectedItems={selectedItems}
        calculateTotalPrice={calculateTotalPriceOfSelectedItems}
      />
      <ProductCartSec>
        <button onClick={() => handleClickDeleteEach()}>장바구니 비우기</button>
      </ProductCartSec>
      <CartMainDis
        serverData={serverData}
        calculateTotalPrice={calculateTotalPriceOfSelectedItems}
        selectedItems={selectedItems}
      />
      <ProductBtWrap>
        <button
          style={{ background: "#595959" }}
          onClick={() => handleClickOrder()}
        >
          선택상품주문
        </button>
        {/* <button style={{ background: "#d9d9d9" }}>전체상품주문</button> */}
      </ProductBtWrap>
      <CartInfo />
    </div>
  );
};

export default CartPage;
