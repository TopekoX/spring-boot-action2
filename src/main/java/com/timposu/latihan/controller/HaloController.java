package com.timposu.latihan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ucup
 * @url http://timposu.com
 * @email ucup.timposu@gmail.com
 */
@Controller
public class HaloController {

    @RequestMapping(value = "/halorest", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> haloRest(@RequestParam(value = "nama", 
            required = false) String nama) {
        Map<String, Object> say = new HashMap<>();
        say.put("Date", new Date());
        say.put("nama", nama);
        return say;
    }
    
    @RequestMapping(value = "/halo", method = RequestMethod.GET)
    public Map<String, Object> haloHtml(@RequestParam(value = "nama", 
            required = false) String nama) {
        Map<String, Object> say = new HashMap<>();
        say.put("date", new Date());
        say.put("nama", nama);
        return say;
    }
    
    
}
