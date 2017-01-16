package employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MapToEntiy;
import entity.EmployeeLogin;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����¼��֤
		EmployeeLogin employeeLogin = (EmployeeLogin) MapToEntiy.convert(
				request.getParameterMap(), EmployeeLogin.class);
		EmployeeService service = new EmployeeService();
		EmployeeLogin result = service.login(employeeLogin);

		if (result != null) {
			// ��½�ɹ�����û���Ϣ���浽session��
			request.getSession().setAttribute("employeeLogin", result);

			// ����ְ�Ƶ�Ȩ�ޣ���ת��������ҳ
			if (result.getRankID() == 0) {
				response.sendRedirect("/Human_Resources_System/Frameset.html");
			}else{
				response.sendRedirect("/Human_Resources_System/FramesetMin.html");
			}
		} else {
			response.sendRedirect("/Human_Resources_System/login.html");
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}