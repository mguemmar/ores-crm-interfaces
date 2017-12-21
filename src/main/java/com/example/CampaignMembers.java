package com.example;

import java.util.List;
public class CampaignMembers {
   
	private int totalSize;
	private String done;
	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}



	private List<CampaignMember> records;

	
	
	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	
	

	public List<CampaignMember> getRecords() {
		return records;
	}

	public void setRecords(List<CampaignMember> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CampaignMembers [members=");
		builder.append(records);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
