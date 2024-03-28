package project.team3.three.board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
