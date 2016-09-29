package com.yitianyigexiangfa.spark.freemarker;

import java.io.IOException;
import java.io.StringWriter;

import spark.ModelAndView;
import spark.TemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTemplateEngine extends TemplateEngine {

	private Configuration configuration;
	
	public FreeMarkerTemplateEngine() {
		this.configuration = createFreemarkerConfiguration();
	}


	@Override
	public String render(ModelAndView modelAndView) {
		try {
			StringWriter stringWriter = new StringWriter();
			Template template = configuration.getTemplate(modelAndView.getViewName());
			template.process(modelAndView.getModel(), stringWriter);
			return stringWriter.toString();
		} catch (IOException e) {
			throw new IllegalArgumentException();
		}catch (TemplateException e) {
			throw new IllegalArgumentException();
		}
	}

	
	private Configuration createFreemarkerConfiguration() {
		Configuration retVal = new Configuration();
		retVal.setClassForTemplateLoading(FreeMarkerTemplateEngine.class, "freemarker");
		return retVal;
	}
}
