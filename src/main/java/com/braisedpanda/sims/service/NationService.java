package com.braisedpanda.sims.service;

import com.braisedpanda.sims.bean.Nation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NationService {

    @Cacheable(value="nation" , key="'getNationById:'+#nation_id")
    Nation getNationById(String nation_id);

    //查询所有的nation
    @Cacheable(value="nation" )
    List<Nation> getAllNation();
}
