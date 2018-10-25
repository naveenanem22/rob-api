package com.rob.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pmt.model.Employee;
import com.rob.custom.exceptions.InternalServerException;
import com.rob.custom.exceptions.RecordNotFoundException;
import com.rob.model.JobPost;

@Repository(value = "jobPostDaoImpl")
public class JobPostDaoImpl implements JobPostDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public JobPost getJobPostById(int jobPostId) {
		List<JobPost> jobPosts;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT jobpost.*, employee.emp_id, employee.emp_firstname, employee.emp_lastname ");
			sql.append("FROM jobpost ");
			sql.append("INNER JOIN ");
			sql.append("employee ");
			sql.append("ON jobpost.jp_hiring_manager_employee_id = employee.emp_id ");
			sql.append("WHERE jobpost.jp_id =:jp_id");

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("jp_id", jobPostId);
			jobPosts = namedParameterJdbcTemplate.query(sql.toString(), paramMap, new JobPostRowMapper());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerException("Unexpected error occurred while fetching the JobPost details.");
		}

		if (jobPosts.size() == 1)
			return jobPosts.get(0);
		else if (jobPosts.isEmpty())
			throw new RecordNotFoundException("JobPost not found.");
		else
			throw new InternalServerException("Unexpected error occurred while fetching the JobPost details.");

	}

	public boolean updateJobPost(JobPost jobPost) {
		int numberOfRowsAffected;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE jobpost SET ");
			sql.append("jp_job_title =:jp_job_title, ");
			sql.append("jp_location =:jp_location, ");
			sql.append("jp_roles =:jp_roles, ");
			sql.append("jp_number_of_vacancies =:jp_number_of_vacancies, ");
			sql.append("jp_hiring_manager_employee_id =:jp_hiring_manager_employee_id, ");
			sql.append("jp_department_id =:jp_department_id, ");
			sql.append("jp_overview =:jp_overview, ");
			sql.append("jp_responsibilities =:jp_responsibilities, ");
			sql.append("jp_must_have_experience =:jp_must_have_experience, ");
			sql.append("jp_nice_to_have_experience =:jp_nice_to_have_experience, ");
			sql.append("jp_key_skills =:jp_key_skills, ");
			sql.append("jp_desired_education =:jp_desired_education ");
			sql.append("WHERE jp_id =:jp_id");

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("jp_job_title", jobPost.getJobTitle());
			paramMap.put("jp_location", jobPost.getJobLocation());
			paramMap.put("jp_roles", jobPost.getRoles());
			paramMap.put("jp_number_of_vacancies", jobPost.getNumberOfVacancies());
			paramMap.put("jp_hiring_manager_employee_id", jobPost.getHiringManager().getId());
			paramMap.put("jp_department_id", jobPost.getDepartment());
			paramMap.put("jp_overview", jobPost.getJobOverview());
			paramMap.put("jp_responsibilities", jobPost.getResponsibilities());
			paramMap.put("jp_must_have_experience", jobPost.getMustHaveExperience());
			paramMap.put("jp_nice_to_have_experience", jobPost.getNiceToHaveExperience());
			paramMap.put("jp_key_skills", jobPost.getKeySkills());
			paramMap.put("jp_desired_education", jobPost.getDesiredEducation());
			paramMap.put("jp_id", jobPost.getId());

			numberOfRowsAffected = namedParameterJdbcTemplate.update(sql.toString(), paramMap);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerException("Unexpected error occurred while updating the JobPost details.");
		}
		if (numberOfRowsAffected == 1)
			return true;
		else if (numberOfRowsAffected == 0)
			throw new RecordNotFoundException("Record not found.");
		else
			throw new InternalServerException("Unexpected error occurred while updating the JobPost details.");

	}

	public boolean removeJobPostById(int jobPostId) {
		int numberOfRowsAffected;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM jobpost ");
			sql.append("WHERE jp_id =:jp_id");
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("jp_id", jobPostId);
			numberOfRowsAffected = namedParameterJdbcTemplate.update(sql.toString(), paramMap);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerException("Unexpected error occurred while removing the JobPost details.");
		}
		if (numberOfRowsAffected == 1)
			return true;
		else if (numberOfRowsAffected == 0)
			throw new RecordNotFoundException("Record not found.");
		else
			throw new InternalServerException("Unexpected error occurred while removing the JobPost details.");

	}

	public boolean createJobPost(JobPost jobPost) {
		int numberOfRowsAffected;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO jobpost ");
			sql.append("(");
			sql.append("jp_id, jp_job_title, jp_location, jp_roles, jp_number_of_vacancies, ");
			sql.append("jp_hiring_manager_employee_id, jp_department_id, jp_overview, jp_responsibilities, ");
			sql.append("jp_must_have_experience, jp_nice_to_have_experience, jp_key_skills, ");
			sql.append("jp_desired_education");
			sql.append(")");
			sql.append("VALUES ");
			sql.append("(");
			sql.append(":jp_id, :jp_job_title, :jp_location, :jp_roles, :jp_number_of_vacancies, ");
			sql.append(":jp_hiring_manager_employee_id, :jp_department_id, :jp_overview, :jp_responsibilities, ");
			sql.append(":jp_must_have_experience, :jp_nice_to_have_experience, :jp_key_skills, ");
			sql.append(":jp_desired_education");
			sql.append(")");

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("jp_id", jobPost.getId());
			paramMap.put("jp_job_title", jobPost.getJobTitle());
			paramMap.put("jp_location", jobPost.getJobLocation());
			paramMap.put("jp_roles", jobPost.getRoles());
			paramMap.put("jp_number_of_vacancies", jobPost.getNumberOfVacancies());
			paramMap.put("jp_hiring_manager_employee_id", jobPost.getHiringManager().getId());
			paramMap.put("jp_department_id", jobPost.getDepartment());
			paramMap.put("jp_overview", jobPost.getJobOverview());
			paramMap.put("jp_responsibilities", jobPost.getResponsibilities());
			paramMap.put("jp_must_have_experience", jobPost.getMustHaveExperience());
			paramMap.put("jp_nice_to_have_experience", jobPost.getNiceToHaveExperience());
			paramMap.put("jp_key_skills", jobPost.getKeySkills());
			paramMap.put("jp_desired_education", jobPost.getDesiredEducation());
			numberOfRowsAffected = namedParameterJdbcTemplate.update(sql.toString(), paramMap);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InternalServerException("Unexpected error occurred while creating the JobPost details.");
		}

		if (numberOfRowsAffected == 1)
			return true;
		else
			throw new InternalServerException("Unexpected error occurred while creating the JobPost details.");

	}

	private static class JobPostRowMapper implements RowMapper<JobPost> {

		@Override
		public JobPost mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee hiringManager = new Employee();
			hiringManager.setId(rs.getInt("emp_id"));
			hiringManager.setFirstName(rs.getString("emp_firstname"));
			hiringManager.setLastName(rs.getString("emp_lastname"));

			JobPost jobPost = new JobPost();
			jobPost.setDepartment(rs.getString("jp_department_id"));
			jobPost.setDesiredEducation(rs.getString("jp_desired_education"));
			jobPost.setHiringManager(hiringManager);
			jobPost.setJobLocation(rs.getString("jp_location"));
			jobPost.setJobOverview(rs.getString("jp_overview"));
			jobPost.setJobTitle(rs.getString("jp_job_title"));
			jobPost.setKeySkills(rs.getString("jp_key_skills"));
			jobPost.setMustHaveExperience(rs.getString("jp_must_have_experience"));
			jobPost.setNiceToHaveExperience(rs.getString("jp_nice_to_have_experience"));
			jobPost.setNumberOfVacancies(rs.getInt("jp_number_of_vacancies"));
			jobPost.setResponsibilities(rs.getString("jp_responsibilities"));
			jobPost.setRoles(rs.getString("jp_roles"));
			jobPost.setId(rs.getInt("jp_id"));

			return jobPost;
		}

	}

}
