package employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MapToEntiy;
import entity.EmployeeLogin;
import entity.employeeInfoTab;

public class PwdChangeServlet extends HttpServlet {

	private EmployeeService service = new EmployeeService();

	public PwdChangeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	/**
	 * ��֪ԭ���룬�޸�����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeLogin employeeLogin = (EmployeeLogin) MapToEntiy.convert(request.getParameterMap(),
				EmployeeLogin.class);
		EmployeeLogin result = service.login(employeeLogin);

		if (result == null) {
			response.getWriter().print("ԭ�������");
		} else {
			String user = request.getParameter("employeeNumber");
			String pwd = request.getParameter("pwd");
			if (service.setPwd(user, pwd)) {
				response.getWriter().print(user + "�����޸ĳɹ�");
			} else {
				response.getWriter().print("�������������ϣ������޸�ʧ��");
			}
		}
	}

	/**
	 * ���ݸ�����Ϣ�һ�����
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		employeeInfoTab employee = new employeeInfoTab();
		employee.setEmployeeNumber(Integer.parseInt(request.getParameter("employeeNumber")));
		employee.setEmployeeName(request.getParameter("employeeName"));
		employee.setEmployeeID(request.getParameter("employeeID"));
		employee.setEmployeeGender(request.getParameter("employeeGender"));
		employee.setEmployeeTel(request.getParameter("employeeTel"));
		employee.setEmployeeOutTime(request.getParameter("employeeOutTime"));
		response.getWriter().print(service.getPwd(employee));
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
