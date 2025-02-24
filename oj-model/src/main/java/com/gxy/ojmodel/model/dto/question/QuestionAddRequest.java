package com.gxy.oj.model.dto.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/ligxy">程序员鱼皮</a>
 * @from <a href="https://gxy.icu">编程导航知识星球</a>
 */
@Data
public class QuestionAddRequest implements Serializable {

    private static final long serialVersionUID = 6519198040696793633L;

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