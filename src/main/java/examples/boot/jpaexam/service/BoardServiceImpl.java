package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements  BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoards(int page) {
        Pageable pageable = PageRequest.of(page-1,2);
        Page<Board> boardpage = boardRepository.getBoards(pageable);
        return boardpage;
    }

}
