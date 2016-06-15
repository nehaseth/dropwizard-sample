	package com.test.dropwizard.sample;

	import com.hubspot.dropwizard.guice.GuiceBundle;
	import com.test.dropwizard.sample.configuration.ValidationServiceConfiguration;
	import com.test.dropwizard.sample.resource.DefaultResource;
	import com.test.dropwizard.sample.resource.ReplayResource;
	import io.dropwizard.Application;
	import io.dropwizard.hibernate.HibernateBundle;
	import io.dropwizard.setup.Bootstrap;
	import io.dropwizard.setup.Environment;

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
			environment.jersey().register(guiceBundle.getInjector().getInstance(DefaultResource.class));
			environment.jersey().register(guiceBundle.getInjector().getInstance(ReplayResource.class));
		}

		public static void main(String[] args) throws Exception {
			new ValidationServiceApplication().run(args);
		}

	}
