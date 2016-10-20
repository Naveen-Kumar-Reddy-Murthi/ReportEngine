package org.mnr.controller;

import javax.validation.Valid;

import org.mnr.entity.ReportScheuduleEntity;
import org.mnr.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Naveen Reddy
 * @version 1.0
 */

@Controller
public class ReportController {
	
	
	private ReportService reportService;

	@Autowired
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	@RequestMapping(value = "/schedule")
	public ModelAndView scheduleReport(
			ReportScheuduleEntity reportScheuduleEntity) {
		return new ModelAndView("schedule");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveSchedule(
			@Valid ReportScheuduleEntity reportScheuduleEntity,
			BindingResult bind) {
		System.out.println("saveSchedule method");
		ModelAndView modelAndView = new ModelAndView("schedule");
		if (bind.hasErrors())
			return modelAndView;
		else {
			System.out.println("data:" + reportScheuduleEntity);
			
			reportService.saveOrUpdate(reportScheuduleEntity);
			
			reportScheuduleEntity = null;
			String message = "Data saved successfully!";
			modelAndView.addObject("message", message);
			modelAndView.addObject("reportScheuduleEntity",
					 new ReportScheuduleEntity());
			return modelAndView;
		}
	}
}
