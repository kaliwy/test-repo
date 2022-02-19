package com.lagou.domain;

/**
 * @program: com.lagou.domain
 * @description: 查询课程所需参数的封装
 * @author: 霂惷
 */
public class CourseVO {
    private String courseName;
    private Integer status;

    @Override
    public String toString() {
        return "CourseVO{" +
                "courseName='" + courseName + '\'' +
                ", status=" + status +
                '}';
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
