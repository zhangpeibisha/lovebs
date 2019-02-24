package org.nix.lovedomain.rbac.bean.po;

import lombok.Data;
import org.nix.lovedomain.rbac.util.auth.core.extractor.RequestMethod;
import org.nix.lovedomain.rbac.util.auth.core.extractor.Resources;

import java.util.Set;

@Data
public class Permisson {

    private Integer permissonId;

    private String permissonName;

    private String permissonUrl;

    private Integer parentPermissonId;

    private String parentPermissonName;

    private Integer permissonLv;
    /**
     * 资源请求方法
     */
    private String methods;

    /**
     * 资源描述
     */
    private String description;
    /**
     * 资源是否开放
     */
    private Boolean open;

    /**
     * 是否允许未登录访问
     */
    private Boolean permitAll;

    public void resourcesToPermission(Resources resources) {
        if (resources != null) {
            permissonName = resources.getName();
            permissonUrl = resources.getUrl();
            Set<RequestMethod> httpMethods = resources.getHttpMethods();
            StringBuilder methods = new StringBuilder();
            httpMethods.forEach(requestMethod -> methods.append(requestMethod.toString()).append("&"));
            if (methods.length()!=0){
                methods.deleteCharAt(methods.lastIndexOf("&"));
            }
            this.methods = methods.toString();
            this.description = resources.getDescription();
            this.open = resources.getOpen();
            this.permitAll = resources.getPermitAll();
        }
    }
}