package com.adinz.quize.controller;

import com.adinz.quize.DTO.QuestationDTO;
import com.adinz.quize.DTO.ResponseDTO;
import com.adinz.quize.modal.Quize;
import com.adinz.quize.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noQ, @RequestParam String title){
        return quizService.createQuize(category,noQ,title);
        //return new ResponseEntity("Created", HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestationDTO>> getQuize(@PathVariable int id){
        return quizService.getQueiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuize(@PathVariable int id, @RequestBody List<ResponseDTO> responseDTOS){
        return quizService.submitQuiz(id,responseDTOS);
    }
}
