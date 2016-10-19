package org.mnr.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * @author Naveen Reddy
 * @version 1.0
 */
public class ReportScheuduleEntity {
	@NotNull(message="Value can't be empty")
	private String query;
	@Length(min=4)
	private String time;
	@NotNull(message="Value can't be empty")
	private String frequency;
	@Email(message="Invalid Email id")
	private String mailId;
	@NotNull(message="Value can't be empty")
	private String  day;
	@NotNull(message="Value can't be empty")
	private String dateTime;
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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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
		builder.append(", day=");
		builder.append(day);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append("]");
		return builder.toString();
	}
	
	

}
