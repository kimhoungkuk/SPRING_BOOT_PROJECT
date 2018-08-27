package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Board;
import org.springframework.data.domain.Page;

public interface BoardService {
        Page<Board> getBoards(int page); // 1 이 시작 페이지
}
