package org.mnr.engine.job;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.mnr.engine.enums.Frequency;
import org.mnr.engine.utilities.SessionFactoryBuilder;
import org.mnr.entity.ReportScheuduleEntity;

/**
 * @author naveen.reddy
 * @version 1.0
 */
public class JobService {

	private SessionFactory sessionFactory = SessionFactoryBuilder
			.getSessionFactory();

	// public static void main(String... args) throws ParseException,
	// EmailException {
	//
	// JobService service = new JobService();
	// String messageBody = "";
	// //
	// // service.generateReport("select * from employee");
	//
	// List<ReportScheuduleEntity> data = service.fetchDetails();
	// // System.out.println(data.size());
	// for(ReportScheuduleEntity entity:data){
	// messageBody=service.processRecord(entity);
	// service.sendMail(messageBody, entity.getMailId());
	// }
	// }

	public void executeService() throws EmailException, ParseException {

		String messageBody = "";
		List<ReportScheuduleEntity> data = fetchDetails();
		// System.out.println(data.size());
		for (ReportScheuduleEntity entity : data) {
			messageBody = processRecord(entity);
			sendMail(messageBody, entity.getMailId());
		}
	}

	@SuppressWarnings("unchecked")
	public List<ReportScheuduleEntity> fetchDetails() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ReportScheuduleEntity.class);
		List<ReportScheuduleEntity> data = criteria.list();
		session.close();
		// System.out.println(data);
		return data;
	}

	private String processRecord(ReportScheuduleEntity entity)
			throws ParseException {
		SimpleDateFormat formatter = null;
		String frequency = entity.getFrequency();
		Date curDate = new Date();
		String data = null;

		String inputDateString = entity.getDateTime().replace('T', ' ');
		formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		Date inputDate = formatter.parse(inputDateString);
		if (frequency.equals(Frequency.DAILY.getFlag())) {
			formatter = new SimpleDateFormat("kk:mm");
			if (formatter.format(curDate).equals(formatter.format(inputDate))) {
				System.out.println("daily match-->id" + entity.getId());
				data = generateReport(entity.getQuery());
			}
		} else if (frequency.equals(Frequency.WEEKLY.getFlag())) {
			formatter = new SimpleDateFormat("EEEE, kk:mm");
			if (formatter.format(curDate).equals(formatter.format(inputDate))) {
				System.out.println("weekly match");
				data = generateReport(entity.getQuery());
			}
		} else if (frequency.equals(Frequency.MONTHLY.getFlag())) {
			formatter = new SimpleDateFormat("dd kk:mm");
			if (formatter.format(curDate).equals(formatter.format(inputDate))) {
				System.out.println("monthly match");
				data = generateReport(entity.getQuery());
			}
		} else if (frequency.equals(Frequency.YEARLY.getFlag())) {
			formatter = new SimpleDateFormat("dd-MM kk:mm");
			System.out.println("day of year:" + formatter.format(inputDate));
			if (formatter.format(curDate).equals(formatter.format(inputDate))) {
				System.out.println("yearly match");
				data = generateReport(entity.getQuery());
			}
		}

		// System.out.println("process Record:"+data);
		return data;
	}

	String generateReport(String queryString) {
		List<Map<String, Object>> aliasToValueMapList = null;
		StringBuilder htmlData = new StringBuilder("");
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(queryString);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		try {
			aliasToValueMapList = query.list();
		} catch (Exception exception) {
			System.out.println(exception.toString());
		}
		session.close();
		// System.out.println("before report generation");
		if (aliasToValueMapList.isEmpty() != true) {
			// System.out.println(aliasToValueMapList);
			htmlData = new StringBuilder("<table style=\"width:30%\"><tr>");
			for (String key : aliasToValueMapList.get(0).keySet()) {
				htmlData.append("<th>");
				htmlData.append(key.substring(0, 1).toUpperCase()
						+ key.substring(1).toLowerCase());
				htmlData.append("</th>");
			}
			htmlData.append("</tr>");

			for (Map<String, Object> map : aliasToValueMapList) {
				htmlData.append("<tr>");
				Iterator itr = map.entrySet().iterator();
				while (itr.hasNext()) {
					Map.Entry pair = (Map.Entry) itr.next();
					htmlData.append("<td>");
					htmlData.append(pair.getValue() == null ? "" : pair
							.getValue());
					htmlData.append("</td>");
				}
				htmlData.append("</tr>");
			}
			htmlData.append("</table>");
		}
		// System.out.println("HtmlData:"+htmlData);

		return htmlData.toString();
	}

	private void sendMail(String body, String reciever) throws EmailException {
		// System.out.println("in sendMail");
		// System.out.println("Body:"+body);
		// System.out.println("reciever:"+reciever);
		if ((!"".equals(body) && body != null)
				&& (!"".equals(reciever) && reciever != null)) {
			// System.out.println("inside sendMail if condition");
			HtmlEmail mail = new HtmlEmail();
			mail.setDebug(false);
			mail.setHostName("smtp.gmail.com");
			mail.setSmtpPort(465);
			mail.setAuthenticator(new DefaultAuthenticator(
					"mnreddy.nv@gmail.com", "xmsbzntaabjeeweg"));
			mail.setSSLOnConnect(true);
			mail.setFrom("mnreddy.nv@gmail.com");
			mail.setSubject("Report");
			mail.setHtmlMsg(body);
			mail.addTo(new String[] { reciever });
			mail.addCc(new String[] { "mnreddy.nv@gmail.com" });
			mail.send();
		}
	}

}
