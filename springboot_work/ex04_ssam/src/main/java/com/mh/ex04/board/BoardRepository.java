package com.mh.ex04.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {

    public void delete(List idxList);
    public List<Board> list(int pageNum);
    public void insert(Board board);

    public int countRow();
    public Board selectRow(int idx);

    public void update(Board board);
}
