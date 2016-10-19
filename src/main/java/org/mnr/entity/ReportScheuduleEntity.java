package org.mnr.entity;

/**
 * @author Naveen Reddy
 * @version 1.0
 */
public class ReportScheuduleEntity {
	
	private String query;
	private String time;
	private String frequency;
	private String mailId;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportScheuduleEntity [query=");
		builder.append(query);
		builder.append(", time=");
		builder.append(time);
		builder.append(", frequency=");
		builder.append(frequency);
		builder.append(", mailId=");
		builder.append(mailId);
		builder.append("]");
		return builder.toString();
	}
	
	

}
