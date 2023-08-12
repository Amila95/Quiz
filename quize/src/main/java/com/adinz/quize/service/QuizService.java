package com.adinz.quize.service;

import com.adinz.quize.DTO.QuestationDTO;
import com.adinz.quize.DTO.ResponseDTO;
import com.adinz.quize.modal.Question;
import com.adinz.quize.modal.Quize;
import com.adinz.quize.repository.QuestionRepository;
import com.adinz.quize.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuize(String category, int noQ, String title) {
        List<Question> questionList = questionRepository.createRandomQuestionUsingTypeandNoQ(category,noQ);


        Quize quize = new Quize();
        quize.setTitle(title);
        quize.setQuestions(questionList);
        quizRepository.save(quize);
        return new ResponseEntity("Created", HttpStatus.CREATED) ;
    }

    public ResponseEntity<List<QuestationDTO>> getQueiz(int id) {
        Optional<Quize> quize = quizRepository.findById(id);
        List<Question> questionList = quize.get().getQuestions();
        List<QuestationDTO> questionDTOList = new ArrayList<>();
        for(Question q : questionList){
            QuestationDTO questationDTO = new QuestationDTO(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionDTOList.add(questationDTO);
        }
        return new ResponseEntity(questionDTOList, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(int id, List<ResponseDTO> responseDTOS) {
        Optional<Quize> quize = quizRepository.findById(id);
        return new ResponseEntity(0,HttpStatus.OK);
    }
}
