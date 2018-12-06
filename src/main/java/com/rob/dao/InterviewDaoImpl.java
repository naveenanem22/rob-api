package com.rob.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pc.custom.exceptions.InternalServerException;
import com.pc.custom.exceptions.RecordNotFoundException;
import com.rob.model.Interview;
import com.rob.model.JobCandidate;

@Repository(value = "interviewDaoImpl")
public class InterviewDaoImpl implements InterviewDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public Interview getInterviewById(int interviewId) {
		List<Interview> results = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM interview WHERE intvw_id =:intvw_id");
			LOGGER.debug("Query: " + sql.toString());
			LOGGER.debug("Parameters: ");
			LOGGER.debug("intvw_id: " + interviewId);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("intvw_id", interviewId);
			results = namedParameterJdbcTemplate.query(sql.toString(), paramMap, new InterviewRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new InternalServerException("Unexpected error occurred while fetching the Interview details.");
		}
		if (results.size() == 0)
			throw new RecordNotFoundException("No Interview record with the id: " + interviewId + " found.");
		else if (results.size() == 1)
			return results.get(0);
		else
			throw new InternalServerException("Unexpected error occurred while fetching the Interview details.");

	}

	@Override
	public boolean createInterview(Interview interview) {
		int numberOfRowsAffected;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO interview ");
			sql.append("(");
			sql.append("intvw_id, intvw_jc_id, intvw_starttime_of_interview, ");
			sql.append("intvw_endtime_of_interview, intvw_level_of_interview, ");
			sql.append("intvw_type_of_inteview, intvw_interview_status, intvw_notes");
			sql.append(")");
			sql.append("VALUES ");
			sql.append("(");
			sql.append(":intvw_id, :intvw_jc_id, :intvw_starttime_of_interview, ");
			sql.append(":intvw_endtime_of_interview, :intvw_level_of_interview, ");
			sql.append(":intvw_type_of_inteview, :intvw_interview_status, :intvw_notes");
			sql.append(")");

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("intvw_id", interview.getId());
			paramMap.put("intvw_jc_id", interview.getJobCandidate().getId());
			paramMap.put("intvw_starttime_of_interview", interview.getStartTime());
			paramMap.put("intvw_endtime_of_interview", interview.getEndTime());
			paramMap.put("intvw_level_of_interview", interview.getLevelOfInterview());
			paramMap.put("intvw_type_of_inteview", interview.getTypeOfInterview());
			paramMap.put("intvw_interview_status", interview.getStatus());
			paramMap.put("intvw_notes", interview.getNotes());

			numberOfRowsAffected = namedParameterJdbcTemplate.update(sql.toString(), paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerException("Unexpected exception occured while creating Interview record.");
		}

		if (numberOfRowsAffected == 1)
			return true;
		else
			throw new InternalServerException("Unexpected exception occured while creating Interview record.");

	}

	@Override
	public boolean updateInterviewById(Interview interview) {
		int numberOfRowsAffected;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE interview SET ");
			sql.append("intvw_jc_id =:intvw_jc_id, ");
			sql.append("intvw_starttime_of_interview =:intvw_starttime_of_interview, ");
			sql.append("intvw_endtime_of_interview =:intvw_endtime_of_interview, ");
			sql.append("intvw_level_of_interview =:intvw_level_of_interview, ");
			sql.append("intvw_type_of_inteview =:intvw_type_of_inteview, ");
			sql.append("intvw_interview_status =:intvw_interview_status, ");
			sql.append("intvw_notes =:intvw_notes ");
			sql.append("WHERE intvw_id =:intvw_id");

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("intvw_jc_id", interview.getJobCandidate().getId());
			paramMap.put("intvw_starttime_of_interview", interview.getStartTime());
			paramMap.put("intvw_endtime_of_interview", interview.getEndTime());
			paramMap.put("intvw_level_of_interview", interview.getLevelOfInterview());
			paramMap.put("intvw_type_of_inteview", interview.getTypeOfInterview());
			paramMap.put("intvw_interview_status", interview.getStatus());
			paramMap.put("intvw_notes", interview.getNotes());
			paramMap.put("intvw_id", interview.getId());

			numberOfRowsAffected = namedParameterJdbcTemplate.update(sql.toString(), paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerException(
					"Unexpected error occured while updating Interview record with id: " + interview.getId());
		}
		if (numberOfRowsAffected == 1)
			return true;
		else if (numberOfRowsAffected == 0)
			throw new RecordNotFoundException("No interview record found with the provided details.");
		else
			throw new InternalServerException(
					"Unexpected error occured while updating Interview record with id: " + interview.getId());

	}

	@Override
	public boolean removeInterviewById(int interviewId) {
		int numberOfRowsAffected;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM interview ");
			sql.append("WHERE intvw_id =:intvw_id");
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("intvw_id", interviewId);

			numberOfRowsAffected = namedParameterJdbcTemplate.update(sql.toString(), paramMap);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new InternalServerException(
					"Unexpected error occured while deleting Interview record with id: " + interviewId);
		}

		if (numberOfRowsAffected == 1)
			return true;
		else if (numberOfRowsAffected == 0)
			throw new RecordNotFoundException("No Interview record found with the ID: " + interviewId);
		else
			throw new InternalServerException(
					"Unexpected error occured while deleting Interview record with id: " + interviewId);

	}

	private final class InterviewRowMapper implements RowMapper<Interview> {

		@Override
		public Interview mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobCandidate jobCandidate = new JobCandidate();
			jobCandidate.setId(rs.getInt("intvw_jc_id"));
			Interview interview = new Interview();
			interview.setEndTime(rs.getTimestamp("intvw_endtime_of_interview").toLocalDateTime());
			interview.setId(rs.getInt("intvw_id"));
			interview.setJobCandidate(jobCandidate);
			interview.setLevelOfInterview(rs.getString("intvw_level_of_interview"));
			interview.setNotes(rs.getString("intvw_notes"));
			interview.setStartTime(rs.getTimestamp("intvw_starttime_of_interview").toLocalDateTime());
			interview.setStatus(rs.getString("intvw_interview_status"));
			interview.setTypeOfInterview(rs.getString("intvw_type_of_inteview"));
			return interview;
		}

	}

}
