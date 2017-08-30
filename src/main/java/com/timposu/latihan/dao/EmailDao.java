package com.timposu.latihan.dao;

import com.timposu.latihan.model.Email;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ucup
 * @url http://timposu.com
 * @email ucup.timposu@gmail.com
 */
public interface EmailDao extends PagingAndSortingRepository<Email, Long> {

}
