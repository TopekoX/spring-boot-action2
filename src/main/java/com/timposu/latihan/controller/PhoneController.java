package com.timposu.latihan.controller;

import com.timposu.latihan.dao.PersonDao;
import com.timposu.latihan.dao.PhoneDao;
import com.timposu.latihan.model.Person;
import com.timposu.latihan.model.Phone;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ucup
 * @url http://timposu.com
 * @email ucup.timposu@gmail.com
 */
@RestController
public class PhoneController {

    @Autowired
    private PhoneDao pd;
    
    @Autowired
    private PersonDao psd;

    @GetMapping(value = "/api/phone")
    public Page<Phone> list(Pageable pageable) {
        return pd.findAll(pageable);
    }
    
    @PostMapping(value = "/api/phone")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Map<String, Object> addPerson(@RequestBody @Valid Phone p) {
        Person ps = psd.findOne(1L);
        p.setPersons(ps);
        
        pd.save(p);
        Map<String, Object> result = new HashMap<>();
        result.put("pesan", "sukses");
        return result;
    }
    
    @DeleteMapping(value = "/api/phone/{id}")
    public Map<String, Object> deletePerson(@PathVariable(value = "id") Long id) {
        pd.delete(id);
        Map<String, Object> result = new HashMap<>();
        result.put("pesan", "sukses");
        return result;
    }
}
