package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * @program: com.lagou.service.impl
 * @description: 课程先关信息操作
 * @author: 霂惷
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        return courseMapper.findCourseByCondition(courseVO);
    }

    @Override
    public void insertCourse(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVO);
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        courseMapper.insertCourse(course);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);
        teacher.setCourseId(course.getId());
        courseMapper.insertTeacher(teacher);
    }

    @Override
    public CourseVO findCourseById(Integer id){
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourse(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVO);
        Date date = new Date();
        course.setUpdateTime(date);
        courseMapper.updateCourse(course);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        courseMapper.updateTeacher(teacher);

    }


}
