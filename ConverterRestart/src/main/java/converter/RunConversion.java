package converter;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RunConversion
{

	@RequestMapping("/runConversion")
	public String runConversion(ModelMap map){
		System.out.println("running conversion");
		return "hello";
	}
}
