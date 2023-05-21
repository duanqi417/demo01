package com.duan.mapper;

import com.duan.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    Course selectById(Integer id);
    List<Course> selectAllBySchool(Integer school);
    int updateByHours(@Param("hours") int hours, @Param("id") int id);
    int insertAll(@Param("name") String name,@Param("hours") int hours,@Param("schools") int schools);
    List<Course> selectAll();


}
