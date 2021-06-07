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
@Table("reportdetails")
public class ReportDetails {
    @Id
    private Integer report_details_id;
    private String report_more_details;
}
