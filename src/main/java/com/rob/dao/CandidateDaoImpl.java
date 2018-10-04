package com.rob.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rob.custom.exceptions.RecordNotFoundException;
import com.rob.model.Candidate;

@Repository(value = "candidateDaoImpl")
public class CandidateDaoImpl implements CandidateDao {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Candidate getCandidateById(String candidateId) {
		LOGGER.debug("candidateId:" + candidateId);
		String sql = "SELECT * FROM candidate WHERE cdt_id =:cdt_id";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cdt_id", candidateId);

		List<Candidate> candidates = namedParameterJdbcTemplate.query(sql, paramMap, new CandidateRowMapper());
		// if no candidates found
		if (candidates.isEmpty())
			throw new RecordNotFoundException("Candidate with id:" + candidateId + " not found.");
		// if only one candidate found
		else if (candidates.size() == 1)
			return candidates.get(0);
		// if more than one candidate found or any other unintentional flow occurs
		else
			throw new RuntimeException();

	}

	@Override
	public boolean createCandidate(Candidate candidate) {

		LOGGER.debug("Candidate: " + candidate.toString());

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(
				"candidate (cdt_id, cdt_first_name, cdt_last_name, cdt_email, cdt_passport, cdt_last_designation, cdt_date_of_birth, cdt_gender, cdt_marital_status, cdt_created_date, cdt_updated_date) ");
		sql.append(
				"values(:cdt_id, :cdt_first_name, :cdt_last_name, :cdt_email, :cdt_passport, :cdt_last_designation, :cdt_date_of_birth, :cdt_gender, :cdt_marital_status, :cdt_created_date, :cdt_updated_date)");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cdt_id", candidate.getId());
		paramMap.put("cdt_first_name", candidate.getFirstName());
		paramMap.put("cdt_last_name", candidate.getLastName());
		paramMap.put("cdt_email", candidate.getEmail());
		paramMap.put("cdt_passport", candidate.getPassportNumber());
		paramMap.put("cdt_last_designation", candidate.getLastDesignation());
		paramMap.put("cdt_date_of_birth", candidate.getDateOfBirth());
		paramMap.put("cdt_gender", candidate.getGender());
		paramMap.put("cdt_marital_status", candidate.getMaritalStatus());
		paramMap.put("cdt_created_date", candidate.getCreatedDate());
		paramMap.put("cdt_updated_date", candidate.getUpdatedDate());

		return namedParameterJdbcTemplate.update(sql.toString(), paramMap) == 1;

	}

	@Override
	public boolean updateCandidate(Candidate candidate) {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE candidate ");
		sql.append(
				"SET cdt_first_name= :cdt_first_name, cdt_last_name= :cdt_last_name, cdt_email= :cdt_email, cdt_passport= :cdt_passport, cdt_last_designation= :cdt_last_designation, cdt_date_of_birth= :cdt_date_of_birth, cdt_gender= :cdt_gender, cdt_marital_status= :cdt_marital_status, cdt_updated_date= :cdt_updated_date ");
		sql.append("WHERE cdt_id = :cdt_id");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cdt_id", candidate.getId());
		paramMap.put("cdt_first_name", candidate.getFirstName());
		paramMap.put("cdt_last_name", candidate.getLastName());
		paramMap.put("cdt_email", candidate.getEmail());
		paramMap.put("cdt_passport", candidate.getPassportNumber());
		paramMap.put("cdt_last_designation", candidate.getLastDesignation());
		paramMap.put("cdt_date_of_birth", candidate.getDateOfBirth());
		paramMap.put("cdt_gender", candidate.getGender());
		paramMap.put("cdt_marital_status", candidate.getMaritalStatus());
		paramMap.put("cdt_updated_date", candidate.getUpdatedDate());

		return namedParameterJdbcTemplate.update(sql.toString(), paramMap) == 1;

	}

	@Override
	public boolean deleteCandidateById(String candidateId) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM candidate WHERE cdt_id = :cdt_id");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cdt_id", candidateId);
		return namedParameterJdbcTemplate.update(sql.toString(), paramMap) == 1;

	}

	private static final class CandidateRowMapper implements RowMapper<Candidate> {

		@Override
		public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
			Candidate candidate = new Candidate();
			candidate.setCreatedDate(rs.getTimestamp("cdt_created_date").toLocalDateTime());
			candidate.setDateOfBirth(rs.getDate("cdt_date_of_birth").toLocalDate());
			candidate.setEmail(rs.getString("cdt_email"));
			candidate.setFirstName(rs.getString("cdt_first_name"));
			candidate.setGender(rs.getString("cdt_gender"));
			candidate.setId(rs.getString("cdt_id"));
			candidate.setLastDesignation(rs.getString("cdt_last_designation"));
			candidate.setLastName(rs.getString("cdt_last_name"));
			candidate.setMaritalStatus(rs.getString("cdt_marital_status"));
			candidate.setPassportNumber(rs.getString("cdt_passport"));
			candidate.setUpdatedDate(rs.getTimestamp("cdt_updated_date").toLocalDateTime());
			return candidate;
		}

	}

}
