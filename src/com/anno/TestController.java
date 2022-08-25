package com.anno;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**컨트롤러로 빈 객체 생성
 * 동일객체명 충돌 방지를 위해 이름을 지정*/
@Controller("anno.testController")
public class TestController {

	/**method : get방식으로 왔을 때에만 창을 띄운다*/
	@RequestMapping(value="/demo/write.action", method= {RequestMethod.GET})
	public String write() throws Exception{
		
		return "anno/created";
		
	}
	
	@RequestMapping(value="/demo/write.action", method= {RequestMethod.POST})
	public String write_ok(TestCommand command,HttpServletRequest request) {
	
		String message = "아이디: " + command.getUserId();
		message += "이름: " + command.getUserName();
		
		request.setAttribute("message", message);
		
		return "anno/result";
	}
	
	@RequestMapping(value="/demo/save.action", 
			method= {RequestMethod.POST, RequestMethod.GET})
	public String save(TestCommand command,HttpServletRequest request) {
		
		/**처음 실행할 때에는 command에 데이터가 없다*/
		if(command==null || command.getMode()==null || command.getMode().equals("")) {
			return "anno/test";
		}
		
		String message = "아이디: " + command.getUserId();
		message += "이름: " + command.getUserName();
		
		request.setAttribute("message", message);
		
		return "anno/result";
	}
	
	@RequestMapping(value="/demo/demo.action", 
			method= {RequestMethod.POST, RequestMethod.GET})
	public String demo(String userId,String userName,String mode,
			HttpServletRequest request) {
		
		if(mode==null || mode.equals("")) {
			return "anno/demo";
		}
		
		String message = "아이디: " + userId;
		message += "이름: " + userName;
		
		request.setAttribute("message", message);
		
		return "anno/result";
	}
}
