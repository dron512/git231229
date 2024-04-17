import React, { useState } from "react";
import styled from "@emotion/styled";
import {
  BaByMealTitle,
  BabyMealDesc,
  BabyMealInfo,
  BabyMealMonth,
  MealWrap,
} from "../../styles/modal/productModalStyle";
import { Pagination } from "antd";
import { ModalPagiWarp } from "../../styles/product/ProductGridStyle";

export const CloseButton = styled.span`
  font-size: 24px;
  cursor: pointer;
  position: absolute;
  top: 10px;
  right: 10px;
`;

const itemsPerPage = 1; // 한 페이지에 표시될 아이템 수
const data = [
  {
    content:
      "\n" +
      "\n" +
      "영유아들이 젖을 떼고 고체 음식에 적응하기 위한 죽과 유사한 식품은\n" +
      "부모들에게 큰 중요성을 갖어요.\n" +
      "\n" +
      "이 제품들은 안전성, 재료 선택, 제조 과정에 대한 부모들의 예민한 관심을 받아요.\n" +
      "\n" +
      "특히 잘게 다지지 않은 재료가 사용되면 아기의 기도에 위험이 있을 수 있으며,\n" +
      "이로 인한 알레르기 반응을 주의 깊게 살펴보아야 해요.\n" +
      "\n" +
      " 만일 첫 섭취 시 가벼운 알레르기 반응이 나타난다면, 해당 음식을 3-4주 후에 다시 시도하여 확인해보는 것이 좋아요.\n" +
      "\n" +
      "\n" +
      " 이제 이유식 가이드를 함께 볼까요? 다음 페이지로 넘겨주세요.\n",
  },

  {
    month: "- 초기 4~6개월\n",
    content:
      "횟수와 양 : 하루 미음식 1회/ 3스푼 정도\n" +
      "이유식 형태 : 주르륵 흐를정도로 곱게 갈아야 해요\n",
    // "섭취가능: 야채(당근, 애호박), 과일(사과, 배, 수박)\n" +
    // "섭취불가: 육류, 어패류, 난류, 유제품, 콩제품\n",

    month2: "- 중기 7~9개월\n",
    content2:
      "횟수와 양 : 죽식 2회 (70g~100g)\n" +
      "이유식 형태 : 마요네즈 정도 곱게 다진 정도\n",
    // "섭취가능: 야채(당근, 애호박), 과일(사과, 배, 수박)\n" +
    // "섭취불가: 육류, 어패류, 난류, 유제품, 콩제품\n",

    month3: "- 후기 10~12개월",
    content3:
      "횟수와 양 : 된죽 3회 (100g)\n" +
      "이유식 형태 : 두부무르기 정도 0.3~0.5㎝정도\n",

    month4: "- 완료기 12~24개월\n",
    content4:
      "횟수와 양 : 진밥 3회(100g~120g)\n" +
      "이유식 형태 : 삶은 밤 정도0.5~1㎝정도\n",
  },
];

const MealModal = ({ closeModal }) => {
  const [currentPage, setCurrentPage] = useState(0);

  // 현재 페이지에 해당하는 데이터 추출
  const offset = currentPage * itemsPerPage;
  const currentData = data.slice(offset, offset + itemsPerPage);

  // 페이지 변경 시 호출되는 함수
  const handlePageChange = page => {
    setCurrentPage(page - 1); // Ant Design Pagination은 1부터 시작하므로 1을 빼줍니다.
  };

  return (
    <div>
      <MealWrap>
        <BabyMealInfo>
          <CloseButton onClick={closeModal}>&times;</CloseButton>
          <BaByMealTitle>이유식</BaByMealTitle>
          <BabyMealMonth>
            {currentData.map((item, index) => (
              <div key={index}>
                <br />
                <h3>{item.month}</h3>
                <p>{item.content}</p>

                <br />
                <br />
                <h3>{item.month2}</h3>
                <p>{item.content2}</p>

                <br />
                <br />
                <h3>{item.month3}</h3>
                <p>{item.content3}</p>

                <br />
                <br />
                <h3>{item.month4}</h3>
                <p>{item.content4}</p>
              </div>
            ))}
          </BabyMealMonth>

          <BabyMealDesc>{/* 나머지 부분은 변하지 않음 */}</BabyMealDesc>
          <ModalPagiWarp>
            <Pagination
              className="pagination"
              total={data.length}
              pageSize={itemsPerPage}
              current={currentPage + 1} // Ant Design Pagination은 1부터 시작하므로 1을 더해줍니다.
              onChange={handlePageChange}
            />
          </ModalPagiWarp>
        </BabyMealInfo>
      </MealWrap>
    </div>
  );
};

export default MealModal;
