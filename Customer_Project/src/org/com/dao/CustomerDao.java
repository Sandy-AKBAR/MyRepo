package org.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.com.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int addCustomer(Customer customer){
	return
	jdbcTemplate.update
("insert into customer values("+customer.getId()+",'"+customer.getName()+"','"+customer.getLocation()+"')");
	
	}
	
	public int deleteCustomer(int cid){
		return
		jdbcTemplate.update
	("delete from customer where  cid="+cid);
		
		}
	
	public int updateCustomer(Customer customer){
		return
		jdbcTemplate.update
("update  customer set name='"+customer.getName()+"',location='"+customer.getLocation()+"' where  cid="+customer.getId()+"");
		
		}
	public List<Customer> getAllCustomer() {

		RowMapper<Customer> rowmapper = new RowMapper<Customer>() {
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer cust = new Customer();
				cust.setId(rs.getInt(1));
				cust.setName(rs.getString(2));
				cust.setLocation(rs.getString(3));
				return cust;
			}
		};
return jdbcTemplate.query("select * from customer", rowmapper);
	}


public Customer SearchCustomer(int cid) {
		RowMapper<Customer> rowmapper = new RowMapper<Customer>() {
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer cust = new Customer();
				cust.setId(rs.getInt(1));
				cust.setName(rs.getString(2));
				cust.setLocation(rs.getString(3));
				return cust;
			}
		};
return jdbcTemplate.queryForObject
("select * from customer where cid=?", rowmapper,cid);
	}

	
}
