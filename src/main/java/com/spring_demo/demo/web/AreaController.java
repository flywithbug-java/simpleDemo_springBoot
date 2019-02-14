package com.spring_demo.demo.web;

import com.spring_demo.demo.entity.Area;
import com.spring_demo.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.queryArea();
        modelMap.put("list",list);
        return modelMap;
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    private Map<String,Object> getAreaById(int id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.queryAreaById(id);
        if (area != null){
            modelMap.put("area",area);
        }else {
            modelMap.put("msg","未查询到结果");
        }
        return modelMap;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    private Map<String,Object> insertArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;
    }
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    private Map<String,Object> deleteArea(@RequestBody  Area area){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.deleteArea(area.getAreaId()));
        return modelMap;
    }
}
