package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j

public class DataSourceTest {
	// DB연결
	@Autowired
	private DataSource datesource;
	
	// DB 커넥 풀 
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	// DB연결 테스트 
	@Test
	public void testConnection() {
		try(Connection con = datesource.getConnection()) {
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	// DB 커넥 풀 테스트
	@Test
	public void testMyBatis() {
		try (SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection()){
			System.out.println(session);
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
}
