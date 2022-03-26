package com.xiaoqu.demo1;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {

//    1.数组的类型
    private String[] courses;
//    2.list集合的类型
    private List<Course> list;
//    3.set集合的类型
    private Set<String> sets;
//    4.map集合类型
    private Map<String,String> maps;

    public void setCourses(String[] courses){
        this.courses = courses;
    }

    public void setList(List<Course> list){
        this.list = list;
    }

    public void setSets(Set<String> sets){
        this.sets = sets;
    }

    public void setMaps(Map<String,String> maps){
        this.maps = maps;
    }

}
