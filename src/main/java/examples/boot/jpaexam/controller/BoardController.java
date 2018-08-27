package examples.boot.jpaexam.controller;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public String boards(Principal principal, @RequestParam(name="page",required = false, defaultValue = "1") int page, ModelMap map){
        if( principal != null)
            System.out.println("principal name : " + principal.getName());

        // 값을 리턴
        Page<Board> boardPage = boardService.getBoards(page);
        map.addAttribute("boardpage", boardPage);
        return "boards/list";
    }
}
