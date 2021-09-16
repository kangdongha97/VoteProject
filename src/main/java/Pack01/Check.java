package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Check {
	
	@RequestMapping
	public Boolean checInfo(String name, String tel) {
		// 다오 객체 생성
		Dao dao = new Dao();
		// return 값 if 문 조건에 넣기 
		Boolean r = false;
		Boolean check = true;
		if (!r) {
			check = false;
			return check;
		}
		return check;
	}
	
	@RequestMapping
	public String voting(int num) {
		// 해당 함수 실행 
		return "index";
	}
}
