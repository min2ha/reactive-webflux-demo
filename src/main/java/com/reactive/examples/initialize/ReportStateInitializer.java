package com.reactive.examples.initialize;

import com.reactive.examples.model.ReportState;
import com.reactive.examples.model.User;
import com.reactive.examples.repository.ReportStateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Component
@Profile("!test")
@Slf4j
public class ReportStateInitializer implements CommandLineRunner {

    @Autowired
    private ReportStateRepository reportStateRepository;

    @Override
    public void run(String... args) throws Exception { initialDataSetup(); }


    private List<ReportState> getData(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return Arrays.asList(new ReportState(null,1,1, timestamp, timestamp),
                new ReportState(null,2,2, timestamp, timestamp),
                new ReportState(null,3,3, timestamp, timestamp));
    }

    private void initialDataSetup() {

        reportStateRepository.deleteAll()
                .thenMany(Flux.fromIterable(getData()))
                .flatMap(reportStateRepository::save)
                .thenMany(reportStateRepository.findAll())
                .subscribe(reportState -> {
                    log.info("ReportState Inserted from CommandLineRunner " + reportState);
                });
    }


}
