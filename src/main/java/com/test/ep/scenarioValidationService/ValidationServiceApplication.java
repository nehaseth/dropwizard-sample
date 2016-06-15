package com.test.ep.scenarioValidationService;

import com.test.ep.scenarioValidationService.configuration.ValidationServiceConfiguration;
import com.test.ep.scenarioValidationService.resource.DefaultResource;
import com.test.ep.scenarioValidationService.resource.ReplayResource;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by neha.seth on 10/06/16.
 */
public class ValidationServiceApplication extends Application<ValidationServiceConfiguration> {

	GuiceBundle<ValidationServiceConfiguration> guiceBundle;
	private final ValidationServiceModule serviceModule = new ValidationServiceModule();
	private final HibernateBundle<ValidationServiceConfiguration> hibernateBundle = serviceModule.getHibernateBundle();

	@Override
	public void initialize(Bootstrap<ValidationServiceConfiguration> bootstrap) {
		guiceBundle = GuiceBundle.<ValidationServiceConfiguration>newBuilder()
				.addModule(serviceModule)
				.setConfigClass(ValidationServiceConfiguration.class)
				.build();
		bootstrap.addBundle(guiceBundle);
		bootstrap.addBundle(hibernateBundle);
	}

	@Override
	public void run(ValidationServiceConfiguration validationServiceConfiguration, Environment environment) throws Exception {
//		serviceModule.setSessionFactory(hibernateBundle.getSessionFactory());
		SessionFactory sessionFactory = ValidationServiceModule.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//
		environment.jersey().register(guiceBundle.getInjector().getInstance(DefaultResource.class));
		environment.jersey().register(guiceBundle.getInjector().getInstance(ReplayResource.class));
		transaction.commit();
	}

	public static void main(String[] args) throws Exception {
		new ValidationServiceApplication().run(args);
	}

}
