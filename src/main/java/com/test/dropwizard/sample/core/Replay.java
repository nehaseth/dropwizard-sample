package com.test.dropwizard.sample.core;

import io.dropwizard.jackson.JsonSnakeCase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by neha.seth on 13/06/16.
 */
@Data
@Entity
@NoArgsConstructor
@JsonSnakeCase
@Table(name = "replays")
public class Replay extends BaseEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "replay_id")
	private Long replayId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "request_id", referencedColumnName = "request_id", nullable = false)
	private Request requestId;

}
