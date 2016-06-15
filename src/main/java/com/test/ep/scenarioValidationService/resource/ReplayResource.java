package com.test.ep.scenarioValidationService.resource;

import com.test.ep.scenarioValidationService.core.Replay;
import com.test.ep.scenarioValidationService.dao.ReplayDAO;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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
	public List<Replay> findAll(@QueryParam("replayId") Optional<Long> replayId){
		if(replayId.isPresent())
			return replayDAO.findRequestsForReplayId(replayId.get());
		else
			return replayDAO.findAll();
	}

}
