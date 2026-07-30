package com.advika.codereviewassistant.dto;

import lombok.Data;

@Data
public class ReviewRequest {

    private String language;

    private String sourceCode;
}