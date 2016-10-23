package org.mnr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.mnr.entity.LoginEntity;
import org.mnr.entity.ReportScheuduleEntity;
import org.mnr.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

	@RequestMapping(value = "*", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("* controller");
		ModelAndView model = new ModelAndView("LoginPage");
		LoginEntity loginEntity = new LoginEntity();
		model.addObject("loginEntity", loginEntity);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid LoginEntity loginEntity, BindingResult bind) {
		System.out.println("login controller");
		ModelAndView modelAndView = new ModelAndView("LoginPage");
		if (bind.hasErrors())
			return modelAndView;
		else {

			modelAndView = new ModelAndView(new RedirectView("/schedule", true));
			modelAndView.addObject("reportScheuduleEntity",
					new ReportScheuduleEntity());
		}

		return modelAndView;
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
		// System.out.println("saveSchedule method");
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
