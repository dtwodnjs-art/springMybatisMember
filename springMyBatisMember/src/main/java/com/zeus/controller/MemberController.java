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
	private MemberService memberService;
	
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
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		log.info("memberList");
		
		try {
			List<Member> memberList = memberService.list();
			
			model.addAttribute("memberList",memberList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "member/memberList";
	}
	
	@GetMapping("/detail")
	public String memberDetail(Member m, Model model) {
		log.info("Detail"+m.toString());
		
		try {
			Member member = memberService.read(m);
			if(member == null) {
				return "member/failed";
			}
			model.addAttribute("member",m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/detail";
	}

	@GetMapping("/updateForm")
	   public String memberUpdateForm(Member m, Model model) {
	      log.info("memberUpdate member =" + m.toString());
	      try {
	         Member member = memberService.read(m);
	         if (member == null) {
	            model.addAttribute("message", "%s 님의 정보가 없습니다.".formatted(member.getNo()));
	            return "member/failed";
	         }
	         model.addAttribute("member", member);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return "member/updateForm";
	   }

	   @PostMapping("/update")
	   public String memberUpdate(Member m, Model model) {
	      log.info("boardUpdate board =" + m.toString());
	      try {
	         int count = memberService.update(m);
	         if (count > 0) {
	            model.addAttribute("message", "%s 님의 정보가 수정되었습니다.".formatted(m.getName()));
	            return "member/success";
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      model.addAttribute("message", "%s 님의 정보가 수정이 되지 않았습니다.".formatted(m.getName()));
	      return "member/failed";
	   }
	/*
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
