package com.spring_demo.demo.service.impl;

import com.spring_demo.demo.entity.Area;
import com.spring_demo.demo.service.AreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {

    @Autowired
    private AreaService areaServiceImpl;

    @Test
    public void queryArea() {
        List<Area> areaList = areaServiceImpl.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    public void queryAreaById() {
    }

    @Test
    public void insertArea() {
    }

    @Test
    public void updateArea() {
    }

    @Test
    public void deleteArea() {
    }
}