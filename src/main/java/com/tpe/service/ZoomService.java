package com.tpe.service;

import com.tpe.domain.Course;
import com.tpe.repository.Repository;
import com.tpe.thirdparty.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope("prototype")//prototypeda Spring beanin life cycleının tümünden sorumlu değildir.
public class ZoomService implements CourseService{

//    @Autowired//field injection
//    @Qualifier("cloudRepository")
//    private Repository repository;

//    @Autowired//setter injection
//    @Qualifier("cloudRepository")
//    private Repository repository;
//    public  void setRepository(Repository repository){
//        this.repository = repository;
//    }



    private Repository repository;//constructor injection,
    @Autowired//optional:tek constructor varsa
    public ZoomService(@Qualifier("cloudRepository") Repository repository) {
        this.repository = repository;
    }

    //thirdparty bir classın metoduna ihtiyacımız varsa
    @Autowired
    private InstructorService instructorService;

    @Value("${app.code}")
    String code;
    @Override
    public void teachCourse(Course course) {
        System.out.println(code+"-"+course.getName()+" dersi ile Zoom anlatılıyor...");
        instructorService.teach(course.getName(),"Jack Sparrow");
    }



    @Override
    public void saveCourse(Course course) {
        repository.save(course);

    }


}
