package com.ipp.ext3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipp.ext3.dto.MemberDto;
import com.ipp.ext3.repository.MemberRepository;

@WebServlet("/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 994498843533739855L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("view/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pId");
		String pPw = req.getParameter("pPw");
		String cName = req.getParameter("cName");
		String cEmail = req.getParameter("cEmail");
		String cTel = req.getParameter("cTel");

		if (pId == null || pId.length() == 0) {
			resp.setStatus(400);
			req.setAttribute("errorMsg", "회원 아이디는 필수입니다.");
		} else {
			MemberDto mem = new MemberDto(pId, pPw, cName, cEmail, cTel);

			if (!MemberRepository.getInstance().addMember(mem)) {
				resp.setStatus(500);
				req.setAttribute("errorMsg", "회원 등록 중 알 수 없는 오류가 발생했습니다.");
			}
		}

		req.getRequestDispatcher("view/register.jsp").forward(req, resp);
	}

}
