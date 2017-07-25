package org.com.cay.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

//不推荐使用JdbcDaoSupport
@Repository
public class DepartmentDao extends JdbcDaoSupport {

	@Autowired
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	public Department getById(Integer id){
		String sql = "select id, dept_name name from department where id = ?";
		Department department = getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(Department.class), id);
		return department;
	}
}
