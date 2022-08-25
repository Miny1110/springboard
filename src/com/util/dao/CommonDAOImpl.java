package com.util.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

/*
	@Repository : 저장소 컴포넌트(DAO 등).
	@Service : 상태없는 서비스 컴포넌트. (일반적인 클래스)
	@Autowired 어노테이션 : Spring에서 의존관계를 자동으로 설정
	@Resource 어노테이션 : 의존하는 빈 객체를 전달 할 때 사용

	@Resource 는 이름을 지정할 수 있으나 @Autowired는 이름을 지정할 수 없고 id 값과 일치해야한다.

    - Service에 있는 @Autowired는 @Repository("dao")에 등록된 dao와 변수명이 같아야 한다.
	- @Autowired 어노테이션은 Spring에서 의존관계를 자동으로 설정
*/

/**@Repository가 CommonDAOImpl 객체 생성*/
@Repository("dao")
public class CommonDAOImpl implements CommonDAO{
	
	/**xml에서 sqlMapClientTemplate과 이름이 같은 걸 가져와
	 * bean의 id와 변수명이 동일해야 찾을 수 있다. */
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	/**@Autowired를 쓰면 아래 코드가 필요하지 않다.*/
	/*public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}*/

	
	@Override
	public void insertData(String id, Object value) throws SQLException {
		
		try {
			
			sqlMapClientTemplate.insert(id,value); //DB에 데이터를 넣는 실제 메소드 작업
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
	}

	@Override
	public int updateData(String id, Object value) throws SQLException {
		
		int result = 0;
		
		try {
			
			result = sqlMapClientTemplate.update(id,value);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		return result;
	}

	@Override
	public int updateData(String id, Map<String, Object> map) throws SQLException {

		int result = 0;
		
		try {
			
			result = sqlMapClientTemplate.update(id,map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		return result;
	}

	@Override
	public int deleteData(String id, Object value) throws SQLException {

		int result = 0;
		
		try {
			
			result = sqlMapClientTemplate.delete(id,value);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		return result;
	}

	@Override
	public int deleteData(String id, Map<String, Object> map) throws SQLException {

		int result = 0;
		
		try {
			
			result = sqlMapClientTemplate.delete(id,map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		return result;
	}

	@Override
	public int deleteAllData(String id) throws SQLException {

		int result = 0;
		
		try {
			
			result = sqlMapClientTemplate.delete(id);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		return result;
	}

	@Override
	public Object getReadData(String id) {
				
		try {
			
			return sqlMapClientTemplate.queryForObject(id);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

	@Override
	public Object getReadData(String id, Object value) {
		
		try {
			
			return sqlMapClientTemplate.queryForObject(id,value);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

	@Override
	public Object getReadData(String id, Map<String, Object> map) {
		
		try {
			
			return sqlMapClientTemplate.queryForObject(id,map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

	@Override
	public int getIntValue(String id) {
		
		try {
			
			return ((Integer)sqlMapClientTemplate.queryForObject(id)).intValue();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
	}

	@Override
	public int getIntValue(String id, Object value) {

		try {
			
			return ((Integer)sqlMapClientTemplate.queryForObject(id,value)).intValue();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
	}

	@Override
	public int getIntValue(String id, Map<String, Object> map) {

		try {
			
			return ((Integer)sqlMapClientTemplate.queryForObject(id,map)).intValue();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id) {

		try {
			
			return (List<Object>)sqlMapClientTemplate.queryForList(id);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id, Object value) {

		try {
			
			return (List<Object>)sqlMapClientTemplate.queryForList(id,value);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id, Map<String, Object> map) {

		try {
			
			return (List<Object>)sqlMapClientTemplate.queryForList(id,map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

}
