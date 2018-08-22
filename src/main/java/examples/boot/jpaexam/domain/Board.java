package examples.boot.jpaexam.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="board")
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 글쓴이
    @ManyToOne(fetch = FetchType.LAZY) // member 테이블 필수 조회 제외 ( EAGER : 필수 조회 )
    @JoinColumn(name="member_id")
    private Member member;
    // 카테고리
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_category_id")
    private BoardCategory boardCategory;
    // 어떤 파일을 가지고 있는냐
    @OneToMany(mappedBy = "board",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<BoardFile> boardFiles;

    private String title;
    private String content;
    @Column(name = "read_count")
    private int readCount;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
