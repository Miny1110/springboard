package com.anno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * @ Controller가 객체생성을 해준다
 * 기본적으로 객체명은 클래스명과 동일하게(소문자로) 생성되는데,
 * 만약 다른 이름으로 생성하고 싶다면 컨트롤러 옆 괄호에 객체명을 적어주면 된다
 * MainController com.anno.mainCotroller = new MainController(); 와 같다
 * 패키지명처럼 작성 > 같은 컨트롤러로 여러 객체를 생성했을 때 이름 중복을 방지할 수 있다*/
@Controller
//("com.anno.mainCotroller")
@RequestMapping(value="/main.action")
public class MainController {

	/**사용자가 이 주소를 입력했을 때 메인절에 들어와서 밑에 있는 작업을 하는데,
	 * get 방식으로 왔을 때에만 메소드르 실행한다.
	 * post 방식일 때에는 실행하지 않는다.*/
	@RequestMapping(method=RequestMethod.GET)
	public String method() {
		
		return "/index";
	}
	
}
