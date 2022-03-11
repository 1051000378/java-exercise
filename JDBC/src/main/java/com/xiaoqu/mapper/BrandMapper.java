package com.xiaoqu.mapper;

import com.xiaoqu.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    //查询所有
    public List<Brand> selectAll();
    // 通过id查询
    public Brand selectById(int id);
    //多条件查询
    public List<Brand> selectByCondition1(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
    public List<Brand> selectByCondition2(Brand brand);
    public List<Brand> selectByCondition3(Map map);
    public List<Brand> selectByConditionSingle(Brand brand);

//    添加
    void add(Brand brand);
    //添加成功返回主键
    Integer addKey(Brand brand);

    // 修改
    void update(Brand brand);
    //编辑是为空的不修改
    void update1(Brand brand);

    // 删除
    void delete(Brand brand);
    void deleteById(int id);  //根据id删除
    void deleteByIds(int[] id);//批量删除

}
