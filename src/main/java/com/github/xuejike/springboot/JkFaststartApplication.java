package com.github.xuejike.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class JkFaststartApplication {

	public static void main(String[] args) {
		SpringApplication.run(JkFaststartApplication.class, args);
	}
	/**
	 * 自定义异常页
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {
			ErrorPage error401Page = new ErrorPage(HttpStatus.FORBIDDEN,
					"/403.html");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,
					"/404.html");
			ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
					"/500.html");
			container.addErrorPages(error401Page, error500Page);
		});
	}


}
