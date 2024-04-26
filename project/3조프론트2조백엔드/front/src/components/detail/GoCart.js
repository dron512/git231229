import React, { useState } from "react";
import MapModal from "../modal/MapModal";
import { BigButton, PlaceBt } from "../../styles/common/reviewProductCss";
import CartModal from "../modal/CartModal";
import { Common } from "../../styles/CommonCss";

export const GoMapModal = () => {
  const [isMapModalOpen, setMapModalOpen] = useState(false);
  const handleOpenMapModal = () => {
    setMapModalOpen(true);
  };

  const handleCloseMapModal = () => {
    setMapModalOpen(false);
  };
  return (
    <div>
      {isMapModalOpen && <MapModal onClose={handleCloseMapModal} />}
      <PlaceBt onClick={handleOpenMapModal}> 판매처 선택</PlaceBt>
    </div>
  );
};

//
export const GoCartModal = () => {
  const [isCartModalOpen, setCartModalOpen] = useState(false);
  const handleOpenCartModal = () => {
    setCartModalOpen(true);
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
