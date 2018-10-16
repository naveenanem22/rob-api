package com.rob.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pmt.model.Employee;
import com.rob.model.JobPost;

@Repository(value = "jobPostDaoImpl")
public class JobPostDaoImpl implements JobPostDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<JobPost> getJobPostsById(String jobPostId) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT jobpost.*, employee.emp_id, employee.emp_firstname, employee.emp_lastname ");
		sql.append("FROM jobpost ");
		sql.append("INNER JOIN ");
		sql.append("employee ");
		sql.append("ON jobpost.jp_hiring_manager_employee_id = employee.emp_id ");
		sql.append("WHERE jobpost.jp_id =:jp_id");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("jp_id", jobPostId);
		return namedParameterJdbcTemplate.query(sql.toString(), paramMap, new JobPostRowMapper());

	}

	private static class JobPostRowMapper implements RowMapper<JobPost> {

		@Override
		public JobPost mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee hiringManager = new Employee();
			hiringManager.setId(rs.getString("emp_id"));
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

			return jobPost;
		}

	}

}
