package com.lagou.dao;

import com.lagou.domain.CourseSection;

public interface CourseLessonMapper {
    public CourseSection findSectionAndLessonById(Integer id);
}
