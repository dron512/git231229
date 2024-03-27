package project.team3.three.termmemo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "termMemo")
public class TermMemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String todo;

    @JoinColumn(name = "timetable_id")
    private Long timeTableId;
    




}
