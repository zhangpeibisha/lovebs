package org.nix.lovedomain.web.controller;

import org.nix.lovedomain.model.Role;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Controller
@RequestMapping(value = "role")
public class RoleController extends BaseController<Role> {

}
