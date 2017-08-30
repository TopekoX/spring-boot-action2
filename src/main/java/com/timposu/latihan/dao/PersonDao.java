package com.timposu.latihan.dao;

import com.timposu.latihan.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ucup
 * @url http://timposu.com
 * @email ucup.timposu@gmail.com
 */
public interface PersonDao extends PagingAndSortingRepository<Person, Long>{
  
}
