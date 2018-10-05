package com.rob.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rob.model.CandidateEducation;

@Repository(value = "candidateEducationDaoImpl")
public class CandidateEducationDaoImpl implements CandidateEducationDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<CandidateEducation> getCandidateEducaitonsByCandidateId(String candidateId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM candidateeducaiton WHERE ce_cdt_id =:ce_cdt_id");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ce_cdt_id", candidateId);
		return namedParameterJdbcTemplate.query(sql.toString(), paramMap, new CandidateEducationRowMapper());

	}

	@Override
	public boolean updateCandidateEducations(String candidateId, List<CandidateEducation> candidateEducations) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE candidateeducation SET ce_qualification_name =:ce_qualification_name, ");
		sql.append("ce_end_date = :ce_end_date, ce_score = :ce_score, ce_score_type = :ce_score_type, ");
		sql.append("ce_institution = :ce_institution, ce_specialization = :ce_specialization ");
		sql.append("WHERE ce_cdt_id = :ce_cdt_id && ce_start_date = :ce_start_date");
		
		List<Map<String, Object>> batchValues = new ArrayList<>(candidateEducations.size());
		candidateEducations.forEach(candidateEducation -> {
			batchValues.add(new MapSqlParameterSource("ce_end_date",candidateEducation.getQualEndDate())
					.addValue("ce_qualification_name", candidateEducation.getQualName())
					.addValue("ce_score",candidateEducation.getScore())
					.addValue("ce_score_type", candidateEducation.getScoreType())
					.addValue("ce_institution", candidateEducation.getInstitution())
					.addValue("ce_specialization", candidateEducation.getSpecialization())
					.addValue("ce_cdt_id", candidateId)
					.addValue("ce_start_date", candidateEducation.getQualStartDate())
					.getValues());
		});
		
		namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchValues.toArray(new Map[candidateEducations.size()]));
		/*Map<String, Object> paramMap1 = new HashMap<String, Object>();
		paramMap1.put("ce_end_date", candidateEducations.get(0).getQualEndDate());
		
		Map<String, Object> paramMap2 = new HashMap<String, Object>();
		paramMap2.put("ce_end_date", candidateEducations.get(1).getQualEndDate());
		
		List<Map<String, Object>> batchValues = new ArrayList<Map<String, Object>>();
		batchValues.add(paramMap1);
		batchValues.add(paramMap2);
		
		
		namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchValues.toArray(new Map[batchValues.size()]));*/
		
		
		
		
		
		
		
		
		
		/*Map<String, Object> paramMap = new HashMap<String, Object>();
		candidateEducations.forEach(candidateEducation -> {
			paramMap.put("ce_qualification_name", candidateEducation.getQualName());
			paramMap.put("ce_end_date", candidateEducation.getQualEndDate());
			paramMap.put("ce_score", candidateEducation.getScore());
			paramMap.put("ce_score_type",candidateEducation.getScoreType());
			paramMap.put("ce_institution", candidateEducation.getInstitution());
			paramMap.put("ce_specialization", candidateEducation.getSpecialization());
			
			namedParameterJdbcTemplate.update(sql.toString(), paramMap);
		});*/

		return true;
	}

	@Override
	public boolean createCandidateEducations(String candidateId, List<CandidateEducation> candidateEducaitons) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO candidateeducaiton ");
		sql.append("(ce_cdt_id, ce_qualification_name, ce_start_date, ce_end_date, ");
		sql.append("ce_score, ce_score_type, ce_institution, ce_specialization) ");
		sql.append("VALUES ");
		sql.append("(:ce_cdt_id, :ce_qualification_name, :ce_start_date, :ce_end_date, ");
		sql.append(":ce_score, :ce_score_type, :ce_institution, :ce_specialization)");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		candidateEducaitons.forEach(candidateEducation -> {
			paramMap.put("ce_cdt_id", candidateId);
			paramMap.put("ce_qualification_name", candidateEducation.getQualName());
			paramMap.put("ce_start_date", candidateEducation.getQualStartDate());
			paramMap.put("ce_end_date", candidateEducation.getQualEndDate());
			paramMap.put("ce_score", candidateEducation.getScore());
			paramMap.put("ce_institution", candidateEducation.getInstitution());
			paramMap.put("ce_specialization", candidateEducation.getSpecialization());
			
			namedParameterJdbcTemplate.update(sql.toString(), paramMap);
		});
		return true;
	}

	@Override
	public boolean removeCandidateEducations(String candidateId, LocalDate qualStartDate) {
		// TODO Auto-generated method stub
		return false;
	}

	private final class CandidateEducationRowMapper implements RowMapper<CandidateEducation> {

		@Override
		public CandidateEducation mapRow(ResultSet rs, int rowNum) throws SQLException {
			CandidateEducation candidateEducation = new CandidateEducation();
			candidateEducation.setInstitution(rs.getString("ce_institution"));
			candidateEducation.setQualEndDate(rs.getDate("ce_end_date").toLocalDate());
			candidateEducation.setQualName(rs.getString("ce_qualification_name"));
			candidateEducation.setQualStartDate(rs.getDate("ce_start_date").toLocalDate());
			candidateEducation.setScore(rs.getFloat("ce_score"));
			candidateEducation.setScoreType(rs.getString("ce_score_type"));
			candidateEducation.setSpecialization(rs.getString("ce_specialization"));
			return candidateEducation;
		}
	}

}
