package com.spring_demo.demo.service.impl;

import com.spring_demo.demo.dao.AreaDao;
import com.spring_demo.demo.entity.Area;
import com.spring_demo.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(area.getCreateTime());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("插入区域信息异常");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息异常" + e.getMessage());

            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean updateArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0){
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaDao.updateArea(area);
                if (effectNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("区域信息更新失败" + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0){
            try {
                int effectNum = areaDao.deleteArea(areaId);
                if (effectNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败:" + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域Id不能为空！");
        }
    }
}
