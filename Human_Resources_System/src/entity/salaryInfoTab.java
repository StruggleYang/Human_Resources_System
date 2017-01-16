package entity;

public class salaryInfoTab {
	private int salaryInfo;
	private int attendanceCountID;
	private double basicSalary;
	private double houseFund;
	private double pension;
	private double health;
	private double unemployment;
	private double reimbursement;
	private double bonus;
	private double totalSalary;

	public int getSalaryInfo() {
		return salaryInfo;
	}

	public void setSalaryInfo(int salaryInfo) {
		this.salaryInfo = salaryInfo;
	}

	public int getAttendanceCountID() {
		return attendanceCountID;
	}

	public void setAttendanceCountID(int attendanceCountID) {
		this.attendanceCountID = attendanceCountID;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getHouseFund() {
		return houseFund;
	}

	public void setHouseFund(double houseFund) {
		this.houseFund = houseFund;
	}

	public double getPension() {
		return pension;
	}

	public void setPension(double pension) {
		this.pension = pension;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getUnemployment() {
		return unemployment;
	}

	public void setUnemployment(double unemployment) {
		this.unemployment = unemployment;
	}

	public double getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(double reimbursement) {
		this.reimbursement = reimbursement;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attendanceCountID;
		long temp;
		temp = Double.doubleToLongBits(basicSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(bonus);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(health);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(houseFund);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pension);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(reimbursement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + salaryInfo;
		temp = Double.doubleToLongBits(totalSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(unemployment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		salaryInfoTab other = (salaryInfoTab) obj;
		if (attendanceCountID != other.attendanceCountID)
			return false;
		if (Double.doubleToLongBits(basicSalary) != Double
				.doubleToLongBits(other.basicSalary))
			return false;
		if (Double.doubleToLongBits(bonus) != Double
				.doubleToLongBits(other.bonus))
			return false;
		if (Double.doubleToLongBits(health) != Double
				.doubleToLongBits(other.health))
			return false;
		if (Double.doubleToLongBits(houseFund) != Double
				.doubleToLongBits(other.houseFund))
			return false;
		if (Double.doubleToLongBits(pension) != Double
				.doubleToLongBits(other.pension))
			return false;
		if (Double.doubleToLongBits(reimbursement) != Double
				.doubleToLongBits(other.reimbursement))
			return false;
		if (salaryInfo != other.salaryInfo)
			return false;
		if (Double.doubleToLongBits(totalSalary) != Double
				.doubleToLongBits(other.totalSalary))
			return false;
		if (Double.doubleToLongBits(unemployment) != Double
				.doubleToLongBits(other.unemployment))
			return false;
		return true;
	}

}
