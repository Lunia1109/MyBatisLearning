package com.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.dto.Member;
import com.web.model.service.MemberService;
import com.web.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberAllServlet
 */
@WebServlet("/member/memberAll.do")
public class MemberAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		List<Member> members = service.searchAll(Map.of("total", 10));
		int cPage = 1, numPerpage = 5;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) { }
		try {
			numPerpage = Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e) { }
		
		
		
		int totalData = members.size();
		int totalPage = (int)(Math.ceil((double)totalData/numPerpage));
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		StringBuffer pageBar = new StringBuffer();
		
		if(pageNo==1) {
			pageBar.append("<span>[이전]</span>");
		} else {
			pageBar.append("<a href='"+request.getRequestURI()+"?cPage="+(pageNo-1)+"&numPerpage="+numPerpage+"'>[이전]</a>");
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar.append("<span>"+pageNo+"</span>");
			} else {
				pageBar.append("<a href='"+request.getRequestURI()+"?cPage="+pageNo+"&numPerpage="+numPerpage+"'>"+pageNo+"</a>");
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar.append("<span>[다음]</span>");
		} else {
			pageBar.append("<a href='"+request.getRequestURI()+"?cPage="+pageNo+"&numPerpage="+numPerpage+"'>[다음]</a>");
		}
		
		request.setAttribute("pageBar", pageBar);
		members = service.searchAll(Map.of("cPage", cPage, "numPerpage", numPerpage));
		request.setAttribute("members", members);
		request.getRequestDispatcher("/WEB-INF/views/member/member.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
