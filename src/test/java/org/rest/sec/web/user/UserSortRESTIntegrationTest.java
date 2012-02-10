package org.rest.sec.web.user;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.rest.sec.dto.User;
import org.rest.sec.testing.template.UserRESTTemplateImpl;
import org.rest.spring.application.ApplicationTestConfig;
import org.rest.spring.persistence.jpa.PersistenceJPAConfig;
import org.rest.web.common.AbstractSortRESTIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.google.common.collect.Ordering;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationTestConfig.class, PersistenceJPAConfig.class },loader = AnnotationConfigContextLoader.class )
@Ignore( "user and principal work is still in progress" )
public class UserSortRESTIntegrationTest extends AbstractSortRESTIntegrationTest< User >{
	
	@Autowired
	private UserRESTTemplateImpl template;
	
	// tests
	
	// template method (shortcuts)
	
	@Override
	protected final User createNewEntity(){
		return template.createNewEntity();
	}
	
	@Override
	protected final String getURI(){
		return template.getURI();
	}
	
	@Override
	protected final UserRESTTemplateImpl getTemplate(){
		return template;
	}
	
	@Override
	protected final Ordering< User > getOrdering(){
		return new Ordering< User >(){
			@Override
			public final int compare( final User left, final User right ){
				return left.getName().compareTo( right.getName() );
			}
		};
	}
	
}
