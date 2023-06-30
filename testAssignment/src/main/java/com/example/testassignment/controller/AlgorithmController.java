package com.example.testassignment.controller;

import com.example.testassignment.service.algorithm.AlgorithmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/algorithm")
@RequiredArgsConstructor
public class AlgorithmController {
    private final AlgorithmService algorithmService;

    @GetMapping
    public String getAlgorithmPage() {
        return "algorithm";
    }

    @PostMapping
    public String calculate(@RequestParam(name = "userText") String userText, Model model) {
        model.addAttribute("userText", userText);
        model.addAttribute("uniqueCharacter", algorithmService.calculate(userText));
        return "algorithm";
    }
}
