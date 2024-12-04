package com.example.crud_spring.Controller;

import com.example.crud_spring.Model.Course;
import com.example.crud_spring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Validated
@RestController
@RequestMapping("/api/courses")

public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public @ResponseBody List<Course> list() {
        return courseService.list();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course createCourse(@RequestBody @Valid Course course) {
        //return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable @NotNull @Positive Long id) {
        return courseService.findById(id);
    };

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course course) {
        return courseService.updateCourse(id, course);
    };

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        courseService.deleteCourse(id);
    }
}
