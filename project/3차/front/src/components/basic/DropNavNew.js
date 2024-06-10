import React from "react";
import { DropStyle, DropWrap } from "../../styles/basic/dropNavCss";

const NavDropdown = ({ type, subTypes = [], onItemClick }) => {
  const onClickDropUl = () => null;

  return (
    <DropWrap
      onClick={e => {
        e.stopPropagation();
        onClickDropUl();
      }}
    >
      {subTypes.map(subType => (
        <DropStyle
          key={subType}
          onClick={e => {
            e.stopPropagation();
            onItemClick(type, subType);
          }}
        >
          {subType}
        </DropStyle>
      ))}
    </DropWrap>
  );
};

export default NavDropdown;
