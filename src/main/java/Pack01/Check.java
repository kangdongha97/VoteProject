package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Check {
	
	@RequestMapping
	public Boolean checInfo(String name, String tel) {
		// �ٿ� ��ü ����
		Dao dao = new Dao();
		// return �� if �� ���ǿ� �ֱ� 
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
		// �ش� �Լ� ���� 
		return "index";
	}
}
