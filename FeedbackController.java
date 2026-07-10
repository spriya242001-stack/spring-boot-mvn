package com.example.productcatalog.controller;

import com.example.productcatalog.entity.FeedbackEntity;
import com.example.productcatalog.repository.FeedbackRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    private final FeedbackRepository repository;

    // Excellent practice using constructor injection here!
    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedbackObj", new FeedbackEntity());
        return "feedback";
    }

    @PostMapping("/saveFeedback")
    public String saveFeedback(
            @ModelAttribute("feedbackObj") FeedbackEntity feedback,
            Model model) {

        // Fixed: changed 'Feedback' to 'feedback' to match the variable parameter name
        repository.save(feedback);

        model.addAttribute("message", "feedback saved!");
        model.addAttribute("feedbackObj", new FeedbackEntity());

        return "feedback";
    }
}