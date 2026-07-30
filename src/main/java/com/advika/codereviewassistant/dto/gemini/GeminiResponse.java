package com.advika.codereviewassistant.dto.gemini;

import lombok.Data;
import java.util.List;

@Data
public class GeminiResponse {

    private List<Candidate> candidates;

    @Data
    public static class Candidate {
        private ResponseContent content;
    }

    @Data
    public static class ResponseContent {
        private List<PartResponse> parts;
    }
}