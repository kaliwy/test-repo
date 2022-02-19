package com.lagou.service.impl;

import com.lagou.dao.CourseLessonMapper;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @program: com.lagou.service.impl
 * @description: 课程及章节相关操作
 * @author: 霂惷
 */
@Service
public class CourseLessonImpl implements CourseLessonService {
    @Autowired
    private CourseLessonMapper courseLessonMapper;
    @Override
    public CourseSection findSectionAndLessonById(Integer id) {
        return courseLessonMapper.findSectionAndLessonById(id);
    }
}
