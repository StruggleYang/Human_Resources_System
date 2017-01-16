package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import attendance.AttendanceCountService;
import entity.attendanceInfoTab;

public class ProjectUtil {
	private AttendanceCountService service = new AttendanceCountService();
	// ��ѯ�������ڴ���
	public int getcountAttendance(String employeeNumber,String bgingTime,String endTime ){
		
		int counts = 0;  // �������ڵĴ���
		String temp=""; // �������������ڴ����һ�α�����������
		String startDate = "08:00:00"; // �����ϰ��ʱ��
		String endDate = "16:00:00"; // �����°�ʱ��
		DateFormat dt = new SimpleDateFormat("HH:mm:ss"); // ָ��ʱ���ʽ
		
		List<attendanceInfoTab> list = service.getCountAttendance(employeeNumber,bgingTime,endTime);
		for(attendanceInfoTab att : list){
			//  �Ƚ���һ�ε������պͱ��ε��������Ƿ���ͬ�����ж������Ƿ���ͬһ����ϰ���°�ǩ��
			if(temp != "" && temp.substring(0, 10).equals(att.getAttendanceDate().substring(0, 10))){
				try {
					Date sd = dt.parse(startDate);
					Date ed = dt.parse(endDate);
					Date prd = dt.parse(temp.substring(11));
					Date ned = dt.parse(att.getAttendanceDate().substring(11));
					//  ����������°�ǩ��ʱ���������ʱ�����Ա�
					if (prd.getTime()<=sd.getTime() && ned.getTime()>=ed.getTime()) {
						counts++;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//  ��ȡ�����ղ���ֵ�������������������ϸ�����������
			temp = att.getAttendanceDate();
		}
		return counts;
	}
	//  �����������
	 public int daysBetween(String smdate,String bdate) throws ParseException{  
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(sdf.parse(smdate));    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(sdf.parse(bdate));    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));     
	    }  
}