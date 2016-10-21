package org.mnr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * @author Naveen Reddy
 * @version 1.0
 */

@Entity(name = "REPORT_SCHEDULE")
@SequenceGenerator(name = "report_seq", allocationSize = 1, initialValue = 1, sequenceName = "report_seq")
public class ReportScheuduleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_seq")
	private int id;

	@Length(min = 1, message = "Invalid SQL query")
	@Column(length = 5000)
	private String query;

	// @Length(min=4,message="Invalid time")
	@Column
	private String time;

	@Length(min = 1, message = "Invalid frequency")
	@Column
	private String frequency;

	@Length(min = 1, message = "Invalid Email Id")
	@Column
	private String mailId;

	// @Length(min=1,message="Invalid day")
	// @Column
	// private String day;

	@Length(min = 1, message = "Invalid Date Time")
	@Column
	private String dateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	// public String getDay() {
	// return day;
	// }
	//
	// public void setDay(String day) {
	// this.day = day;
	// }

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportScheuduleEntity [id=");
		builder.append(id);
		builder.append(", query=");
		builder.append(query);
		builder.append(", time=");
		builder.append(time);
		builder.append(", frequency=");
		builder.append(frequency);
		builder.append(", mailId=");
		builder.append(mailId);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append("]");
		return builder.toString();
	}

}
