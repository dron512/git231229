import React, { useEffect, useState } from "react";
import { deleteCart, getCart, patchCart } from "../../api/cart/cartApi";
import { API_SERVER_HOST } from "../../util/util";

const CartProduct = ({
  serverData,
  setDeleteAllFlag,
  onSelectedItemsChange,
  handleClickDeleteEach,
  updateData,
  setServerData,
  selectedItems,
  setSelectedItems,
  calculateTotalPriceOfSelectedItems,
}) => {
  const [inputValues, setInputValues] = useState([]);

  const handleInputChange = (index, newValue) => {
    // input 값의 상태를 변경
    setInputValues(prevValues => {
      const newValues = [...prevValues];
      newValues[index] = newValue;
      return newValues;
    });
  };

  const handleToggleSelectAll = () => {
    const allItemIds = serverData.map(item => item);

    if (selectedItems.length === allItemIds.length) {
      // 선택된 아이템이 전체 아이템과 같으면 모두 해제
      onSelectedItemsChange([]);
    } else {
      // 선택된 아이템이 전체 아이템과 다르면 전체 선택
      onSelectedItemsChange(allItemIds);
    }

    setDeleteAllFlag(prevSelectAll => !prevSelectAll);
  };
  const handleSelectRow = item => {
    const updatedSelectedItems = selectedItems.includes(item)
      ? selectedItems.filter(selectedItem => selectedItem !== item)
      : [...selectedItems, item];
    setSelectedItems(updatedSelectedItems);
    onSelectedItemsChange(updatedSelectedItems);
  };

  useEffect(() => {
    onSelectedItemsChange(selectedItems);
    if (Array.isArray(serverData)) {
      setInputValues(serverData.map(item => item.productCnt.toString()));
    }
    return () => {};
  }, [selectedItems, onSelectedItemsChange, serverData, updateData]);

  const handleClickPut = async (item, index) => {
    const iproduct = item.iproduct;
    const productCnt = inputValues[index];

    try {
      await patchCart({
        iproduct,
        productCnt,
        successFn,
        failFn,
        errorFn,
      });
    } catch (error) {
      // 여기서 error를 콘솔에 출력해보세요.
      // console.error("Delete Error:", error);

      // error에 따른 처리를 추가
      errorFn(error);
    }

    await getCart({ successFn, failFn, errorFn });
  };

  const handleClickDelete = async item => {
    try {
      await deleteCart({
        iproduct: item.iproduct,
        successFn,
        failFn,
        errorFn,
      });
    } catch (error) {
      // console.error("Delete Error:", error);

      errorFn(error);
    }
    getCart({ successFn, failFn, errorFn });
  };
  const successFn = async result => {
    await updateData(result);
  };
  const failFn = result => {
    // console.log(result);
  };
  const errorFn = result => {
    // console.log(result);
  };

  return (
    <div>
      <table
        style={{
          width: "1157px",
          height: "62px",
          margin: "0 auto",
          borderTop: "solid 1px #000000 ",
          borderBottom: "solid 1px #d9d9d9 ",
        }}
      >
        <thead
          style={{
            height: "62px",
            borderBottom: "solid 1px #d9d9d9",
            fontSize: "12px",
            color: "#595959",
          }}
        >
          <tr>
            <th style={{ width: "20px" }}>
              <input
                type="checkbox"
                checked={selectedItems.length === serverData.length}
                onChange={handleToggleSelectAll}
              />
            </th>
            <th style={{ width: "160px" }}>이미지</th>
            <th style={{ textAlign: "start" }}>상세정보</th>
            <th style={{ width: "130px" }}>판매가</th>
            <th>수량</th>
            <th style={{ width: "130px" }}>배송구분</th>
            <th style={{ width: "130px" }}>배송비</th>
            <th style={{ width: "130px" }}>합계</th>
            <th style={{ width: "130px" }}>선택</th>
          </tr>
        </thead>

        <tbody style={{ width: "1130px", height: "92px" }}>
          <tr>
            <td
              colSpan={9}
              style={{ height: "1px", borderTop: "solid 1px #D9D9D9 " }}
            ></td>
          </tr>
          {Array.isArray(serverData) &&
            serverData.map((item, index) => (
              <tr key={item.iproduct} style={{ textAlign: "center" }}>
                <td style={{ padding: "26px 0" }}>
                  <input
                    type="checkbox"
                    checked={selectedItems.includes(item)}
                    onChange={() => handleSelectRow(item)}
                  />
                </td>
                <td style={{ padding: "26px 0" }}>
                  <img
                    style={{ width: "92px", height: "92px" }}
                    src={
                      item.repPic === ""
                        ? process.env.PUBLIC_URL +
                          "/assets/images/defaultitemimg.svg"
                        : `${API_SERVER_HOST}/pic/product/${item.iproduct}/${item.repPic}`
                    }
                    alt={item.productNm}
                  />
                </td>
                <td style={{ padding: "26px 0", textAlign: "start" }}>
                  {item.productNm}
                </td>
                <td style={{ padding: "26px 0" }}>
                  {item.price.toLocaleString()}
                </td>
                <td
                  style={{ width: "45px", height: "48px", padding: "26px 0" }}
                >
                  <input
                    type="number"
                    min={1}
                    max={9}
                    step={1}
                    defaultValue={item.productCnt}
                    onChange={e => handleInputChange(index, e.target.value)}
                    style={{
                      border: "1px solid #d9d9d9",
                      width: "45px",
                      height: "22px",
                      borderRadius: "4px",
                      background: "#fff",
                      textAlign: "center",
                      padding: "5px",
                      marginBottom: "5px",
                    }}
                  ></input>
                  <button
                    style={{
                      width: "45px",
                      height: "22px",
                      border: "solid 1px #d9d9d9",
                      background: "#fff",
                      color: "#868686",
                      fontSize: "10px",
                      fontWeight: "400",
                    }}
                    onClick={() => handleClickPut(item, index)}
                  >
                    변경
                  </button>
                </td>
                <td style={{ padding: "26px 0" }}>기본배송</td>
                <td style={{ padding: "26px 0" }}>무료</td>
                <td style={{ padding: "26px 0" }}>
                  {" "}
                  {item.totalPrice.toLocaleString()}
                </td>
                <td style={{ padding: "26px 0" }}>
                  <button
                    style={{
                      width: "76px",
                      height: "29px",
                      color: "#595959",
                      border: "solid 1px #d9d9d9",
                      background: "#fff",
                    }}
                    onClick={() => handleClickDelete(item)}
                  >
                    삭제하기
                  </button>
                </td>
              </tr>
            ))}
        </tbody>
      </table>
    </div>
  );
};

export default CartProduct;
