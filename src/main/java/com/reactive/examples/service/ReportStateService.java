package com.reactive.examples.service;

import com.reactive.examples.model.ReportState;
import com.reactive.examples.model.User;
import com.reactive.examples.repository.ReportStateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@Slf4j
@Transactional
public class ReportStateService {

    @Autowired
    private ReportStateRepository reportStateRepository;

    public Flux<ReportState> findAll(){
        return reportStateRepository.findAll();
    }

}
