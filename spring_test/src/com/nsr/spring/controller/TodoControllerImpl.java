package com.nsr.spring.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nsr.spring.service.TodoService;
import com.nsr.spring.vo.TodoVO;

@Controller("todoController")
public class TodoControllerImpl implements TodoController {
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private TodoVO todoVO;

	@Override
	@RequestMapping(value="/listTodos.do", method = RequestMethod.GET)
	public ModelAndView listTodos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);
		List todosList = todoService.listTodos();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("todosList", todosList);
		return mav;
	}

	@Override
	@RequestMapping(value = "/addTodo.do", method = RequestMethod.POST)
	public ModelAndView addTodo(@Valid @ModelAttribute("todo") TodoVO todo, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("여기보세요~~~");
		System.out.println(bindingResult.hasErrors());
		
		if(bindingResult.hasErrors()) {
			System.err.println("Controller addTodo has error.....");
			ModelAndView mav = new ModelAndView();
			mav.addObject("errors", bindingResult.getAllErrors());
			mav.setViewName("/todoForm.do");
			return mav;
		}
		
		request.setCharacterEncoding("utf-8");
		int result = 0;
		
		// 날짜 문자열을 Date 객체로 변환
	    String duedateStr = request.getParameter("duedateStr");
	    todo.setDuedate(parseStringToDate(duedateStr));
	    
	    
		result = todoService.addTodo(todo);
		ModelAndView mav = new ModelAndView("redirect:/listTodos.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/removeTodo.do", method = RequestMethod.POST)
	public ModelAndView removeTodo(@RequestParam("tno") int tno, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		todoService.removeTodo(tno);
		ModelAndView mav = new ModelAndView("redirect:/listTodos.do");
		return mav;
	}
	

	@Override
	@RequestMapping(value="/updateTodo.do", method=RequestMethod.POST)
	public ModelAndView updateTodo(TodoVO todo, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		
		// 날짜 문자열을 Date 객체로 변환
	    String duedateStr = request.getParameter("duedateStr");
	    todo.setDuedate(parseStringToDate(duedateStr));
	    
	    System.out.print("controller todo" + todo);
	    
		result = todoService.updateTodo(todo);
		ModelAndView mav = new ModelAndView("redirect:/listTodos.do");
		return mav;
	}

	
	@RequestMapping(value="/*Form.do", method=RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	

	@Override
	@RequestMapping(value="/todoDetail.do", method=RequestMethod.GET)
	public ModelAndView detailTodo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		TodoVO todoVO = new TodoVO();
		request.setCharacterEncoding("utf-8");
		String tno_str = request.getParameter("tno");
		
		long tno = Long.parseLong(tno_str);
		todoVO = todoService.getOne(tno);
		
		System.out.println("controller todo " + todoVO);
		
		mav.addObject("todo", todoVO);
		
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/modTodo.do", method=RequestMethod.GET)
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		TodoVO todoVO = new TodoVO();
		
		request.setCharacterEncoding("utf-8");
		String tno_str = request.getParameter("tno");
		
		long tno = Long.parseLong(tno_str);
		todoVO = todoService.modTodo(tno);
		
		System.out.println("controller todo " + todoVO);
		
		mav.addObject("todo", todoVO);
		
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath(); 
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		
		if(uri == null || uri.trim().equals(""))
			uri = request.getRequestURI();
		
		int begin = 0;
		if(!(contextPath == null) || ("".equals(contextPath))) 
			begin = contextPath.length();
		
		int end;
		if(uri.indexOf(";") != -1) 
			end = uri.indexOf(";");
		else if(uri.indexOf("?") != -1)
			end = uri.indexOf("?");
		else
			end = uri.length();
		
		String fileName = uri.substring(begin, end);
		
		if(fileName.indexOf(".") != -1)
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		
		if(fileName.lastIndexOf("/") != -1)
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		
		return fileName;
	}
	

	private Date parseStringToDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateStr);
            return new Date(parsedDate.getTime());
        } catch (ParseException e) {
            // 예외 처리
            e.printStackTrace();
            return null; // 또는 예외를 다시 던지거나 다른 방식으로 처리할 수 있음
        }
    }

}
