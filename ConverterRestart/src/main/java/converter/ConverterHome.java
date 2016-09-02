package converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConverterHome
{
	@RequestMapping("/Converter")
	public String convert(ModelMap map)
	{
		System.out.println("in convert");
		map.addAttribute("Test", "FUCKING FINALLY!!!");
		return "hello";
	}
		
}
