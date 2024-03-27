package project.team3.three.board;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public void savePost(BoardDto boardDto) {
//        boardRepository.save(boardDto.toEntity()).getId();
    }
}
