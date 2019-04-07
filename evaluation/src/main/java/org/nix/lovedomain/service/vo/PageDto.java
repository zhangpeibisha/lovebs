package org.nix.lovedomain.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 分页包装类
 * @date 2019/4/7
 */
@Data
@Builder
public class PageDto<D> {

    private Integer page;

    private Integer limit;

    private Integer total;

    private List<D> data;

}
