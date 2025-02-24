package com.gxy.oj.common;

import com.gxy.oj.constant.CommonConstant;
import lombok.Data;

/**
 * 分页请求
 *
 * @author <a href="https://github.com/ligxy">程序员鱼皮</a>
 * @from <a href="https://gxy.icu">编程导航知识星球</a>
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private Integer current = 1;

    /**
     * 页面大小
     */
    private Integer pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;
}
