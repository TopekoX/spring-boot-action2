package com.timposu.latihan.dao;

import com.timposu.latihan.model.Phone;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ucup
 * @url http://timposu.com
 * @email ucup.timposu@gmail.com
 */
public interface PhoneDao extends PagingAndSortingRepository<Phone, Long>{

}
