package com.zeus.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.Member;
import com.zeus.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@MapperScan(basePackages= "com.zeus.mapper")
@Slf4j
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService; // 타입(MemberService)을 인터페이스나 서비스 클래스로 지정하세요.
	
	@GetMapping("/insertForm")
	public String boardInsertForm(Model model) {
		return "member/insertForm";
	}
	
	@PostMapping("/insert")
	public String boardInsert(Member member, Model model) {
		log.info("insert board = " + member.toString());
		try {
			memberService.register(member);
		} catch (Exception e) {
			e.printStackTrace();
			return "member/failed";
		}
		return "member/success";
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		log.info("boardList");
		
		try {
			List<Member> boardList = memberService.list();
			
			model.addAttribute("boardList",boardList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "member/boardList";
	}
	
	/*@GetMapping("/detail")
	public String boardDetail(Board b, Model model) {
		log.info("boardDetail board = "+b.toString());
		
		try {
			Board board = boardService.read(b);
			if(board == null) {
				return "board/failed";
			}
			model.addAttribute("board",board);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/detail";
	}
	
	@GetMapping("/delete")
	public String boardDelete(Board board, Model model) {
		log.info("boardDetail board = "+board.toString());
		
		try {
			boardService.delete(board);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "%d 님의 정보 삭제가 실패하였습니다.".formatted(board.getNo()));
			return "board/failed";
		}
		model.addAttribute("message", "%d 님의 정보가 삭제되었습니다.".formatted(board.getNo()));
		return "board/success";
	}
	
	@GetMapping("/updateForm")
	public String boardUpdateForm(Board b, Model model) {
		log.info("updateForm board = "+b.toString());
		
		try {
			Board board = boardService.read(b);
			if(board == null) {
				model.addAttribute("message", "%d 님의 정보가 없습니다".formatted(b.getNo()));
				return "board/failed";
			}
			model.addAttribute("board", board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/updateForm";
	}
	
	@PostMapping("/update")
	public String updateBoard(Model model, Board board) {
		log.info("updateBoard board = "+board.toString());
		
		try {
			boardService.update(board);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "%d 님의 게시판이 수정되지 않았습니다.".formatted(board.getNo()));
			return "board/failed";
		}
		model.addAttribute("message", "%d 님의 게시판이 수정되었습니다.".formatted(board.getNo()));
		return "board/success";
	}
	
	@GetMapping("/search")
	public String boardSearch(Model model, Board board) {
		log.info("searchType = " + board.toString());
		
		try {
			List<Board> boardList = boardService.boardSearch(board);
			
			model.addAttribute("boardList",boardList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/boardList";
	}*/

}
