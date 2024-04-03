package com.example.comfyrental.Controllers;

import com.example.comfyrental.Services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;
    @RequestMapping("/createReview")
    public String createReview(){
        return "Review/createReview";
    }
}
