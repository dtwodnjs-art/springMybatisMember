package com.zeus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;

@Mapper
public interface MemberMapper {
	
	//가입(회원 및 회원권한설정)
	public int create(Member member) throws Exception; 
	public int createAuth(MemberAuth memberAuth) throws Exception; 
	 
	//회원리스트,회원정보,회원수정,회원삭제,권한삭제
	public List<Member> list() throws Exception; 
	public Member read(Member memebr) throws Exception; 
	public int update(Member member) throws Exception; 
	public int delete(Member memeber) throws Exception; 
	public int deleteAuth(Member member) throws Exception;
	public List<Member> search(Member member) throws Exception;

}
