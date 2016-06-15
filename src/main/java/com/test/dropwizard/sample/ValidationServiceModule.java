package com.test.dropwizard.sample;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.test.dropwizard.sample.configuration.ValidationServiceConfiguration;
import com.test.dropwizard.sample.core.Replay;
import com.test.dropwizard.sample.core.Request;
import com.test.dropwizard.sample.dao.ReplayDAO;
import com.test.dropwizard.sample.resource.ReplayResource;
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

    public HibernateBundle<ValidationServiceConfiguration> getHibernateBundle() {
        return hibernateBundle;
    }

    @Override
	protected void configure() {
		bind(ReplayDAO.class);
		bind(ReplayResource.class);
	}

	@Provides
	public static SessionFactory getSessionFactory() {
		return hibernateBundle.getSessionFactory();
	}
}
