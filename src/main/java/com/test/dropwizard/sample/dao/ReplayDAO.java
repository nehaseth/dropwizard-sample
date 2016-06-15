package com.test.dropwizard.sample.dao;

import com.google.inject.Inject;
import com.test.dropwizard.sample.core.Replay;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 * Created by neha.seth on 14/06/16.
 */
@Slf4j
public class ReplayDAO extends AbstractDAO<Replay> {

	@Inject
	public ReplayDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<Replay> findAll() {
		currentSession().beginTransaction();
		Query query = currentSession().createQuery("from Replay");
		List<Replay> replays = castList(query);
		log.info("query running in Replay table : " + query.getQueryString());
		currentSession().getTransaction().commit();
		return replays;
	}

	public List<Replay> findByReplayId(Long replayId) {
		currentSession().beginTransaction();
		Query query = currentSession().createQuery("from Replay where replayId= :replayId");
		query.setParameter("replayId", replayId);
		List<Replay> replays = castList(query);
		currentSession().getTransaction().commit();
		return replays;
	}

	public static <T> List<T> castList(Query q) {
		return q.list();
	}
}
