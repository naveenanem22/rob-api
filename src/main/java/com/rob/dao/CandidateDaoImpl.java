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

import com.rob.custom.exceptions.CandidateNotFoundException;
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
		if(candidates.isEmpty())
			throw new CandidateNotFoundException("Candidate with id:"+candidateId+" not found.");
		else if(candidates.size()==1)
			return candidates.get(0);
		else
			throw new RuntimeException();

	}

	@Override
	public boolean createCandidate(Candidate candidate) {

		LOGGER.debug("Candidate: " + candidate.toString());

		StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT into candidate values('CDT002', 'Kailash', 'Krishna', 'kk@kony.com', 'JJ225565', 'Technical Lead', '1986-10-10', 'Male', 'Married', '2018-06-15 14:41:59', '2018-07-21 13:47:48')");
		Map<String, Object> paramMap = new HashMap<String, Object>();
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
