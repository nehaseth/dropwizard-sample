package com.test.dropwizard.sample.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.dropwizard.sample.constants.CommonConstants;
import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Type;

/**
 * Created by neha.seth on 13/06/16.
 */
@MappedSuperclass
@Getter
public abstract class BaseEntity implements Serializable {
	@JsonIgnore
	@Column(name = "created_at", updatable = false, nullable = false)
	@Type(type = CommonConstants.LOCALDATETIME_PERSISTER)
	protected final LocalDateTime createdAt;

	@JsonIgnore
	@Column(name = "updated_at", insertable = false, updatable = false)
	@Type(type = CommonConstants.LOCALDATETIME_PERSISTER)
	protected LocalDateTime updatedAt;

	public BaseEntity() {
		this.createdAt = LocalDateTime.now(Clock.systemUTC());
	}
}

