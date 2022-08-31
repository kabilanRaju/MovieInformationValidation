package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generatejvmreports(String jsonfile) {

		File file = new File("C:\\Users\\nithya\\eclipse-workspace\\MovieInformationValidation\\target");
		
		Configuration configuration=new Configuration(file, "MovieInformationValidation");
		
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS", "WIN8");
		configuration.addClassifications("Version", "104");		
			
		List<String> jsonfiles=new ArrayList<String>();
		jsonfiles.add(jsonfile);
		ReportBuilder reportBuilder=new ReportBuilder(jsonfiles, configuration);
		
		reportBuilder.generateReports();	
	}
}
