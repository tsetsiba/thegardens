package farming;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Using annotation-based programming model, you can use annotations such as @RequestMapping, @RequestParam
 * and @ModelAttribute and so on
 */
@Controller //@Controller indicates that a particular class serves the role of controller
public class Calculator {
	//Spring does not require you to extend any controller base class or reference the Servlet API, however you can still 
	//reference Servlet-specific feature if you need to.
	@RequestMapping("/calculateTaxReturn")
    public String calculatorTaxReturn(Model model) {
        model.addAttribute("message", "Hello World!");
        return "Tax Return"; // Returns a view name as string
    }
	
	@RequestMapping(method = RequestMethod.POST) //specific request method type
	public String add(BindingResult result) {
	    if (result.hasErrors()) {
	        return "calculations/new";
	    }
	    // add then return to appointments
	    return "redirect:/calculations";
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
    public String substract() {
        return "redirect:/calculations";
    }
	
	@RequestMapping(value="/calculator/{result}", method=RequestMethod.GET)
	public String findOwner(@PathVariable String result, Model model) {
	  model.addAttribute("result", result);
	  return "displayOwner";
	}
}
