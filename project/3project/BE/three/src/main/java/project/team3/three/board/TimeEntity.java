package project.team3.three.board;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
// 테이블로 매핑하지 않고, 자식 앤티티에게 매칭정보를 상속하기 위한 애노테이션 이다
@MappedSuperclass
//JPA 한태 해당 앤티티는 아더팅 기능을 상용한다는 것을 알리는 어노태이션 이다
@EntityListeners(AuditingEntityListener.class)
public class TimeEntity {

    @CreatedDate
    @Column(name = "createDate",updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
