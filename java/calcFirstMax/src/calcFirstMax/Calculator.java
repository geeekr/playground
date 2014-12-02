package calcFirstMax;

public class Calculator {
	// 已知条件，或传入参数
	private int groupTotal;
	private int teamTotal;
	private int pageNum;
	private int pageSize;
	// 要求解的未知数
	private int groupFirst;
	private int groupMax;
	private int teamFirst;
	private int teamMax;

	public void calc() {
		// 辅助的临时变量
		int n = pageNum * pageSize - groupTotal;
		int m = n / pageSize;
		int k = groupTotal % pageSize;

		// 求解过程
		if (pageNum < 1 && pageSize <= 0) {
			// 分页参数不合法
			System.out.println("Illegal parameters.");
			return;
		}

		if (teamTotal <= 0 && groupTotal <= 0) {
			// 1.数据库中既没有团队、也没有分组
			System.out.println("No result found.");
			teamFirst = -1;
			teamMax = -1;
			groupFirst = -1;
			groupMax = -1;
			return;
		} else if (teamTotal <= 0 && groupTotal > 0) {
			// 2.数据库中只有分组没有团队
			teamFirst = -1;
			teamMax = -1;
			groupFirst = (pageNum - 1) * pageSize;
			groupMax = pageSize;
		} else if (teamTotal > 0 && groupTotal <= 0) {
			// 3.数据库中只有团队没有分组
			groupFirst = -1;
			groupMax = -1;
			teamFirst = (pageNum - 1) * pageSize;
			teamMax = pageSize;
		} else {
			// 4.数据库中既有团队、又有分组
			if (n <= 0) {
				// 4.1.当前页码只有分组信息
				groupFirst = (pageNum - 1) * pageSize;
				groupMax = pageSize;
				teamFirst = -1;
				teamMax = -1;
			} else {
				if (n <= pageSize) {
					// 4.2.当前页码既有分组信息、也有团队信息
					groupFirst = (pageNum - 1) * pageSize;
					groupMax = n;
					teamFirst = 0;
					teamMax = k;
				} else {
					// 4.3.当前页码只有团队信息
					groupFirst = -1;
					groupMax = -1;
					teamFirst = k + (m - 1) * pageSize + 1;
					teamMax = pageSize;
				}
			}
		}

		// 根据求解结果从数据库中获取 group 和 team 纪录
		if (groupMax > 0) {
			// TODO fetch groups
		}

		if (teamMax > 0) {
			// TODO fetch teams
		}
	}

	public int getGroupFirst() {
		return groupFirst;
	}

	public void setGroupFirst(int groupFirst) {
		this.groupFirst = groupFirst;
	}

	public int getGroupMax() {
		return groupMax;
	}

	public void setGroupMax(int groupMax) {
		this.groupMax = groupMax;
	}

	public int getTeamFirst() {
		return teamFirst;
	}

	public void setTeamFirst(int teamFirst) {
		this.teamFirst = teamFirst;
	}

	public int getTeamMax() {
		return teamMax;
	}

	public void setTeamMax(int teamMax) {
		this.teamMax = teamMax;
	}

	public int getGroupTotal() {
		return groupTotal;
	}

	public void setGroupTotal(int groupTotal) {
		this.groupTotal = groupTotal;
	}

	public int getTeamTotal() {
		return teamTotal;
	}

	public void setTeamTotal(int teamTotal) {
		this.teamTotal = teamTotal;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void printInputs() {
		System.out.printf(
				"Inputs:\n\tgroupTotal = %d, teamTotal = %d, pageNum = %d, pageSize = %d.\n",
				groupTotal, teamTotal, pageNum, pageSize);
	}
	
	public void printOutputs() {
		System.out.printf(
				"Outputs:\n\tgroupFirst = %d, groupMax = %d, teamFirst = %d, teamMax = %d.\n",
				groupFirst, groupMax, teamFirst, teamMax);
	}
	
}
