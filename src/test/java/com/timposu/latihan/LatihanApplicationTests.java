package com.timposu.latihan;

import com.timposu.latihan.dao.EmailDao;
import com.timposu.latihan.dao.PersonDao;
import com.timposu.latihan.dao.PhoneDao;
import com.timposu.latihan.model.Email;
import com.timposu.latihan.model.Person;
import com.timposu.latihan.model.Phone;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LatihanApplicationTests {

        @Autowired
        private PersonDao pd;
        
        @Autowired
        private DataSource ds;
        
        @Autowired
        private EmailDao ed;
        
        @Autowired
        private PhoneDao phd;
          
	@Test
	public void insert() {
            Person p1 = new Person();
            p1.setId(1L);
            p1.setFirstName("Ucup");
            p1.setLastName("Timposu");
            p1.setAddress("Jalan Kedondong Palu");
            pd.save(p1);
            
            Person p2 = new Person();
            p2.setId(2L);
            p2.setFirstName("Azka");
            p2.setLastName("Zaky");
            p2.setAddress("Jalan Ahmad Yani");
            pd.save(p2);
            
            Email email1 = new Email();
            email1.setEmailAddress("ucup@gmail.com");
            email1.setPerson(p1);
            ed.save(email1);
            
            Email email2 = new Email();
            email2.setEmailAddress("azka@azaky.com");
            email2.setPerson(p2);
            ed.save(email2);
            
            Phone phone1 = new Phone();
            phone1.setModifiedDate(new Date());
            phone1.setPersons(p1);
            phone1.setPhoneNumber("08232");
            
            Phone phone2 = new Phone();
            phone2.setModifiedDate(new Date());
            phone2.setPersons(p1);
            phone2.setPhoneNumber("635352");
            
            Phone phone3 = new Phone();
            phone3.setModifiedDate(new Date());
            phone3.setPersons(p1);
            phone3.setPhoneNumber("0878");
            
            Phone phone4 = new Phone();
            phone4.setModifiedDate(new Date());
            phone4.setPersons(p2);
            phone4.setPhoneNumber("87878");
            
            Phone phone5 = new Phone();
            phone5.setModifiedDate(new Date());
            phone5.setPersons(p2);
            phone5.setPhoneNumber("082328466");
            
            Phone phone6 = new Phone();
            phone6.setModifiedDate(new Date());
            phone6.setPersons(p1);
            phone6.setPhoneNumber("564333635352");
            
            phd.save(phone1);
            phd.save(phone2);
            phd.save(phone3);
            phd.save(phone4);
            phd.save(phone5);
            phd.save(phone6);
            
        }

}
