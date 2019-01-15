package org.nix.zpbs.pojo.dto.response.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import org.nix.zpbs.pojo.base.BaseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 校验参数异常时返回的异常信息
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/15
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ParameterErrorResponseDTO", description = "当用户输入参数错误时返回的信息")
public class ParameterErrorResponseDTO {

    @ApiModelProperty(value = "返回处理信息")
    private BaseResult info;

    @ApiModelProperty(value = "返回处理的参数错误信息，包含参数名字，用户输入，错误解释信息")
    private List<ParameterError> errors;

    public ParameterErrorResponseDTO(BaseResult info) {
        this.info = info;
    }

    /**
     * @param fieldName    参数名字
     * @param input        用户输入值
     * @param errorMessage 错误提示信息
     * @return 当前对象
     * @author zhangpe0312@qq.com
     * @description 添加错误的参数信息到集合中
     * @date 18:49 2019/1/15
     */
    public void addError(String fieldName, Object input, String errorMessage) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(new ParameterError(fieldName, input, errorMessage));
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModel(value = "ParameterError", description = "参数错误信息")
    public class ParameterError {

        public ParameterError(String fieldName, Object input, String errorMessage) {
            this.fieldName = fieldName;
            this.input = input;
            this.errorMessage = errorMessage;
        }

        @ApiModelProperty(value = "字段名字")
        private String fieldName;

        @ApiModelProperty(value = "用户输入信息")
        private Object input;

        @ApiModelProperty(value = "错误信息解释")
        private String errorMessage;
    }
}
