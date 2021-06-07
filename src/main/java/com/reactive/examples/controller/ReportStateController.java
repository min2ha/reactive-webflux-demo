package com.reactive.examples.controller;

import com.reactive.examples.model.ReportState;
import com.reactive.examples.model.User;
import com.reactive.examples.service.ReportStateService;
import com.reactive.examples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/client/reports")
public class ReportStateController {

    @Autowired
    private ReportStateService reportStateService;

    @GetMapping
    public Flux<ReportState> getAllReportStates(){
        return reportStateService.findAll();
    }
}
