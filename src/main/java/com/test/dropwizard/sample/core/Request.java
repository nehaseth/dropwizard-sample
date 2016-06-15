package com.test.dropwizard.sample.core;

import com.test.dropwizard.sample.constants.CommonConstants;
import io.dropwizard.jackson.JsonSnakeCase;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

/**
 * Created by neha.seth on 13/06/16.
 */
@Data
@NoArgsConstructor
@Entity
@JsonSnakeCase
@Table(name = "requests")
public class Request {
	@Id
	@Column(name = "request_id")
	private Long id;

	@Column(name = "parent_request_id")
	private Long parentRequestId;

	@NotNull
	@Column(name = "http_method")
	private String httpMethod;

	@NotNull
	@Column(name = "http_uri")
	private String httpUri;

	@Column(name = "request_body")
	private String requestBody;

	@Column(name = "custom_headers")
	private String customHeaders;

	@Column
	private int relayed;

	@Column(name = "relayed_at", insertable = false, updatable = false)
	@Type(type = CommonConstants.LOCALDATETIME_PERSISTER)
	private LocalDateTime relayedAt;

	@Column(name = "response_code")
	private String responseCode;

	@Column(name = "response_body")
	private String responseBody;

}
