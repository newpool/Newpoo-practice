package com.newpool.practice.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: practice
 * @description:封装分页
 * @author: zp
 * @create: 2020-10-13 14:47
 **/
@Data
public class PaginationDTO<T> {
    //返回实体
    private List<T> questions;
    //首页 是否展示
    private boolean showFirstPage;
    //上一页 是否展示
    private boolean showPrevious;
    //下一页 是否展示
    private boolean showNext;
    //尾页 是否展示
    private boolean showEndPage;
    //当前页
    private Integer page;
    //显示当前所有页码
    private List<Integer> pages = new ArrayList<>();
    //总页数
    private Integer totalPage;
    /**
     * @return void
     * @Author zp
     * @Description //TODO 计算分页
     * @Date 15:23 2020/10/13
     * @Param [pageCount, page, size]
     **/
    public void setPagination(Integer pageCount, Integer page, Integer size) {
        //计算总页数
        if (pageCount % size == 0) {
            totalPage = pageCount / size;
        } else {
            totalPage = pageCount / size + 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        if (page < 1) {
            page = 1;
        }
        this.page = page;
        //计算每一页显示页标
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否展示首页:在第一页不展示首页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //是否展示尾页：在最后一页不展示尾页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
