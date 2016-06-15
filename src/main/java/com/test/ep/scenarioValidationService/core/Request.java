package com.test.ep.scenarioValidationService.core;

import io.dropwizard.jackson.JsonSnakeCase;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

/**
 * Created by neha.seth on 13/06/16.
 */
@NoArgsConstructor
@Entity
@Table(name = "requests")
@JsonSnakeCase
public class Request extends BaseEntity {
	@Id
	@Column(name = "request_id")
	private int id;

	@Column(name = "parent_request_id")
	private int parentRequestId;

	@NotNull
	@Column(name = "replay_id")
	private int replayId;

	@NotNull
	@Column(name = "http_method")
	private String httpMethod;

	@NotNull
	@Column(name = "http_uri")
	private String httpUri;

	@Column(name = "request_body")
	private int requestBody;

	@Column(name = "custom_headers")
	private String customHeaders;

	@Column
	private int relayed;

	@Column(name = "relayed_at")
	private LocalDateTime relayedAt;

	@Column(name = "response_code")
	private String responseCode;

	@Column(name = "response_body")
	private String responseBody;

}
