package org.com.cay.jdbc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		employeeDao = ctx.getBean(EmployeeDao.class);
		departmentDao = ctx.getBean(DepartmentDao.class);
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
		
	}
	
	@Test
	public void test(){
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}
	
	@Test
	public void testUpdate(){
		String sql = "update employee set last_name = ? where id = ?";
		jdbcTemplate.update(sql, "Jack", 8);
	}
	
	/**
	 * 执行批量更新,批量insert，update，delete
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "insert into employee(last_name,email,dept_id) values(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{"AAA", "aa@qq.com", 1});
		batchArgs.add(new Object[]{"BBB", "bb@qq.com", 4});
		batchArgs.add(new Object[]{"CCC", "cc@qq.com", 2});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	/**
	 * 从数据库中获取一条记录，实际得到对应的一个对象
	 * 需要调用JdbcTemplate.queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args);
	 * 1、其中的RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
	 * 2、使用sql中列的别名完成列名和类的属性名的映射
	 * 3、不支持级联属性，
	 */
	@Test
	public void testQueryForObject(){
		String sql = "select id, last_name lastName, email from employee where id = ?";
		Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class),1);
		System.out.println(employee);
	}
	
	/*
	 * 查询实体集合
	 */
	@Test
	public void testQueryForList(){
		String sql = "select id, last_name lastName, email from employee where id > ?";
		List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class), 5);
		System.out.println(employees);
	}
	
	@Test
	public void testQueryForObject2(){
		String sql = "select count(id) from employee";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	@Test
	public void testEmployeeDao(){
		Employee employee = employeeDao.getById(1);
		System.out.println(employee);
	}
	
	@Test
	public void testDepartmentDao(){
		Department department = departmentDao.getById(1);
		System.out.println(department);
	}
	
	/*
	 * 可以为参数起名字，
	 * 好处：若有多个参数，则不用再去对应问号参数的位置，而是直接对应别名，便于维护
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "insert into employee(last_name,email,dept_id) values(:ln, :email, :deptId)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ln", "DDD");
		paramMap.put("email", "dd@qq.com");
		paramMap.put("deptId", 2);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	/*
	 * 使用具名参数时，具名名字与类对象的属性名一致。
	 * 使用SqlParameterSource接口的实现类BeanPropertySqlParameterSource对象作为参数
	 * 
	 */
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql = "insert into employee(last_name,email) values(:lastName, :email)";
		Employee employee = new Employee();
		employee.setLastName("FFF");
		employee.setEmail("ff@qq.com");
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
}
