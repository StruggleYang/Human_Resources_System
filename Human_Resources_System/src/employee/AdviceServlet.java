package employee;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EmployeeLogin;
import net.sf.json.JSONArray;

public class AdviceServlet extends HttpServlet {

	private EmployeeService service = new EmployeeService();

	public AdviceServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	/**
	 * ��ѯ��Ч��֪ͨ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List list = service.getAdvice();
		request.setAttribute("adviceInfo", list);
		// ͨ��ת����ת����ʾҳ��
		request.getRequestDispatcher("/advice.jsp").forward(request, response);
	}

	/**
	 * ��ѯȫ����ʷ֪ͨ
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List list = service.getAdviceAll();
		// ��java���List����ת��Ϊjs����������
		JSONArray js = JSONArray.fromObject(list);
		response.getWriter().print(js);
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
