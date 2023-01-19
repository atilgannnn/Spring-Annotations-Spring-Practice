package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);

        Course course=new Course();
        course.setName("SQL");

        CourseService service=context.getBean("zoomService",CourseService.class);
        service.teachCourse(course);
        service.saveCourse(course);
        //zoomService i newlemedik rica ettik:)
        //zoomService de repoya ihtiyacımız var ancak newlemedik eşantiyon geldi:)

        System.out.println("----------------------------------------------------------------");
        String[] beanNames=context.getBeanDefinitionNames();
        for (String name:beanNames ) {
            System.out.println("Bean name:"+name);
        }
//-----------------------------------
        CourseService service2=context.getBean("zoomService",CourseService.class);


    }

}
