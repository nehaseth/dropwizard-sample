package com.test.dropwizard.sample.resource;

import com.google.inject.Inject;
import com.test.dropwizard.sample.core.Replay;
import com.test.dropwizard.sample.dao.ReplayDAO;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by neha.seth on 14/06/16.
 */
@Slf4j
@Path("/replays")
public class ReplayResource {

	private ReplayDAO replayDAO;

	@Inject
	public ReplayResource(ReplayDAO replayDAO) {
		this.replayDAO = replayDAO;
	}

	@GET
	@UnitOfWork
	@Produces(MediaType.APPLICATION_JSON)
	public List<Replay> findAll(){
		return replayDAO.findAll();
	}

	@GET
	@UnitOfWork
	@Path("/{replayId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Replay> findByReplayId(@PathParam("replayId") long replayId){
		return replayDAO.findByReplayId(replayId);
	}

}
