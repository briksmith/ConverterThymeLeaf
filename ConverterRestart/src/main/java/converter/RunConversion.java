package converter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Unit;

@Controller
public class RunConversion
{

	@RequestMapping("/runConversion")
	public String runConversion(HttpServletRequest request, ModelMap map){
		System.out.println("running conversion");
		System.out.println("printing out put of dropdown units from: " + request.getParameter("listOfUnitsToConvertFrom"));
		Unit unitsFrom;
		Unit unitsTo;
		map.addAttribute("result", 1);
		return "hello";
	}
}
