package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    public void getBoards() throws  Exception{
        Page<Board> boardpage = boardService.getBoards(1);
        System.out.println("page count " + boardpage.getTotalPages());
        System.out.println("element count " + boardpage.getTotalElements());
        for(Board board : boardpage){
            System.out.println(board.getId());
        }
    }
}
