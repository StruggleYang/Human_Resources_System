package employee;

import java.util.List;

import util.SQLFilter;
import dao.Dao;
import entity.EmployeeLogin;
import entity.SeleryInfoView;
import entity.attendanceInfoTab;
import entity.employeeInfoTab;
import entity.informTabView;

public class EmployeeService {

	private Dao dao = new Dao();

	/**
	 * �ж��Ƿ��¼�ɹ�������Ա����Ϣ
	 * 
	 * @param employee
	 * @return *�����*
	 */
	public EmployeeLogin login(EmployeeLogin employeeLogin) {
		String sql = "select * from employeeInfoTab where employeeNumber='{employeeNumber}' and employeePwd='{employeePwd}'";
		sql = SQLFilter.filter(sql, employeeLogin);
		List list = dao.executeQuery(sql, EmployeeLogin.class);
		if (list.size() > 0) {
			return (EmployeeLogin) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * �޸�����
	 * 
	 * @param user
	 * @param pwd
	 * @return *�����*
	 */
	public boolean setPwd(String user, String pwd) {
		String sql = "update employeeInfoTab set employeePwd =" + pwd
				+ " where employeeNumber =" + user;
		int i = dao.executeUpdate(sql);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ���ݸ�����Ϣ���һ�����
	 * 
	 * @param employee
	 * @return *�����*
	 */
	public String getPwd(employeeInfoTab employee) {
		String sql = "select employeePwd from employeeInfoTab where employeeNumber='{employeeNumber}' and employeeName='{employeeName}' and employeeID='{employeeID}' and employeeGender='{employeeGender}' and employeeTel='{employeeTel}' and employeeOutTime='{employeeOutTime}'";
		sql = SQLFilter.filter(sql, employee);
		List list = dao.executeQuery(sql, EmployeeLogin.class);
		if (list.size() > 0) {
			String pwd = ((EmployeeLogin) list.get(0)).getEmployeePwd();
			return "��֤�ɹ�����ѯ�������ǣ�" + pwd;
		} else {
			return "������Ϣ���������һ�ʧ�ܣ�";
		}
	}

	/**
	 * д��ǩ������
	 * 
	 * @param employeeLogin
	 * @param type
	 * @param time
	 * @return *�����*
	 */
	public boolean writeAttendance(EmployeeLogin employeeLogin, String type,
			String time) {
		String sql = "insert into attendanceInfoTab(employeeNumber,attendanceDate,attendanceType) values('{employeeNumber}','"
				+ time + "','" + type + "')";
		sql = SQLFilter.filter(sql, employeeLogin);
		int i = dao.executeUpdate(sql);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��ѯ�����û���ǩ����Ϣ
	 * 
	 * @param employeeLogin
	 * @param type
	 * @param begin
	 * @param end
	 * @return *�����*
	 */
	public List getAttendanceInfo(EmployeeLogin employeeLogin, String type,
			String begin, String end) {
		String sql = "select employeeNumber,date_format(attendanceDate,'%Y-%m-%d %H:%i:%S') as attendanceDate,attendanceType from attendanceInfoTab where employeeNumber='{employeeNumber}' and attendanceType='";
		sql += type + "' and attendanceDate>='";
		sql += begin + "' and attendanceDate<='" + end + "'";
		sql = SQLFilter.filter(sql, employeeLogin);
		List list = dao.executeQuery(sql, attendanceInfoTab.class);
		return list;
	}

	/**
	 * ��ѯ���˹�����Ϣ
	 * 
	 * @param id
	 * @return *�����*
	 */
	public List getSalaryLog(int id) {
		String sql = "select a.employeeNumber,DATE_FORMAT(countBegin,'%Y-%m-%d') as countBegin,DATE_FORMAT(countEnd,'%Y-%m-%d') as countEnd,countLate,countLackTime,countLeave,countPaidLeave,countAttendance,totalAttendance,basicSalary,houseFund,pension,health,unemployment,reimbursement,bonus,totalSalary from attendanceCountTab as a join salaryInfoTab as s on a.attendanceCountID=s.attendanceCountID where employeeNumber=";
		sql += id;
		List list = dao.executeQuery(sql, SeleryInfoView.class);
		return list;
	}

	/**
	 * ��ѯ��ֹ���ڴ��ڽ����֪ͨ
	 * 
	 * @return *�����*
	 */
	public List getAdvice() {
		String sql = "select employeeInfoTab.employeeName,DATE_FORMAT(informTab.informTime,'%Y-%m-%d') as informTime,DATE_FORMAT(informTab.informValidityEnd,'%Y-%m-%d') as informValidityEnd,informTab.informTitle,informTab.informInfo from informTab join employeeInfoTab on informTab.employeeNumber = employeeInfoTab.employeeNumber where informTab.informValidityEnd > now()";
		List list = dao.executeQuery(sql, informTabView.class);
		return list;
	}

	/**
	 * ��ѯȫ����ʷ֪ͨ
	 * 
	 * @return *�����*
	 */
	public List getAdviceAll() {
		String sql = "select employeeInfoTab.employeeName,DATE_FORMAT(informTab.informTime,'%Y-%m-%d') as informTime,DATE_FORMAT(informTab.informValidityEnd,'%Y-%m-%d') as informValidityEnd,informTab.informTitle,informTab.informInfo from informTab join employeeInfoTab on informTab.employeeNumber = employeeInfoTab.employeeNumber";
		List list = dao.executeQuery(sql, informTabView.class);
		return list;

	}
}
