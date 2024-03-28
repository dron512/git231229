package project.team3.three.board;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.team3.three.user.EnrollmentStatus;

@Getter
// protected: 무분별한 객체 생성을 방지함
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board")
public class Board extends TimeEntity {

    @Id
//  GenerationType.IDENTITY: 자동으로 증가열 (auto-increment column) 해준다
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

//        미정
//    private College college;

//    private User user;

    //    제목
    @Column(nullable = false)
    private String title;

    //    내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    //    카테고리? 이넘으로 해야 하는거 아닌가?
    @Enumerated(EnumType.STRING)
    private Categories categories;

    //    Builder: 클래스에 빌더 패턴을 자동으로 생성해
    @Builder
    public Board(Long id, String content, String title, Categories categories) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.categories = categories;
    }

}
