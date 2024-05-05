package com.nsr.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.PageRequestDTO;

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
	public List selectList(PageRequestDTO pageRequestDTO) {
		System.out.println();
	    System.out.println("dao");
	    List<TodoVO> todosList = null;
	    Map<String, Object> paramMap = new HashMap<String, Object>();
	    int start = pageRequestDTO.getSkip() + 1;
	    int end = pageRequestDTO.getSkip() + pageRequestDTO.getSize();
	    paramMap.put("start", start);
	    paramMap.put("end", end);
	    
	    System.out.println("start : " + start);
	    System.out.println("end : " +  end);
	    
	    paramMap.put("types", pageRequestDTO.getTypes());
	    paramMap.put("keyword", pageRequestDTO.getKeyword());
	    paramMap.put("finished", pageRequestDTO.isFinished());
	    paramMap.put("from", pageRequestDTO.getFrom());
	    paramMap.put("to", pageRequestDTO.getTo());
	    
	    
	    todosList = sqlSession.selectList("mapper.todo.selectList", paramMap);
	    System.out.println(todosList);
	    return todosList;
	}


	@Override
	public int getCount(PageRequestDTO pageRequestDTO) throws DataAccessException {

	    Map<String, Object> paramMap = new HashMap<String, Object>();
	    int start = pageRequestDTO.getSkip() + 1;
	    int end = pageRequestDTO.getSkip() + pageRequestDTO.getSize();
	    paramMap.put("start", start);
	    paramMap.put("end", end);
	    paramMap.put("types", pageRequestDTO.getTypes());
	    paramMap.put("keyword", pageRequestDTO.getKeyword());
	    paramMap.put("finished", pageRequestDTO.isFinished());
	    paramMap.put("from", pageRequestDTO.getFrom());
	    paramMap.put("to", pageRequestDTO.getTo());
	    
		int result = (int) sqlSession.selectOne("mapper.todo.getCount", paramMap);
		System.out.println("dao => getCount => " + result);
		return result;
	}

}
