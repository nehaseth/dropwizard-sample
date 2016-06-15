package com.test.dropwizard.sample.resource;

import com.google.inject.Inject;
import com.test.dropwizard.sample.core.Replay;
import com.test.dropwizard.sample.dao.ReplayDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by neha.seth on 14/06/16.
 */
@Path("/replays")
public class ReplayResource {

	private ReplayDAO replayDAO;

	@Inject
	public ReplayResource(ReplayDAO replayDAO) {
		this.replayDAO = replayDAO;
	}

	@GET
	@UnitOfWork
	public List<Replay> findAll(@QueryParam("replayId") long replayId){
			return replayDAO.findRequestsForReplayId(replayId);
	}

}
