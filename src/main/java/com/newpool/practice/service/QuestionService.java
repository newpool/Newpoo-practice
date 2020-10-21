package com.newpool.practice.service;

import com.newpool.practice.dto.PaginationDTO;
import com.newpool.practice.dto.QuestionDTO;
import com.newpool.practice.mapper.QuestionMapper;
import com.newpool.practice.mapper.UserMapper;
import com.newpool.practice.model.Question;
import com.newpool.practice.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-27 15:08
 **/
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * @param page
     * @param size
     * @return com.newpool.practice.dto.QuestionDTO
     * @Author zp
     * @Description //TODO 查询问题列表
     * @Date 15:54 2020/9/27
     * @Param []
     */
    public PaginationDTO list(Integer page, Integer size) {

        //实现分页 计算分页
        Integer pageIndex = (page - 1) * size;
        Integer pageCount = questionMapper.selectCount();

        //问题列表包含用户信息
        List<Question> questionList = questionMapper.selectList(pageIndex, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questionList
        ) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        paginationDTO.setPagination(pageCount, page, size);
        return paginationDTO;
    }
}
