package com.zeus.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@MapperScan
@Slf4j
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private Member memberService;

}
