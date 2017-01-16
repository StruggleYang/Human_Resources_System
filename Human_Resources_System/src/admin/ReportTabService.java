package admin;

import java.util.List;

import dao.Dao;
import entity.attendanceCountTab;
import entity.attendanceCountView;
import entity.departmentTab;
import entity.employeeInfoTab;
import entity.salaryInfoTab;

public class ReportTabService {
	private Dao dao = new Dao();
	// ְ��
	public List reportRankTab( Class clazz) {
		String sql = "select * from rankTab;";
		List list = dao.executeQuery(sql, clazz);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	// ����
	public List<departmentTab> reportDepartmentTab( Class clazz) {
		String sql = "select * from departmentTab;";
		List list = dao.executeQuery(sql, clazz);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	
	// Ա��
	public List<employeeInfoTab> reportEmployeeInfoTab( Class clazz) {
		String sql = "select employeeNumber,employeePwd,employeeName,employeeID,employeeGender,employeeTel,employeeAddress,DATE_FORMAT(employeeOutTime,'%Y-%m-%d') as employeeOutTime,rankID,departmentID from employeeInfoTab;";
		List list = dao.executeQuery(sql, clazz);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	
	// ����ͳ��
	public List<attendanceCountView> reportAttendanceCountView(
			Class clazz) {
		String sql = "select e.employeeNumber,e.employeeName,d.departmentName,DATE_FORMAT(a.countBegin,'%Y-%m-%d') as countBegin,DATE_FORMAT(a.countEnd,'%Y-%m-%d') as countEnd,a.countLate,a.countLackTime,a.countAttendance,a.countLeave,a.countPaidLeave,a.totalAttendance from attendanceCountTab as a,employeeInfoTab as e,departmentTab as d";
		List list = dao.executeQuery(sql, clazz);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	// ���ʱ�
	public List<salaryInfoTab> reportSalaryInfoTab(
			Class clazz) {
		String sql = "select * from salaryInfoTab;";
		List list = dao.executeQuery(sql, clazz);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
