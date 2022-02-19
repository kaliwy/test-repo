package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: com.lagou.controller
 * @description: 课程信息相关操作
 * @author: 霂惷
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){
        List<Course> course = courseService.findCourseByCondition(courseVO);
        return  new ResponseResult(true, 200, "响应成功", course);
    }

    @RequestMapping("/uploadPic")
    public ResponseResult uploadPic(@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        if(file.isEmpty()){
            throw new RuntimeException();
        }
        String originalFilename = file.getOriginalFilename();
        String fileName = System.currentTimeMillis()+originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("文件名："+fileName);
        String realPath = httpServletRequest.getServletContext().getRealPath("/");
        String newPath = realPath.substring(0, realPath.indexOf("ssm_controller"))+"uploadPic\\";
        System.out.println("文件存放目录："+newPath);
        File newFile= new File(newPath, fileName);
        if(!newFile.getParentFile().exists()){
            newFile.getParentFile().mkdirs();
            System.out.println("创建的目录位置："+newFile.getParentFile());
        }
        file.transferTo(newFile);
        Map<String, String> hashMap = new HashMap();
        hashMap.put("fileName", fileName);
        hashMap.put("filePath", newPath+fileName);
        return new ResponseResult( true, 200, "上传成功", hashMap);
    }
    
    @RequestMapping("/insertCourse")
    public ResponseResult insertCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
 /*       if(courseVO.getId != null) {
            courseService.updateCourse(courseVO);
            return new ResponseResult(true, 200, "更改成功", null);
        }*/
            courseService.insertCourse(courseVO);
            return new ResponseResult(true, 200, "添加成功", null);

    }

    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id){
        return new ResponseResult(true, 200, "获取课程信息成功", courseService.findCourseById(id));
    }


}
