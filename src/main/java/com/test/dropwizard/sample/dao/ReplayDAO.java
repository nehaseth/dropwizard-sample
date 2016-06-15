package com.test.dropwizard.sample.dao;

import com.test.dropwizard.sample.core.Replay;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * Created by neha.seth on 14/06/16.
 */
public class ReplayDAO extends AbstractDAO<Replay> {

	@Inject
	public ReplayDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Replay> findAll() {
		return list(namedQuery("com.test.ep.dropwizardSample.core.Replay.findAllReplays"));
	}

	public List<Replay> findRequestsForReplayId(Long replayId) {
		return list(namedQuery("com.test.ep.dropwizardSample.core.Replay.findByReplayId")
				.setParameter("replayId", replayId));
	}
}
