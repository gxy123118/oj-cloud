package com.gxy.oj.model.dto.question;

import lombok.Data;

import java.io.Serializable;

import java.util.List;

/**
 * 编辑请求
 *
 * @author <a href="https://github.com/ligxy">程序员鱼皮</a>
 * @from <a href="https://gxy.icu">编程导航知识星球</a>
 */
@Data
public class QuestionEditRequest implements Serializable {
    private static final long serialVersionUID = 7810934307463832541L;
    /**
     * 题目id
     */

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;


    /**
     * 判断用例（json 数组）
     */
    private List<JudgeCase> judgeCase;

    /**
     * 判断配置（json 对象）
     */
    private JudgeConfig judgeConfig;

}