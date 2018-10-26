package com.rob.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rob.model.Candidate;
import com.rob.model.JobCandidate;
import com.rob.model.JobPost;

@Repository(value = "jobCandidateDaoImpl")
public class JobCandidateDaoImpl implements JobCandidateDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public boolean updateJobCandidateRecords(List<JobCandidate> jobCandidates) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE jobcandidate SET ");
		sql.append("jc_jp_id =:jc_jp_id, ");
		sql.append("jc_cdt_id =:jc_cdt_id, ");
		sql.append("jc_stage =:jc_stage, ");
		sql.append("jc_notes =:jc_notes ");
		sql.append("WHERE jc_id =:jc_id");

		List<Map<String, Object>> batchValues = new ArrayList<>(jobCandidates.size());
		jobCandidates.forEach(jobCandidate -> {
			batchValues.add(new MapSqlParameterSource("jc_id", jobCandidate.getId())
					.addValue("jc_jp_id", jobCandidate.getJobPost().getId())
					.addValue("jc_cdt_id", jobCandidate.getCandidate().getId())
					.addValue("jc_stage", jobCandidate.getStage()).addValue("jc_notes", jobCandidate.getNotes())
					.getValues());

		});

		namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchValues.toArray(new Map[jobCandidates.size()]));
		return true;
	}

	@Override
	public boolean removeJobCandidateRecords(List<Integer> jobCandidateIds) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM jobcandidate ");
		sql.append("WHERE jc_id =:jc_id");

		List<Map<String, Object>> batchValues = new ArrayList<>(jobCandidateIds.size());
		jobCandidateIds.forEach(jobCandidateId -> {
			batchValues.add(new MapSqlParameterSource("jc_id", jobCandidateId.intValue()).getValues());

		});

		namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchValues.toArray(new Map[jobCandidateIds.size()]));
		return true;
	}

	@Override
	public List<JobCandidate> listJobCandidateRecordsByJobPostId(int jobPostId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM jobcandidate WHERE jc_jp_id =:jc_jp_id");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("jc_jp_id", jobPostId);

		return namedParameterJdbcTemplate.query(sql.toString(), paramMap, new JobCandidateRowMapper());
	}

	@Override
	public boolean createJobCandidateRecords(List<JobCandidate> jobCandidates) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO jobcandidate ");
		sql.append("(");
		sql.append("jc_id, jc_jp_id, jc_cdt_id, jc_stage, jc_notes");
		sql.append(")");
		sql.append("VALUES ");
		sql.append("(");
		sql.append(":jc_id, :jc_jp_id, :jc_cdt_id, :jc_stage, :jc_notes");
		sql.append(")");

		List<Map<String, Object>> batchValues = new ArrayList<>(jobCandidates.size());
		jobCandidates.forEach(jobCandidate -> {
			batchValues.add(new MapSqlParameterSource("jc_id", jobCandidate.getId())
					.addValue("jc_jp_id", jobCandidate.getJobPost().getId())
					.addValue("jc_cdt_id", jobCandidate.getCandidate().getId())
					.addValue("jc_stage", jobCandidate.getStage()).addValue("jc_notes", jobCandidate.getNotes())
					.getValues());

		});

		namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchValues.toArray(new Map[jobCandidates.size()]));
		return true;
	}

	private static class JobCandidateRowMapper implements RowMapper<JobCandidate> {

		@Override
		public JobCandidate mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobCandidate jobCandidate = new JobCandidate();
			JobPost jobPost = new JobPost();
			jobPost.setId(rs.getInt("jc_jp_id"));

			Candidate candidate = new Candidate();
			candidate.setId(rs.getInt("jc_cdt_id"));

			jobCandidate.setId(rs.getInt("jc_id"));
			jobCandidate.setCandidate(candidate);
			jobCandidate.setStage(rs.getString("jc_stage"));
			jobCandidate.setNotes(rs.getString("jc_notes"));
			jobCandidate.setJobPost(jobPost);

			return jobCandidate;
		}

	}

}
