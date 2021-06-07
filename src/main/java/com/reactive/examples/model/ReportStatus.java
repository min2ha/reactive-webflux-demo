package com.reactive.examples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("reportstatus")
public class ReportStatus {
    @Id
    private Integer report_status_id;
    private Timestamp report_status_created;
}
