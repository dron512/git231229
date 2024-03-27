package project.team3.three.memo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoDto {

    private Long id;
    private String memo;


    public MemoDto(Long id, String memo) {
        this.id = id;
        this.memo = memo;
    }
}
