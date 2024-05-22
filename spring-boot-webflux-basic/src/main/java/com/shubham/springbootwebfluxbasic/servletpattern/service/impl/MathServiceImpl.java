package com.shubham.springbootwebfluxbasic.servletpattern.service.impl;

import com.shubham.springbootwebfluxbasic.servletpattern.dto.Response;
import com.shubham.springbootwebfluxbasic.servletpattern.service.MathService;
import com.shubham.springbootwebfluxbasic.servletpattern.utils.ResponsUtility;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class MathServiceImpl implements MathService {

    @Override
    public ResponseEntity<Response<Integer>> findSquare(int number) {
        int square = number * number;
        return ResponsUtility.getSuccessResponse(square, "Square of " + number + " is " + square);
    }

    @Override
    public ResponseEntity<Response<List<String>>> findTable(int number) {
        List<String> table = IntStream.rangeClosed(1, 10).mapToObj(i -> String.format("%d * %d = %d", number, i, number * i)).toList();
        return ResponsUtility.getSuccessResponse(table, "Table of " + number);
    }

}
