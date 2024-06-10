import React, { useState } from "react";
import MapModal from "../modal/MapModal";
import { BigButton, PlaceBt } from "../../styles/common/reviewProductCss";
import CartModal from "../modal/CartModal";
import { Common } from "../../styles/CommonCss";
import { useParams } from "react-router-dom";
import { useMutation } from "react-query";
import { postAddCart } from "../../api/productApi";

export const GoMapModal = () => {
  const [isMapModalOpen, setMapModalOpen] = useState(false);
  const { code } = useParams();
  console.log("ce : ", code);
  const handleOpenMapModal = () => {
    setMapModalOpen(true);
  };

  const handleCloseMapModal = () => {
    setMapModalOpen(false);
  };

  // console.log("ff :", code);
  return (
    <div>
      {isMapModalOpen && <MapModal onClose={handleCloseMapModal} code={code} />}
      <PlaceBt onClick={handleOpenMapModal}> 판매처 선택</PlaceBt>
    </div>
  );
};

//
export const GoCartModal = ({ postcard }) => {
  const [isCartModalOpen, setCartModalOpen] = useState(false);
  // 장바구니 넣기
  const addCartMutation = useMutation({
    mutationFn: () => postAddCart({ postcard }),
    onSuccess: () => {
      setCartModalOpen(true);
    },
  });
  const handleOpenCartModal = () => {
    // console.log("ok", postcard);
    addCartMutation.mutate(postcard);
  };

  const handleCloseCartModal = () => {
    setCartModalOpen(false);
  };

  return (
    <div>
      {isCartModalOpen && <CartModal onClose={handleCloseCartModal} />}
      <BigButton
        onClick={handleOpenCartModal}
        style={{
          background: `${Common.color.p000}`,
          border: `1px solid ${Common.color.p300}`,
        }}
      >
        장바구니 담기
      </BigButton>
    </div>
  );
};
