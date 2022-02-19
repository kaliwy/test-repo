package com.lagou.controller;

import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.lagou.controller
 * @description: 课程和章节控制器
 * @author: 霂惷
 */
@RestController
@RequestMapping("/courseLesson")
public class CourseLessonController {
    @Autowired
    private CourseLessonService courseLessonService;
    @RequestMapping("/findSectionAndLessonById")
    public ResponseResult findSectionAndLessonById(Integer courseId){
        CourseSection courseSection = courseLessonService.findSectionAndLessonById(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "获取成功", courseSection);
        return responseResult;
    }
}
