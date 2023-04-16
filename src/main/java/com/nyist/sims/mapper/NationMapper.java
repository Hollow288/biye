package com.nyist.sims.mapper;

import com.nyist.sims.bean.Nation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NationMapper {

    Nation getNationById(String nation_id);

    //查询所有的nation
    List<Nation> getAllNation();
}
