package com.test.ep.scenarioValidationService;


import com.test.ep.scenarioValidationService.configuration.ValidationServiceConfiguration;
import com.test.ep.scenarioValidationService.core.Replay;
import com.test.ep.scenarioValidationService.core.Request;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;

/**
 * Created by neha.seth on 13/06/16.
 */
@Slf4j
public class ValidationServiceModule extends AbstractModule {

	private static final HibernateBundle<ValidationServiceConfiguration> hibernateBundle =
			new HibernateBundle<ValidationServiceConfiguration>(Replay.class, Request.class) {
				@Override
				public DataSourceFactory getDataSourceFactory(ValidationServiceConfiguration configuration) {
					return configuration.getDatabaseConfiguration();
				}
			};

	@Override
	protected void configure() {
	}

	@Provides
	public DataSourceFactory providesDataSourceFactory(ValidationServiceConfiguration configuration) {
		return configuration.getDatabaseConfiguration();
	}


	@Provides
	@Singleton
	public HibernateBundle<ValidationServiceConfiguration> getHibernateBundle() {
		return hibernateBundle;
	}

	@Provides
	@Singleton
	public static SessionFactory getSessionFactory() {
		return hibernateBundle.getSessionFactory();
	}

//	public void setSessionFactory(SessionFactory sessionFactory){
//		this.sessionFactory = sessionFactory;
//	}

}
