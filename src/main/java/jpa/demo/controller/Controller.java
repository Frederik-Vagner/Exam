package jpa.demo.controller;



import jpa.demo.model.Kommune;
import jpa.demo.model.Sogn;
import jpa.demo.service.KommuneService;
import jpa.demo.service.SognService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@org.springframework.stereotype.Controller
public class Controller {


    //Dependency injection of SognService and Kommuneservice
    @Autowired
    SognService sognService;

    @Autowired
    KommuneService kommuneService;

    //Homepage displays Sogne
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("sogne", sognService.findAll());
        return "index";
    }

    //Kommunepage displays kommuner and the average positivprocent within each kommune
    @GetMapping("/kommuner")
    public String kommuner(Model model){
        model.addAttribute("kommuner", kommuneService.findAll());
        return "kommuner";
    }

    //Getmapping page to retrieve information to create new sogn
    @GetMapping("/create")
    public String create(Model model){
        //add kommuner to be selected from
        model.addAttribute("kommuner", kommuneService.findAll());
        return "createSogn";
    }

    //postmapping method saves newly created sogn and returns to homepage
    @PostMapping("/create")
    public String create(@ModelAttribute Sogn sogn, WebRequest request){
        sognService.create(sogn);
        return "redirect:/";
    }

    //Getmapping page to retrieve information to create new kommune
    @GetMapping("/createKommune")
    public String createKommune(){
        return "createKommune";
    }

    //postmapping creates new kommune and redirects to kommuner overview
    @PostMapping("/createKommune")
    public String createKommune(@ModelAttribute Kommune kommune){
        kommuneService.create(kommune);
        return "redirect:/kommuner";
    }

    //getmapping to retrieve information to update sogn
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        model.addAttribute("sogn", sognService.findById(id));
        //add kommuner to choose from
        model.addAttribute("kommuner", kommuneService.findAll());
        return "updateSogn";
    }

    //postmapping updates sogn
    @PostMapping("/update")
    public String update(@ModelAttribute Sogn sogn){
        sognService.update(sogn);
        return "redirect:/";
    }

    //getmapping to delete sogn
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        sognService.deleteById(id);
        return "redirect:/";
    }
}
