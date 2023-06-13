package com.web.dao.Impl;

import com.web.dao.SysRegionDao;
import com.web.entity.SysRegion;
import com.web.utils.BaseDao2;

import java.util.List;
import java.util.Map;

public class SysRegionDaoImpl extends BaseDao2<SysRegion> implements SysRegionDao {

    @Override
    public List<SysRegion> getSysRegionsByPid(String pid) {
        return selectListForObject("SELECT * FROM sys_region where region_parent_id=?",SysRegion.class,pid);
    }

    @Override
    public Integer countAll() {
        String sql = "select count(1) as count from sys_region ";
        Map<String,Object> map = selectOneForMap(sql);
        String count = map.get("count").toString();
        return Integer.parseInt(count);
    }

    @Override
    public List<SysRegion> getSysRegions(Integer startIndex, Integer pageSize) {
        String sql = "select * from sys_region limit ?,?";
        return selectListForObject(sql,
                SysRegion.class,startIndex,pageSize);
    }
}
