package com.nsr.spring.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nsr.spring.service.TodoService;
import com.nsr.spring.vo.TodoVO;
import com.nsr.spring.vo.PageRequestDTO;

@Controller("todoController")
public class TodoControllerImpl implements TodoController {
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private TodoVO todoVO;

	// Obsolete
	@Override
	public ModelAndView listTodos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);
		List todosList = todoService.listTodos();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("todosList", todosList);
		return mav;
	}

	@Override
	@RequestMapping(value="/listTodos.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(PageRequestDTO pageRequestDTO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println();
		System.out.println("=============================");
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		
		if(pageRequestDTO == null) {
			pageRequestDTO = new PageRequestDTO();
		}
		
//	    String fromStr = request.getParameter("fromStr");
//	    if(fromStr != null && !fromStr.isEmpty())
//	    	pageRequestDTO.setFrom(parseStringToDate(fromStr));
//	    String toStr = request.getParameter("toStr");
//	    if(toStr != null && !toStr.isEmpty())
//	    	pageRequestDTO.setTo(parseStringToDate(toStr));

		System.out.println("Controller => list() => pageRequestDTO :" + pageRequestDTO);	
		mav.addObject("responseDTO", todoService.getList(pageRequestDTO));		
		return mav;
	}


	@Override
	@RequestMapping(value= {"/todoDetail.do", "/modTodo.do"}, method=RequestMethod.GET)
	public ModelAndView detailTodo(
			long tno, PageRequestDTO pageRequestDTO, BindingResult bindingResult, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();

		boolean error = false;
		if(bindingResult.hasErrors()) {
			System.err.println("Controller detailTodo/modTodo has error..... => " + bindingResult.getAllErrors());
	    	error = true;
			mav.addObject("errors", bindingResult.getAllErrors());
		}
		
		TodoVO todoVO = new TodoVO();
		todoVO = todoService.getOne(tno);
		
//	    String fromStr = request.getParameter("fromStr");
//	    if(fromStr != null && !fromStr.isEmpty())
//	    	pageRequestDTO.setFrom(parseStringToDate(fromStr));
//	    String toStr = request.getParameter("toStr");
//	    if(toStr != null && !toStr.isEmpty())
//	    	pageRequestDTO.setTo(parseStringToDate(toStr));
		mav.addObject("page", pageRequestDTO.getPage());
		mav.addObject("size", pageRequestDTO.getSize());
		mav.addObject("finished", pageRequestDTO.isFinished());
		mav.addObject("types", pageRequestDTO.getTypes());
		mav.addObject("keyword", pageRequestDTO.getKeyword());
		mav.addObject("from", pageRequestDTO.getFrom());
		mav.addObject("to", pageRequestDTO.getTo());
	    
	    if(error) {
	    	mav.setViewName("redirect:listTodos.do");
	    }
		
		mav.addObject("todo", todoVO);
		mav.setViewName(viewName);
		return mav;
	}
	@Override
	@RequestMapping(value="/updateTodo.do", method=RequestMethod.POST)
	public ModelAndView updateTodo(PageRequestDTO pageRequestDTO, TodoVO todo, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		String duedateStr = request.getParameter("duedateStr");
		
		ModelAndView mav = new ModelAndView();
		
		boolean error = false;
		if(bindingResult.hasErrors()) {
			System.err.println("Controller addTodo has error.....");
			error = true;
			mav.addObject("errors", bindingResult.getAllErrors());
			return mav;
		}
		
		if(duedateStr == null || duedateStr.isEmpty()) {
			mav.addObject("duedateError", "duedateError");
			error = true;
		}
		
		if(error) {
			mav.addObject("tno", todo.getTno());
			mav.addObject("page", pageRequestDTO.getPage());
			mav.addObject("size", pageRequestDTO.getSize());
			mav.addObject("finished", pageRequestDTO.isFinished());
			mav.addObject("types", pageRequestDTO.getTypes());
			mav.addObject("keyword", pageRequestDTO.getKeyword());
			mav.addObject("from", pageRequestDTO.getFrom());
			mav.addObject("to", pageRequestDTO.getTo());
			mav.setViewName("redirect:/modTodo.do");
			return mav;
		}
	    todo.setDuedate(parseStringToDate(duedateStr));
	    
		result = todoService.updateTodo(todo);
		mav = new ModelAndView("redirect:/listTodos.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/removeTodo.do", method = RequestMethod.POST)
	public ModelAndView removeTodo(@RequestParam("tno") int tno, PageRequestDTO pageRequestDTO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		todoService.removeTodo(tno);
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
	@RequestMapping(value = "/addTodo.do", method = RequestMethod.POST)
	public ModelAndView addTodo(TodoVO todo, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		boolean error = false;
		System.out.println(bindingResult.hasErrors());

		ModelAndView mav = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			System.err.println("Controller addTodo has error..... => " + bindingResult.getAllErrors());
	    	error = true;
			mav.addObject("errors", bindingResult.getAllErrors());
		}
		
		String duedateStr = request.getParameter("duedateStr");
	    if(duedateStr == null || duedateStr.isEmpty()) {
	    	error = true;
			mav.addObject("duedateError", "duedateError");
	    }
	    	
	    if(error) {
			mav.addObject("todo", todo);
			mav.setViewName("redirect:/todoForm.do");
			return mav;
	    }
	    	
	    todo.setDuedate(parseStringToDate(duedateStr));
	    
	    
	    int result = todoService.addTodo(todo);
	    mav.setViewName("redirect:/listTodos.do");
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
            e.printStackTrace();
            return null; 
        }
    }

}
