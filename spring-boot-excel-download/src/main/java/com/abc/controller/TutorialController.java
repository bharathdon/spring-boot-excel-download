package com.abc.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.model.Tutorial;
import com.abc.service.TutorialService;

@RestController
public class TutorialController {

	@Autowired
	private TutorialService service;

	@RequestMapping(path = "/export", method = RequestMethod.GET)
	public void exportToExcel(HttpServletResponse response) throws IOException {

		response.setContentType("application/octet-stream");

		String headerKey = "content-Disposition";
		String headerValue = "attachment; filename=t1.xlsx";

		response.setHeader(headerKey, headerValue);

		List<Tutorial> listUsers = service.findAll();

		TutorialExcelExporter tutorialExcelExporter = new TutorialExcelExporter(listUsers);
		tutorialExcelExporter.export(response);
	

	}
}
