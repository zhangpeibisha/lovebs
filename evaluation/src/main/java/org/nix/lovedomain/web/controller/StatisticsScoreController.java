package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.nix.lovedomain.dao.model.StatisticsScoreModel;
import org.nix.lovedomain.service.StatisticsScoreService;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Api(value = "问卷统计管理", description = "问卷统计信息查询")
@Controller
@RequestMapping(value = "statisticsScore")
public class StatisticsScoreController {

    @Autowired
    StatisticsScoreService statisticsScoreService;

    /**
     * 根据发布问卷的id和统计类型获取问卷的统计信息
     *
     * @return
     */
    @ApiOperation("查询统计信息")
    @RequestMapping(value = "pqna", method = RequestMethod.GET)
    public void getPQNa(@RequestParam("id") Integer id, @RequestParam("type") Integer type, HttpServletResponse response) throws IOException {
        StatisticsScoreModel statisticsScoreModel = statisticsScoreService.getPQNa(id, type);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONUtil.toJsonStr(RespondsMessage.success("获取数据成功",
                statisticsScoreModel)));
    }
}
