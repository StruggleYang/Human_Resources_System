package attendance;

import java.util.List;

import util.SQLFilter;

import dao.Dao;
import entity.attendanceCountTab;
import entity.attendanceInfoTab;
import entity.leaveTab;

public class AttendanceCountService {
	private Dao dao = new Dao();
	// ��ѯ�����Ƿ����
	public boolean checkEmployeeNumber(String employeeNumber) {
		String sql = "select employeeNumber from attendanceinfotab where employeeNumber='" + employeeNumber + "'";
		List list = dao.executeQuery(sql, attendanceInfoTab.class);
		if (list.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	// ��ѯ�ٵ�����
	public int QueryCountLate(String employeeNumber , String bgingTime , String endTime) {
		int countLate;
		String sql = "select count(*) from human_resources_system.attendanceinfotab where employeeNumber = "+employeeNumber
				+" and (attendanceType = '�ϰ�ǩ��')" +
				" and (date_format(attendanceDate,'%H:%i:%s') >'08:00:00')"+
				" and (date_format(attendanceDate,'%Y-%m-%d') between '"+bgingTime+"' and '"+endTime+"');";
		countLate = dao.getCountLine(sql);
		return countLate;
	}
	// ��ѯ���˴���
	public int QueryCountLackTime(String employeeNumber ,String bgingTime,String endTime) {
		int countLackTime=0;
		String sql = "select count(*) from human_resources_system.attendanceinfotab where employeeNumber = "+employeeNumber
				+" and (attendanceType = '�°�ǩ��')" +
				" and (date_format(attendanceDate,'%H:%i:%s') <'16:00:00')"+
				" and (date_format(attendanceDate,'%Y-%m-%d') between '"+bgingTime+"' and '"+endTime+"');";
		countLackTime = dao.getCountLine(sql);
		return countLackTime;
	}
	
	//  ��ѯ�������ڵ��������ϰ�ǩ�����°�ǩ�������Ϲ涨���У��Ȳ�ѯȫ��
	public List getCountAttendance(String employeeNumber,String bgingTime,String endTime ){
		//  date_format�����ݿ��ʱ����������ת��Ϊ�ַ�������
		String sql = "select date_format(attendanceDate,'%Y-%m-%d %H:%i:%s') attendanceDate , attendanceType from human_resources_system.attendanceinfotab where employeeNumber = "+employeeNumber+
				" and (date_format(attendanceDate,'%Y-%m-%d') between '"+bgingTime+"' and '"+endTime+"');";
		List list = dao.executeQuery(sql, attendanceInfoTab.class);
		/*System.out.println(((attendanceInfoTab) list.get(0)).getAttendanceDate());*/
		return list;
	}
	
	//  ��ѯ��ٵ�����
	public List getCountLeave(String employeeNumber,String bgingTime,String endTime ){
		String sql = "select date_format(datebging,'%Y-%m-%d') dateBging,date_format(dateEnd,'%Y-%m-%d') dateEnd from leaveTab where employeeNumber = "+employeeNumber+
				" and (date_format(dateBging,'%Y-%m-%d') between '"+bgingTime+"' and '"+endTime+"')"+
				" and (date_format(dateEnd,'%Y-%m-%d') between '"+bgingTime+"' and '"+endTime+"');";
		List list = dao.executeQuery(sql, leaveTab.class);
		return list;
	}
	
	//  ��ͳ���������ݲ��뵽��Ӧ����
	public boolean insertAttendanceCountTab(attendanceCountTab act) {
		boolean temp;
		String sql = "insert into attendanceCountTab(employeeNumber,countBegin,countEnd,countLate,countLackTime,countAttendance,countLeave,totalAttendance) values" +
				" ({employeeNumber},'{countBegin}','{countEnd}',{countLate},{countLackTime},{countAttendance},{countLeave},{totalAttendance});";
		sql = SQLFilter.filter(sql, act);
		int rs = dao.executeUpdate(sql);
		if(rs > 0){
			temp = true;
		}else{
			temp = false;
		}
		return temp;
	}
}
