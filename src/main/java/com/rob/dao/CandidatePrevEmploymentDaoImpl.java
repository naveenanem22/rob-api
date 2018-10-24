package com.rob.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rob.model.CandidatePrevEmployment;

@Repository(value = "candidatePrevEmploymentDaoImpl")
public class CandidatePrevEmploymentDaoImpl implements CandidatePrevEmploymentDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public boolean removePrevEmploymentRecords(int candidateId, List<Integer> candidatePrevEmploymentIds) {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM candidateemploymenthistory ");
		sql.append("WHERE ceh_cdt_id =:ceh_cdt_id && ceh_id =:ceh_id");

		List<Map<String, Object>> batchValues = new ArrayList<>(candidatePrevEmploymentIds.size());
		candidatePrevEmploymentIds.forEach(candidatePrevEmploymentId -> {
			batchValues.add(new MapSqlParameterSource("ceh_id", candidatePrevEmploymentId.intValue())
					.addValue("ceh_cdt_id", candidateId).getValues());

		});

		namedParameterJdbcTemplate.batchUpdate(sql.toString(),
				batchValues.toArray(new Map[candidatePrevEmploymentIds.size()]));

		return true;

	}

	public List<CandidatePrevEmployment> listPrevEmploymentRecords(int candidateId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM candidateemploymenthistory WHERE ceh_cdt_id =:ceh_cdt_id");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ceh_cdt_id", candidateId);
		return namedParameterJdbcTemplate.query(sql.toString(), paramMap, new CandidatePrevEmploymentRowMapper());

	}

	public boolean updatePrevEmploymentRecords(int candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments) {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE candidateemploymenthistory ");
		sql.append("SET ceh_total_experience_in_months =:ceh_total_experience_in_months, ");
		sql.append("ceh_end_date =:ceh_end_date, ");
		sql.append("ceh_relevant_experience_in_months =:ceh_relevant_experience_in_months, ");
		sql.append("ceh_designation =:ceh_designation, ");
		sql.append("ceh_remuneration =:ceh_remuneration, ");
		sql.append("ceh_nature_of_employment =:ceh_nature_of_employment, ");
		sql.append("ceh_reason_for_leaving =:ceh_reason_for_leaving, ");
		sql.append("ceh_employee_code =:ceh_employee_code, ");
		sql.append("ceh_supervisor_designation =:ceh_supervisor_designation, ");
		sql.append("ceh_supervisor_email =:ceh_supervisor_email, ");
		sql.append("ceh_supervisor_name =:ceh_supervisor_name, ");
		sql.append("ceh_company_name =:ceh_company_name, ");
		sql.append("ceh_start_date =:ceh_start_date ");
		sql.append("WHERE ceh_cdt_id =:ceh_cdt_id && ceh_id =:ceh_id");

		List<Map<String, Object>> batchValues = new ArrayList<>(candidatePrevEmployments.size());
		candidatePrevEmployments.forEach(candidatePrevEmployment -> {
			batchValues.add(new MapSqlParameterSource("ceh_total_experience_in_months",
					candidatePrevEmployment.getTotalExperienceInMonths())
							.addValue("ceh_end_date", candidatePrevEmployment.getEndDate())
							.addValue("ceh_relevant_experience_in_months",
									candidatePrevEmployment.getRelevantExperienceInMonths())
							.addValue("ceh_designation", candidatePrevEmployment.getDesignation())
							.addValue("ceh_remuneration", candidatePrevEmployment.getRemuneration())
							.addValue("ceh_nature_of_employment", candidatePrevEmployment.getNatureOfEmployment())
							.addValue("ceh_reason_for_leaving", candidatePrevEmployment.getReasonForLeaving())
							.addValue("ceh_employee_code", candidatePrevEmployment.getEmployeeCode())
							.addValue("ceh_supervisor_designation", candidatePrevEmployment.getSupervisorDesignation())
							.addValue("ceh_supervisor_email", candidatePrevEmployment.getSupervisorEmailId())
							.addValue("ceh_supervisor_name", candidatePrevEmployment.getSupervisorName())
							.addValue("ceh_cdt_id", candidateId)
							.addValue("ceh_company_name", candidatePrevEmployment.getCompanyName())
							.addValue("ceh_id", candidatePrevEmployment.getId())
							.addValue("ceh_start_date", candidatePrevEmployment.getStartDate()).getValues());

		});

		namedParameterJdbcTemplate.batchUpdate(sql.toString(),
				batchValues.toArray(new Map[candidatePrevEmployments.size()]));

		return true;

	}

	public boolean createPrevEmploymentRecords(int candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO candidateemploymenthistory");
		sql.append("(");
		sql.append("ceh_id, ceh_cdt_id, ceh_company_name, ceh_total_experience_in_months, ");
		sql.append("ceh_start_date, ceh_end_date, ceh_relevant_experience_in_months, ");
		sql.append("ceh_designation, ceh_remuneration, ceh_nature_of_employment, ");
		sql.append("ceh_reason_for_leaving, ceh_employee_code, ceh_supervisor_designation, ");
		sql.append("ceh_supervisor_email, ceh_supervisor_name");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append(":ceh_id, :ceh_cdt_id, :ceh_company_name, :ceh_total_experience_in_months, ");
		sql.append(":ceh_start_date, :ceh_end_date, :ceh_relevant_experience_in_months, ");
		sql.append(":ceh_designation, :ceh_remuneration, :ceh_nature_of_employment, ");
		sql.append(":ceh_reason_for_leaving, :ceh_employee_code, :ceh_supervisor_designation, ");
		sql.append(":ceh_supervisor_email, :ceh_supervisor_name");
		sql.append(")");

		List<Map<String, Object>> batchValues = new ArrayList<>(candidatePrevEmployments.size());
		candidatePrevEmployments.forEach(candidatePrevEmployment -> {
			batchValues.add(new MapSqlParameterSource("ceh_total_experience_in_months",
					candidatePrevEmployment.getTotalExperienceInMonths())
							.addValue("ceh_end_date", candidatePrevEmployment.getEndDate())
							.addValue("ceh_relevant_experience_in_months",
									candidatePrevEmployment.getRelevantExperienceInMonths())
							.addValue("ceh_designation", candidatePrevEmployment.getDesignation())
							.addValue("ceh_remuneration", candidatePrevEmployment.getRemuneration())
							.addValue("ceh_nature_of_employment", candidatePrevEmployment.getNatureOfEmployment())
							.addValue("ceh_reason_for_leaving", candidatePrevEmployment.getReasonForLeaving())
							.addValue("ceh_employee_code", candidatePrevEmployment.getEmployeeCode())
							.addValue("ceh_supervisor_designation", candidatePrevEmployment.getSupervisorDesignation())
							.addValue("ceh_supervisor_email", candidatePrevEmployment.getSupervisorEmailId())
							.addValue("ceh_supervisor_name", candidatePrevEmployment.getSupervisorName())
							.addValue("ceh_cdt_id", candidateId)
							.addValue("ceh_company_name", candidatePrevEmployment.getCompanyName())
							.addValue("ceh_id", candidatePrevEmployment.getId())
							.addValue("ceh_start_date", candidatePrevEmployment.getStartDate()).getValues());

		});

		namedParameterJdbcTemplate.batchUpdate(sql.toString(),
				batchValues.toArray(new Map[candidatePrevEmployments.size()]));

		return true;
	}

	private static class CandidatePrevEmploymentRowMapper implements RowMapper<CandidatePrevEmployment> {

		@Override
		public CandidatePrevEmployment mapRow(ResultSet rs, int rowNum) throws SQLException {
			CandidatePrevEmployment candidatePrevEmployment = new CandidatePrevEmployment();
			candidatePrevEmployment.setId(rs.getInt("ceh_id"));
			candidatePrevEmployment.setCompanyName(rs.getString("ceh_company_name"));
			candidatePrevEmployment.setDesignation(rs.getString("ceh_designation"));
			candidatePrevEmployment.setEmployeeCode(rs.getString("ceh_employee_code"));
			candidatePrevEmployment.setEndDate(rs.getDate("ceh_end_date").toLocalDate());
			candidatePrevEmployment.setNatureOfEmployment(rs.getString("ceh_nature_of_employment"));
			candidatePrevEmployment.setReasonForLeaving(rs.getString("ceh_reason_for_leaving"));
			candidatePrevEmployment.setRelevantExperienceInMonths(rs.getInt("ceh_relevant_experience_in_months"));
			candidatePrevEmployment.setRemuneration(rs.getBigDecimal("ceh_remuneration"));
			candidatePrevEmployment.setStartDate(rs.getDate("ceh_start_date").toLocalDate());
			candidatePrevEmployment.setSupervisorDesignation(rs.getString("ceh_supervisor_designation"));
			candidatePrevEmployment.setSupervisorEmailId(rs.getString("ceh_supervisor_email"));
			candidatePrevEmployment.setSupervisorName(rs.getString("ceh_supervisor_name"));
			candidatePrevEmployment.setTotalExperienceInMonths(rs.getInt("ceh_total_experience_in_months"));

			return candidatePrevEmployment;
		}

	}

}
