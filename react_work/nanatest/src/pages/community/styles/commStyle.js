import styled from "@emotion/styled";
import ReactQuill from "react-quill";

export const CommuMain = styled.div`
  position: relative;
  text-align: center;
  width: 100%;
  margin: 0 auto;

  table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 16px;
  }

  th {
    border-left: 3px solid #fff;
    padding: 12px;
    background: #e9b25f;
    height: 60px;
    color: #fff;
    font-size: 18px;
    font-weight: 400;
  }
  td {
    border-right: 3px solid #e9b25f;
    border-bottom: 1px solid #e9b25f;
    padding: 12px;
    height: 70px;
    color: #868686;
    text-align: center;
    font-family: Noto Sans KR;
    font-size: 18px;
    font-weight: 400;
  }
  td:last-child {
    border-right: none;
  }
  .td-docs {
    text-align: start;
    cursor: pointer;
  }

  th:nth-of-type(1),
  td:nth-of-type(1) {
    width: 10%;
  }

  th:nth-of-type(2),
  td:nth-of-type(2) {
    width: 50%;
  }

  th:nth-of-type(3),
  td:nth-of-type(3),
  th:nth-of-type(4),
  td:nth-of-type(4) {
    width: 20%;
  }

  .serch {
    display: flex;
    justify-content: space-between;
    margin-bottom: 33px;
  }

  .serch-info {
    display: flex;
    align-items: center;
    input {
      width: 306px;
      height: 37px;
      border: 1px solid #d9d9d9;
      background: #fff;
      font-size: 15px;
      font-weight: 350;
      padding-left: 10px;
    }
    input::placeholder {
      color: #d9d9d9;
    }
  }

  .search-button {
    margin-left: 12px;
    width: 125px;
    height: 37px;
    background: #bababa;
    color: #fff;
    text-align: center;
    font-family: Noto Sans KR;
    font-size: 20px;
    font-weight: 500;
    border: none;
    cursor: pointer;
  }
  .write-bt {
    width: 125px;
    height: 37px;
    background: #e9b25f;
    color: #fff;
    text-align: center;
    font-family: Noto Sans KR;
    font-size: 20px;
    font-weight: 500;
    border: none;
    cursor: pointer;
  }
  .pagination {
    margin-bottom: 62px;
  }
`;

export const CommuBt = styled.button`
  border: 1px solid ${props => (props.active ? "#e9b25f" : "#d9d9d9")};
  background: #fff;
  color: ${props => (props.active ? "#e9b25f" : "#bababa")};
  text-align: center;
  font-family: Noto Sans KR;
  font-size: 25px;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
  width: 33.3%;
  height: 75px;
  cursor: pointer;
  margin-bottom: 50px;
`;

export const NoticeBoard = styled.form`
  .content-container {
    font-size: 1.8rem;
  }
  .content-container img {
    max-height: 500px;
  }
  .wrap {
    font-size: 1.8rem;
    color: #868686;
  }
  .aaa {
    display: flex;
    align-items: center;
    height: 40px;
    border-top: 1px solid #868686;
  }

  .bbb {
    display: flex;
    align-items: center;
    height: 40px;
    border-top: 1px solid #868686;
    margin-bottom: 30px;
    border-bottom: 1px solid #868686;
  }
  span {
    width: 20%;
  }
  input {
    width: 100%;
    height: 100%;
    border: none;
    border-left: 1px solid #868686;
    padding-left: 20px;
  }

  .wrap-footer {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 15px;
    p {
      color: #868686;
      font-family: Noto Sans KR;
      font-size: 20px;
      font-style: normal;
      font-weight: 350;
      line-height: normal;
    }
  }

  .bts {
    display: flex;
    justify-content: end;
    gap: 15px;
  }
`;

export const StyledReactQuill = styled(ReactQuill)`
  margin: 0 auto;
  height: 800px;
  margin-bottom: 55px;
  width: 90%;
  .ql-toolbar {
    text-align: left;
    border-radius: 5px;
    height: 50px;
    display: flex;
    align-items: center;
  }
  .ql-container {
    border: none;
  }
  .ql-editor img {
    max-width: 100%;
    height: auto;
  }
`;

export const Axx = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 1000px;
  border-radius: 20px;
  background: #fff;
  box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.15);
  margin-bottom: 30px;
  width: 100%;
  margin: 0 auto;
  input {
    border: none;
    width: 90%;
    padding: 12px;
    height: 100px;
    color: #000;
    font-family: Noto Sans KR;
    font-size: 30px;
    font-style: normal;
    font-weight: 500;
    line-height: 24px;
    border-bottom: #868686;
  }
  hr {
    width: 90%;
    margin: 0 auto;
    height: 1px;
    background: #868686;
    margin-bottom: 22px;
  }
`;

export const Azxc = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 30px;
  margin-top: 30px;
  .ps {
    display: flex;
    gap: 20px;
    align-items: center;
  }
  p {
    color: #868686;
    font-family: Noto Sans KR;
    font-size: 20px;
    font-style: normal;
    font-weight: 350;
    line-height: normal;
  }
  .bts {
    display: flex;
    gap: 20px;
    button {
      cursor: pointer;
    }
  }
`;

export const Pagenation = styled.div`
  margin-bottom: 20px;
  .bt-num {
    font-size: 2rem;
    width: 60px;
    height: 60px;
    background: transparent;
    border: none;
  }
  .bt-move {
    font-size: 2rem;
    width: 60px;
    height: 60px;
    background: transparent;
    border: 1px solid yellow;
    border-radius: 30px;
  }
`;

export const CommentRead = styled.div`
  margin-bottom: 20px;
  .comment-top {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
    align-items: center;
    position: relative;
    h3 {
      color: #868686;
      font-size: 20px;
      font-weight: 400;
      line-height: normal;
    }
    button {
      border: none;
      background: transparent;
      cursor: pointer;
    }
  }

  .comment-bts {
    position: absolute;
    right: 0;
    top: 50%;
    background-color: #fff;

    li {
      padding: 8px;
      cursor: pointer;
      &:hover {
        background-color: #f5f5f5;
      }
    }
  }
  .comment-mid {
    text-align: start;
    color: #595959;
    font-size: 15px;
    font-style: normal;
    font-weight: 400;
    margin-bottom: 10px;
  }
  .comment-bottom {
    color: #868686;
    font-size: 13px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    text-align: start;
    margin-bottom: 10px;
  }
`;

export const Commu = styled.div`
  position: relative;
  width: 80%;
  margin: 0 auto;
`;
