package com.nsr.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.pageRequestDTO;

@Repository("todoDAO")
public class TodoDAOIimpl implements TodoDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllTodoList() throws DataAccessException {
		List<TodoVO> todosList = null;
		todosList = sqlSession.selectList("mapper.todo.selectAllTodos");
		return todosList;
	}

	@Override
	public int insertTodo(TodoVO todo) throws DataAccessException {
		System.out.println(todo);
		int result = sqlSession.insert("mapper.todo.insertTodo", todo);
		return result;
	}

	@Override
	public int deleteTodo(int tno) throws DataAccessException {
		int result = sqlSession.delete("mapper.todo.deleteTodo", tno);
		return result;
	}

	@Override
	public int updateTodo(TodoVO todo) throws DataAccessException {
		System.out.println(todo);
		int result = sqlSession.update("mapper.todo.updateTodo", todo);
		return result;
	}

	@Override
	public TodoVO selectOne(long tno) throws DataAccessException {
		TodoVO todo = null;
		todo = (TodoVO) sqlSession.selectOne("mapper.todo.selectOne", tno);
		System.out.println("DAO selcetOne " + todo);
		return todo;
	}

	@Override
	public List selectList(pageRequestDTO pageRequestDTO) {
	    System.out.println("dao");
	    List<TodoVO> todosList = null;
	    Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("start", pageRequestDTO.getSkip() + 1);
	    paramMap.put("end", pageRequestDTO.getSkip() + pageRequestDTO.getSize());
	    todosList = sqlSession.selectList("mapper.todo.selectList", paramMap);
	    System.out.println(todosList);
	    return todosList;
	}


	@Override
	public int getCount(pageRequestDTO pageRequestDTO) throws DataAccessException {

		int result = (int) sqlSession.selectOne("mapper.todo.getCount");
		System.out.println("dao => getCount => " + result);
		return result;
	}

}
