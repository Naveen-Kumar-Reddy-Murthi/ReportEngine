package org.mnr.controller;

import javax.validation.Valid;

import org.mnr.entity.ReportScheuduleEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Naveen Reddy
 * @version 1.0
 */

@Controller
public class ReportController {
	
	@RequestMapping(value="/schedule")
	public ModelAndView scheduleReport(ReportScheuduleEntity reportScheuduleEntity){
		return new ModelAndView("schedule");
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveSchedule(@Valid ReportScheuduleEntity reportScheuduleEntity,BindingResult bind){
		System.out.println("saveSchedule method");
		ModelAndView modelAndView = new ModelAndView("schedule");
		if(bind.hasErrors())
			return modelAndView;
		else
		{
			System.out.println("data:"+reportScheuduleEntity);
			reportScheuduleEntity= new ReportScheuduleEntity();
			modelAndView.addObject("reportScheuduleEntity",reportScheuduleEntity);
			return new ModelAndView("schedule");
		}
	}
}
