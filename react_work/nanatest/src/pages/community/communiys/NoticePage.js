import React, { useEffect, useState } from "react";
import { useOutletContext, useSearchParams } from "react-router-dom";
import { getList, getPage } from "../../../api/community/communityApi";
import useCustomMove from "../../../hooks/useCustomMove";
import { CommuBt, CommuMain } from "../styles/commStyle";
import { Pagination } from "antd";

const NoticePage = () => {
  const [tableData, setTableData] = useState([]);
  const [pageNation, setPageNation] = useState(null);
  const [urlSearchParams] = useSearchParams();
  const board = urlSearchParams.get("board_code");
  const [search, setSerch] = useState("");
  const { setMaintxt, setSubtxt } = useOutletContext();

  const [active, setActive] = useState("1");
  const { board_code, page, moveToListPahe, moveToReadPage, moveToAdd } =
    useCustomMove();
  useEffect(() => {
    getPage({ board_code, page }).then(res => {
      setPageNation(res);
    });

    getList({ board_code, page })
      .then(res => {
        setTableData(res);
      })
      .catch(error => {
        alert("데이터 호출에 실패하였습니다.");
      });
    if (board === "1") {
      setMaintxt("공지사항");
      setActive("1");
      setSubtxt("배송 및 상품관련 공지사항을 확인해 주세요.");
    } else if (board === "2") {
      setMaintxt("소통해요");
      setActive("2");
      setSubtxt("소통과 관련된 내용을 확인해 주세요.");
    } else if (board === "3") {
      setMaintxt("1:1 문의");
      setActive("3");
      setSubtxt("문의사항이 있으면 언제든지 문의해 주세요.");
    }
  }, [board_code, page]);

  const handleClikList = num => {
    moveToListPahe({ board_code: num, page: 1 });
  };

  const remove = item => {
    return item.split(" ", 2).shift();
  };

  const handleSearch = e => {
    setSerch(e.target.value);
  };

  const handleClikSearch = () => {
    getList({ board_code, page }, search)
      .then(res => {
        setTableData(res);
      })
      .catch(error => {
        alert("데이터 호출에 실패하였습니다.");
      });
  };

  const handlePageChange = newPage => {
    moveToListPahe({ board_code, page: newPage });
  };

  return (
    <>
      <CommuMain>
        <CommuBt onClick={() => handleClikList(1)} active={active === "1"}>
          공지사항
        </CommuBt>
        <CommuBt onClick={() => handleClikList(2)} active={active === "2"}>
          소통해요
        </CommuBt>
        <CommuBt onClick={() => handleClikList(3)} active={active === "3"}>
          1:1 문의
        </CommuBt>
        <div>
          <table>
            <thead>
              <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
              </tr>
            </thead>
            {tableData.map(item => (
              <tbody key={item.iboard}>
                <tr>
                  <td>{item.iboard}</td>
                  <td
                    className="td-docs"
                    onClick={() => {
                      moveToReadPage(item.iboard);
                    }}
                  >
                    {item.title}
                  </td>
                  <td>{item.nm}</td>
                  <td>{remove(item.createdAt)}</td>
                </tr>
              </tbody>
            ))}
          </table>
          <div className="serch">
            <div className="serch-info">
              <input
                type="text"
                placeholder="검색할 제목을 입력하세요."
                onChange={e => handleSearch(e)}
              />
              <button
                onClick={handleClikSearch}
                type="button"
                className="search-button"
              >
                SEARCH
              </button>
            </div>
            <button
              className="write-bt"
              onClick={() => {
                moveToAdd();
              }}
            >
              작성하기
            </button>
          </div>
        </div>
        <Pagination
          style={{ marginBottom: 20 }}
          defaultCurrent={1}
          total={pageNation}
          onChange={handlePageChange}
          pageSize={15}
          showSizeChanger={false}
        />
      </CommuMain>
    </>
  );
};

export default NoticePage;
