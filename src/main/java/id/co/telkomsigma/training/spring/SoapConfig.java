package id.co.telkomsigma.training.spring;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import id.co.telkomsigma.training.spring.ws.soap.TwitterUserSoapService;
import id.co.telkomsigma.training.spring.ws.soap.TwitterUserSoapServiceImpl;



@Configuration
public class SoapConfig {

	/** SOAP producer **/

	@Bean
	public TwitterUserSoapService twitterSoapService() {
		return new TwitterUserSoapServiceImpl();
	}
	
	@Bean
	public ServletRegistrationBean cxfDispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		SpringBus springBus = new SpringBus();
		return springBus;
	}

	@Bean
	public Endpoint sukaSuka1() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), twitterSoapService());
		endpoint.getFeatures().add(new LoggingFeature());
		endpoint.publish("/TwitterService");
		return endpoint;
	}
	
	@Bean
	public Endpoint sukaSuka2() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), twitterSoapService());
		endpoint.getFeatures().add(new LoggingFeature());
		endpoint.publish("/TwitterService2");
		return endpoint;
	}
	
	
}

















