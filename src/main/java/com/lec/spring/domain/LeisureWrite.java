package com.lec.spring.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  LeisureWrite {
    private Long id;
    private int company_id;
    private String name;
    private Long price;
    private String content;
    private String address;

    private User user_id;

    @ToString.Exclude
    @Builder.Default
    private List<LeisureFileDTO> files = new ArrayList<>();

    private CompanyWrite companyWrite;
    private Review review;

    private String imageName;

    //별점
    private Double avg_star;

}