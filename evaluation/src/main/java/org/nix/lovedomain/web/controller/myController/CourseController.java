package org.nix.lovedomain.web.controller.myController;

import org.nix.lovedomain.model.Course;
import org.nix.lovedomain.service.myService.CourseService;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Controller
@RequestMapping(value = "course")
public class CourseController extends BaseController<Course> {

    @Autowired
    CourseService courseService;
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public int testList(){
     return   courseService.testList();
    }
}
