package com.test.ep.scenarioValidationService.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 * Created by neha.seth on 10/06/16.
 */
@Getter
public class ValidationServiceConfiguration extends Configuration {

	@Valid
	@NotNull
	@JsonProperty("validatorDatabase")
	public DataSourceFactory databaseConfiguration;

}
