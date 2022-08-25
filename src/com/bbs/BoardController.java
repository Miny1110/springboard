package com.bbs;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.util.MyPage;
import com.util.dao.CommonDAO;

@Controller("bbs.boardController")
public class BoardController {

	/**@Resource로 불러낸다*/
	@Resource(name="dao")
	private CommonDAO dao;
	
	@Resource(name="myPage")
	private MyPage myPage;
	
	
	@RequestMapping(value="/bbs/created.action",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String created(BoardCommand command,
			HttpServletRequest request) throws Exception{
		
		if(command==null || command.getMode()==null || command.getMode().equals("")) {
			request.setAttribute("mode", "insert");
			
			return "board/created";
		}
		
		int boardNumMax = dao.getIntValue("bbs.maxBoardNum");
		
		command.setBoardNum(boardNumMax+1);
		command.setIpAddr(request.getRemoteAddr());
		
		dao.insertData("bbs.insertData", command);
		
		return "redirect:/bbs/list.action";
	}
	
	
	@RequestMapping(value="/bbs/list.action",
			method= {RequestMethod.GET})
	public String list(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String cp = request.getContextPath();
		
		
		
		
		return "board/list";
	}
	
}
