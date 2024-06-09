package com.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.dto.Employee;
import com.emp.model.service.EmpService;
import com.emp.model.service.EmpServiceImpl;

@WebServlet("/emp/empall.do")
public class EmployeeAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 인터페이스 타입을 이용하여 가상의 Service 구현체를 설정
    private EmpService service=new EmpServiceImpl();
    
    // 선생님이 살짝 언급하고 넘어가신 init 메소드의 사용방법
    public void init() throws ServletException {
    	// init 메소드 ? Client 요청 → Servlet 객체 생성 → init 메소드를 이용하여 Servlet을 초기화 → 이후 기존 로직 수행
    	// * 만약, request가 첫 번째 혹은 Servlet 객체가 없다면 init 메소드 수행하고 이미 Servlet이 있다면, 바로 로직을 수행한다. 
    	// ★ 따라서, init 메소드를 사용할 때 service 객체를 생성하는 21번째 코드를 여기에 작성하는 방법 또한 존재한다.
    	System.out.println("init Called");
    	super.init();
    }
    
    public void destroy() {
    	// destroy 메소드 ? tomcat 종료시 수행하는 메소드로 다시 말해 Servlet 마무리 작업 수행 시 자동으로 호출되는 메소드이다.
    	System.out.println("destroy Called");
    	super.destroy();
    }
    
    public EmployeeAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 사원 조회
		List<Employee> employee=service.selectEmployeeAll();	// 가상의 구현체 사용
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/WEB-INF/views/emp/emp.jsp").forward(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
