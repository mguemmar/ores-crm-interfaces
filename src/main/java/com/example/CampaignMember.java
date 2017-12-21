package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CampaignMember {

	@JsonProperty("CampaignId")
	private String campaignId;
	
	@JsonProperty("ContactId")
	private String contactId;
	
	@JsonProperty("Email")
	private String email;
	
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CampaignMember [campaignId=");
		builder.append(campaignId);
		builder.append(", contactId=");
		builder.append(contactId);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
