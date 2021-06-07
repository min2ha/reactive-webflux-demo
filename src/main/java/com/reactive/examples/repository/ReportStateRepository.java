package com.reactive.examples.repository;

import com.reactive.examples.model.ReportState;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ReportStateRepository extends ReactiveCrudRepository<ReportState,Integer> {
     Flux<ReportState> findAll();
}
