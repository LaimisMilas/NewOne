package lt.iamus.task.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OraiSpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class [] {OraiConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] {"/"};
	}
	

}
