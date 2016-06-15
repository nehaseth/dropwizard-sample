package com.test.dropwizard.sample.resource;

import com.google.inject.Inject;
import io.dropwizard.db.DataSourceFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by neha.seth on 10/06/16.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class DefaultResource {
	Logger log = LoggerFactory.getLogger(DefaultResource.class);

	private DataSourceFactory sourceFactory;

	@Inject
	public DefaultResource(DataSourceFactory dataSourceFactory) {
		this.sourceFactory = dataSourceFactory;
	}

	@GET
	public String printDetails() {
		log.info("logging db url " + sourceFactory.getUrl() );
		return "test db : " + sourceFactory.getUrl();
	}

}
