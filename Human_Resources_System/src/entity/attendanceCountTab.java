package entity;

public class attendanceCountTab {

	private int attendanceCountID;
	private int employeeNumber;
	private String countBegin;
	private String countEnd;
	private int countLate;
	private int countLackTime;
	private int countAttendance;
	private int countLeave;
	private int countPaidLeave;
	private int totalAttendance;

	public int getAttendanceCountID() {
		return attendanceCountID;
	}

	public void setAttendanceCountID(int attendanceCountID) {
		this.attendanceCountID = attendanceCountID;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getCountBegin() {
		return countBegin;
	}

	public void setCountBegin(String countBegin) {
		this.countBegin = countBegin;
	}

	public String getCountEnd() {
		return countEnd;
	}

	public void setCountEnd(String countEnd) {
		this.countEnd = countEnd;
	}

	public int getCountLate() {
		return countLate;
	}

	public void setCountLate(int countLate) {
		this.countLate = countLate;
	}

	public int getCountLackTime() {
		return countLackTime;
	}

	public void setCountLackTime(int countLackTime) {
		this.countLackTime = countLackTime;
	}

	public int getCountAttendance() {
		return countAttendance;
	}

	public void setCountAttendance(int countAttendance) {
		this.countAttendance = countAttendance;
	}

	public int getCountLeave() {
		return countLeave;
	}

	public void setCountLeave(int countLeave) {
		this.countLeave = countLeave;
	}

	public int getCountPaidLeave() {
		return countPaidLeave;
	}

	public void setCountPaidLeave(int countPaidLeave) {
		this.countPaidLeave = countPaidLeave;
	}

	public int getTotalAttendance() {
		return totalAttendance;
	}

	public void setTotalAttendance(int totalAttendance) {
		this.totalAttendance = totalAttendance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attendanceCountID;
		result = prime * result + countAttendance;
		result = prime * result
				+ ((countBegin == null) ? 0 : countBegin.hashCode());
		result = prime * result
				+ ((countEnd == null) ? 0 : countEnd.hashCode());
		result = prime * result + countLackTime;
		result = prime * result + countLate;
		result = prime * result + countLeave;
		result = prime * result + countPaidLeave;
		result = prime * result + employeeNumber;
		result = prime * result + totalAttendance;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		attendanceCountTab other = (attendanceCountTab) obj;
		if (attendanceCountID != other.attendanceCountID)
			return false;
		if (countAttendance != other.countAttendance)
			return false;
		if (countBegin == null) {
			if (other.countBegin != null)
				return false;
		} else if (!countBegin.equals(other.countBegin))
			return false;
		if (countEnd == null) {
			if (other.countEnd != null)
				return false;
		} else if (!countEnd.equals(other.countEnd))
			return false;
		if (countLackTime != other.countLackTime)
			return false;
		if (countLate != other.countLate)
			return false;
		if (countLeave != other.countLeave)
			return false;
		if (countPaidLeave != other.countPaidLeave)
			return false;
		if (employeeNumber != other.employeeNumber)
			return false;
		if (totalAttendance != other.totalAttendance)
			return false;
		return true;
	}

}
