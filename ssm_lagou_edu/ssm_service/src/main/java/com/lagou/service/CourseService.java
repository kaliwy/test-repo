package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {
    public List<Course> findCourseByCondition(CourseVO courseVO);
    public void insertCourse(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;
    public CourseVO findCourseById(Integer id);
    public void updateCourse(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;
}
