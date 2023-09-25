package hello.exception;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		org.springframework.boot.web.server.ErrorPage errorPage404 = new org.springframework.boot.web.server.ErrorPage(
				HttpStatus.NOT_FOUND, "/error-page/400");
		org.springframework.boot.web.server.ErrorPage errorPage500 = new org.springframework.boot.web.server.ErrorPage(
				HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");
		org.springframework.boot.web.server.ErrorPage errorPageEx = new org.springframework.boot.web.server.ErrorPage(
				RuntimeException.class, "/error-page/500");

		factory.addErrorPages(errorPage404, errorPage500, errorPageEx);

	}

}
