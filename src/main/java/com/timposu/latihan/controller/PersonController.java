package com.timposu.latihan.controller;

import com.timposu.latihan.dao.PersonDao;
import com.timposu.latihan.model.Person;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ucup
 * @url http://timposu.com
 * @email ucup.timposu@gmail.com
 */
@RestController
@RequestMapping(path = "/person")
public class PersonController {
    
    @Autowired
    private PersonDao dao;
    
    @RequestMapping(value = "/api/person", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Person> getPerson(Pageable pageable) {
        return dao.findAll(pageable);
    }
    
    @RequestMapping(value = "/api/person/id={id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Person> getOnePerson(@PathVariable("id") Long id) {
        Person p = dao.findOne(id);
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/person", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Map<String, Object> addPerson(@RequestBody @Valid Person p) {
        dao.save(p);
        Map<String, Object> result = new HashMap<>();
        result.put("pesan", "sukses");
        return result;
    }
    
    @RequestMapping(value = "/api/person/id={id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Map<String, Object> updatePerson(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid Person p) {
        p.setId(id);
        dao.save(p);
        Map<String, Object> result = new HashMap<>();
        result.put("pesan", "sukses");
        return result;
    }
    
    @RequestMapping(value = "/api/person/id={id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> deletePerson(@PathVariable(value = "id") Long id) {
        dao.delete(id);
        Map<String, Object> result = new HashMap<>();
        result.put("pesan", "sukses");
        return result;
    }
}
