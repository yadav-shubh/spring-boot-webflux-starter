package com.shubham.springbootwebfluxbasic.servletpattern.resources;

import com.shubham.springbootwebfluxbasic.servletpattern.dto.Response;
import com.shubham.springbootwebfluxbasic.servletpattern.service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maths")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/square/{number}")
    public ResponseEntity<Response<Integer>> findSquare(@PathVariable int number) {
        return mathService.findSquare(number);
    }

    @GetMapping("/table/{number}")
    public ResponseEntity<Response<List<String>>> findTable(@PathVariable int number) {
        return mathService.findTable(number);
    }

}
