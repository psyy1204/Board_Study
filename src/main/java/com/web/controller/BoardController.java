package com.web.controller;

import com.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
//API URI 경로를 '/board'로 정의
public class BoardController {

    @Autowired
    BoardService boardService;
    //boardService 의존성을 주입

    @GetMapping({"","/"})
    //매핑경로를 중괄호를 사용하여 여러개를 받는다
    public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx,
        Model model) {
    model.addAttribute("board", boardService.findBoardByIdx(idx));
    return "/board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "/board/list";
    }
}
