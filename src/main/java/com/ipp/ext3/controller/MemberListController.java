package com.ipp.ext3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipp.ext3.dto.MemberDto;
import com.ipp.ext3.repository.MemberRepository;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {

	private static final long serialVersionUID = -2839376013619414196L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberDto> memberList = MemberRepository.getInstance().getMemberList();

		MemberDto[] memberListArr = new MemberDto[memberList.size()];

		for (int i = 0, l = memberListArr.length; i < l; i++) {
			memberListArr[i] = memberList.get(i);
		}

		req.setAttribute("memberList", memberListArr);

		req.getRequestDispatcher("view/memberList.jsp").forward(req, resp);
	}

}
