package com.test.dropwizard.sample.core;

import io.dropwizard.jackson.JsonSnakeCase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

/**
 * Created by neha.seth on 13/06/16.
 */
@JsonSnakeCase
@NoArgsConstructor
@Entity
@Table(name = "replays")
@NamedQueries({
		@NamedQuery(name = "com.test.ep.dropwizardSample.core.Replay.findByReplayId",
				query = "select e from Replay e where e.replayId= :replayId" ),
		@NamedQuery(name = "com.test.ep.dropwizardSample.core.Replay.findAllReplays",
				query = "select e from Replay e")
}
)
public class Replay extends BaseEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "replay_id")
	private Long replayId;

	@NotNull
	@Column(name = "request_id")
	private Long requestId;

	public Replay(Long replayId, Long requestId) {
		this.replayId = replayId;
		this.requestId = requestId;
	}

}
