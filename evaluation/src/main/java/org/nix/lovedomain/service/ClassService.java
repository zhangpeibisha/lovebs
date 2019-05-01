package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.business.ClassBusinessMapper;
import org.nix.lovedomain.model.Class;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.service.vo.ClassVo;
import org.nix.lovedomain.service.vo.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @anthor  on 2019/4/19
 * @since jdk8
 */
@Service
public class ClassService extends BaseService {

    @Resource
    private ClassBusinessMapper classBusinessMapper;



}
