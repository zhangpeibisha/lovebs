package org.nix.zhangpei.love.recording.controller.controller;

import cn.hutool.json.JSONUtil;
import org.nix.zhangpei.love.recording.controller.controller.exception.ControllerException;
import org.nix.zhangpei.love.recording.controller.controller.resolver.User;
import org.nix.zhangpei.love.recording.controller.dto.message.MessageBoardDTO;
import org.nix.zhangpei.love.recording.controller.dto.result.BaseResultDTO;
import org.nix.zhangpei.love.recording.service.MessageBoardService;
import org.nix.zhangpei.love.recording.service.vo.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 留言控制器
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/31
 */
@RestController
@RequestMapping(value = "/message")
public class MessageBoardController {

    @Resource
    private MessageBoardService messageBoardService;

    @GetMapping(value = "/leaveComments")
    public BaseResultDTO writerMessage(@ModelAttribute @Valid MessageBoardDTO messageBoard,
                                       @User UserVO userVO,
                                       BindingResult bindingResult)throws ControllerException {

        boolean b = bindingResult.hasErrors();
        System.out.println(b);
        while (b){
            Map<String, Object> model = bindingResult.getModel();
            System.out.println(JSONUtil.toJsonStr(model) + " error");
        }

        Long readerId = messageBoard.getReaderId();
        Long writerId = messageBoard.getWriterId();
        String message = messageBoard.getMessage();
        // 登陆id
        Long loginId = userVO.getId();
        if (!loginId.equals(writerId)) {
            throw new ControllerException(String.format("用户信息异常，登陆id：%d -> 写入id：%d",loginId,writerId));
        }
        System.out.println(JSONUtil.toJsonStr(messageBoard));
        System.out.println(JSONUtil.toJsonStr(userVO));
        return new BaseResultDTO("写留言成功", HttpStatus.OK.value());
    }

    private Map<String,Object> getError(Errors errors){
        Map<String, Object> errMap = new HashMap<>();
        // 获取错误列表
        List<ObjectError> oes = errors.getAllErrors();
        for (ObjectError oe : oes) {
            String key = null;
            String msg = null;
            // 字段错误
            if (oe instanceof FieldError) {
                FieldError fe = (FieldError) oe;
                // 获取错误验证字段名
                key = fe.getField();
            } else {
                // 非字段错误
                // 获取验证对象名称
                key = oe.getObjectName();
            }
            // 错误信息
            msg = oe.getDefaultMessage();
            errMap.put(key, msg);
        }
        return errMap;
    }
}
