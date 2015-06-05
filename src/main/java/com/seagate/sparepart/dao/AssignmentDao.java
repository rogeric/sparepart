package com.seagate.sparepart.dao;

import java.util.List;

import com.seagate.sparepart.domain.Assignment;

public interface AssignmentDao {

	public void createAssignment(Assignment asn);
	public void releaseAssignment(int asnId, int releaserGid, String releaserName, String releaseDate);
	public List<Assignment> getAssignmentsAct();
	public List<Assignment> getAssignments();
	public Assignment getAssignment(int asnId);
	public List<Integer> getAssignmentsByHost(int hostOpId);
}
