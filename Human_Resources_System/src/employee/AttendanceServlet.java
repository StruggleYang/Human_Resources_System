package employee;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import entity.EmployeeLogin;

public class AttendanceServlet extends HttpServlet {

	private EmployeeService service = new EmployeeService();

	public AttendanceServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	/**
	 * ��ѯǩ�����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeLogin employeeLogin = (EmployeeLogin) request.getSession()
				.getAttribute("employeeLogin");
		String type = request.getParameter("type");
		String begin = request.getParameter("begin") + " 00:00:00";
		String end = request.getParameter("end") + " 23:59:59";
		
		if (type.equals("0")) {// ��ѯ�ϰ��
			type = "�ϰ�ǩ��";
		} else {// ��ѯ�°��
			type = "�°�ǩ��";
		}
		List list = service.getAttendanceInfo(employeeLogin, type, begin, end);
		
		// ��java���List����ת��Ϊjs����������
		JSONArray js = JSONArray.fromObject(list);
		response.getWriter().print(js);
	}

	/**
	 * ����ǩ������
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeLogin employeeLogin = (EmployeeLogin) request.getSession()
				.getAttribute("employeeLogin");
		String type = request.getParameter("type");
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = s.format(new Date());

		boolean b = service.writeAttendance(employeeLogin, type, time);
		String info = "�������������ϣ�ǩ��ʧ��";
		if (b) {
			info = time + type + "�ɹ���";
		}
		response.getWriter().print(info);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
