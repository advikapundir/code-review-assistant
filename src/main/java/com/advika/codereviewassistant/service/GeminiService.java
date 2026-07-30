package com.advika.codereviewassistant.service;

import com.advika.codereviewassistant.dto.gemini.Content;
import com.advika.codereviewassistant.dto.gemini.GeminiRequest;
import com.advika.codereviewassistant.dto.gemini.Part;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.advika.codereviewassistant.dto.gemini.GeminiResponse;

import java.util.List;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;


    private final RestClient restClient;

    public GeminiService() {
        this.restClient = RestClient.builder().build();
    }

    public String reviewCode(String sourceCode) {

        String prompt = """
You are a senior software engineer performing a professional code review.

Analyze the code carefully and return the response strictly in markdown format.

Follow this structure exactly.

# Overall Score
Give a score out of 10 and briefly explain the rating.

# Bugs
- Identify all bugs.
- Explain why each bug occurs.
- Suggest how to fix it.
- If there are no bugs, write "No bugs found."

# Code Quality
- Review naming conventions.
- Review readability.
- Review maintainability.
- Review code structure.

# Performance
- Identify bottlenecks.
- Suggest optimizations.
- Mention the time and space complexity whenever possible.

# Best Practices
- Mention violations of coding standards.
- Suggest design improvements.
- Suggest better approaches if applicable.

# Security
- Mention any security concerns.

# Improved Code
Return the complete improved code inside a markdown code block.

Important rules:
- Use clear headings.
- Use bullet points.
- Be concise.
- Explain your reasoning.
- Keep the formatting clean and professional.

Code to review:

""" + sourceCode;

        GeminiRequest request = new GeminiRequest(
                List.of(
                        new Content(
                                List.of(
                                        new Part(prompt)
                                )
                        )
                )
        );

        String url =
                "https://generativelanguage.googleapis.com/v1/models/gemini-3.5-flash-lite:generateContent?key="
                        + apiKey;

        GeminiResponse response = restClient.post()
                .uri(url)
                .body(request)
                .retrieve()
                .body(GeminiResponse.class);

        if (response == null
                || response.getCandidates() == null
                || response.getCandidates().isEmpty()
                || response.getCandidates().get(0).getContent() == null
                || response.getCandidates().get(0).getContent().getParts() == null
                || response.getCandidates().get(0).getContent().getParts().isEmpty()) {

            return "No response received from Gemini.";
        }

        return response.getCandidates()
                .get(0)
                .getContent()
                .getParts()
                .get(0)
                .getText();
    }
}