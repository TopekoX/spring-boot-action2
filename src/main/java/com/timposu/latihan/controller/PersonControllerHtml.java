package com.timposu.latihan.controller;

import com.timposu.latihan.dao.PersonDao;
import com.timposu.latihan.model.Person;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ucup
 * @url http://timposu.com
 * @email ucup.timposu@gmail.com
 */
@Controller
@RequestMapping("/person")
public class PersonControllerHtml {
    
    @Autowired
    private PersonDao pd;
    
    @RequestMapping("/list")
    public void listPerson(Model m) {
        m.addAttribute("persons", pd.findAll());
    }
    
    @RequestMapping("/delete")
    public String listPerson(@RequestParam("id") Long id) {
        pd.delete(id);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(@RequestParam(value = "id", required = false) Long id,
            Model model) {
        
        model.addAttribute("person", new Person());
        
        if (id != null) {
            Person p = pd.findOne(id);
            if (p != null) {
                model.addAttribute("person", p);
            }           
        }
        return "/person/form";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String prosesForm(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/person/form";
        }
        pd.save(person);
        return "redirect:list";
    }
}
