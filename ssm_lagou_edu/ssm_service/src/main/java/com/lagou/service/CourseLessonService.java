package com.lagou.service;

import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

public interface CourseLessonService {
    public CourseSection findSectionAndLessonById(Integer id);
}
