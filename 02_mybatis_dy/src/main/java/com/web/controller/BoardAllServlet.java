package com.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.dto.Board;
import com.web.model.service.BoardService;
import com.web.model.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardAllServlet
 */
@WebServlet("/board/boardAll.do")
public class BoardAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService service = new BoardServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage=1;
		int numPerpage=10;
		try {
			cPage= Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {}
		try {
			numPerpage= Integer.parseInt(request.getParameter("numPerpage"));
		} catch(NumberFormatException e) {}
		
		List<Board> boards = service.searchAll(Map.of("cPage", cPage, "numPerpage", numPerpage));
		
		boards.forEach(e->{
			System.out.println(e);
			System.out.println("댓글");
			if(!e.getComments().isEmpty()) {
				e.getComments().forEach(System.out::println);
			}
			System.out.println("--------------------------------------");
		});
		
		
		request.setAttribute("boards", boards);
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
