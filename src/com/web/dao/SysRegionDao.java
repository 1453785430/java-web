package com.web.dao;

import com.web.entity.SysRegion;

import java.util.List;

public interface SysRegionDao {
    List<SysRegion> getSysRegionsByPid(String pid);

    Integer countAll();

    List<SysRegion> getSysRegions(Integer startIndex, Integer pageSize);
}
