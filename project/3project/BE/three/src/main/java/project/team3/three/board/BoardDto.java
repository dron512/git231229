package project.team3.three.board;

import jakarta.persistence.EnumType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private Categories categories;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Board toEntity() {
        Board board = Board.builder()
                .id(id)
                .content(content)
                .title(title)
                .categories(categories)
                .build();
        return board;
    }

    @Builder
    public BoardDto(Long id, String title, String content, Categories categories, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categories = categories;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}