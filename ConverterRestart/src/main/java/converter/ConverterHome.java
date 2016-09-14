package converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import utils.Consts;

@Controller
public class ConverterHome
{
	
	private static boolean runInit = true;
	private static List<String> units;
	
	static
	{
		units = new ArrayList<>();
		for ( String s: Consts.LENGTH_UNITS_LIST){
			units.add(s);
		}
	}
	
	@RequestMapping("/Converter")
	public String convert(ModelMap map)
	{
		if ( runInit )
		{
			map.addAttribute(Consts.LENGTH_UNITS, units);
		}
		runInit = false;
		System.out.println("in convert");
		map.addAttribute("Test", "FUCKING FINALLY!!!");
		return "hello";
	}
		
}
