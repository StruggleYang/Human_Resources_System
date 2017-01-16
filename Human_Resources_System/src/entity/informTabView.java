package entity;

public class informTabView {

	private String employeeName;
	private String informTime;
	private String informValidityEnd;
	private String informTitle;
	private String informInfo;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getInformTime() {
		return informTime;
	}

	public void setInformTime(String informTime) {
		this.informTime = informTime;
	}

	public String getInformValidityEnd() {
		return informValidityEnd;
	}

	public void setInformValidityEnd(String informValidityEnd) {
		this.informValidityEnd = informValidityEnd;
	}

	public String getInformTitle() {
		return informTitle;
	}

	public void setInformTitle(String informTitle) {
		this.informTitle = informTitle;
	}

	public String getInformInfo() {
		return informInfo;
	}

	public void setInformInfo(String informInfo) {
		this.informInfo = informInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result
				+ ((informInfo == null) ? 0 : informInfo.hashCode());
		result = prime * result
				+ ((informTime == null) ? 0 : informTime.hashCode());
		result = prime * result
				+ ((informTitle == null) ? 0 : informTitle.hashCode());
		result = prime
				* result
				+ ((informValidityEnd == null) ? 0 : informValidityEnd
						.hashCode());
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
		informTabView other = (informTabView) obj;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (informInfo == null) {
			if (other.informInfo != null)
				return false;
		} else if (!informInfo.equals(other.informInfo))
			return false;
		if (informTime == null) {
			if (other.informTime != null)
				return false;
		} else if (!informTime.equals(other.informTime))
			return false;
		if (informTitle == null) {
			if (other.informTitle != null)
				return false;
		} else if (!informTitle.equals(other.informTitle))
			return false;
		if (informValidityEnd == null) {
			if (other.informValidityEnd != null)
				return false;
		} else if (!informValidityEnd.equals(other.informValidityEnd))
			return false;
		return true;
	}

}
