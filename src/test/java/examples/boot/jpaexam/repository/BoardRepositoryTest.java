package examples.boot.jpaexam.repository;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.domain.BoardFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application.yml")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository; // test할 대살을 선언

    @Test // junit
    public void testGetBoardById() throws Exception{
        System.out.println("-----------------------------------------");
        Board board = boardRepository.getOne(1L); // 1L 키를 가진 Board정보를 요청
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + " , " + board.getTitle());
        System.out.println(board.getMember().getName());
        System.out.println("-----------------------------------------");
    }

    @Test // junit
    public void testGetBoardById2() throws Exception{
        System.out.println("-----------------------------------------");
        Board board = boardRepository.getBoardById(1L); // 1L 키를 가진 Board정보를 요청
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + " , " + board.getTitle());
        System.out.println(board.getMember().getName());
        System.out.println("-----------------------------------------");
    }

    @Test // junit
    public void testGetBoardById3() throws Exception{
        System.out.println("-----------------------------------------");
        Board board = boardRepository.getBoard(1L); // 1L 키를 가진 Board정보를 요청
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + " , " + board.getTitle());
        System.out.println(board.getMember().getName());
        System.out.println("-----------------------------------------");
    }

    @Test // junit
    public void testGetBoardById4() throws Exception{
        System.out.println("-----------------------------------------");
        Board board = boardRepository.getBoardByDsl(1L); // 1L 키를 가진 Board정보를 요청
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + " , " + board.getTitle());
        System.out.println(board.getMember().getName());
        System.out.println("-----------------------------------------");
    }

    @Test // junit
    public void testGetBoardList1() throws Exception{
        System.out.println("-----------------------------------------");
        List<Board> list = boardRepository.findAll();
        for(Board board : list){
            System.out.println(board.getId() + " , " + board.getTitle());
            System.out.println("**********************************************");
            List<BoardFile> boardFiles = board.getBoardFiles();
            for(BoardFile boardFile : boardFiles){
                System.out.println(boardFile.getName());
            }
        }
        System.out.println("*************************************************");
    }

    @Test // junit
    public void testGetBoardList2() throws Exception{
        System.out.println("-----------------------------------------");
        List<Board> list = boardRepository.getBoards();
        for(Board board : list){
            System.out.println(board.getId() + " , " + board.getTitle());
            System.out.println("**********************************************");
            List<BoardFile> boardFiles = board.getBoardFiles();
            for(BoardFile boardFile : boardFiles){
                System.out.println(boardFile.getName());
            }
        }
        System.out.println("*************************************************");
    }
}
