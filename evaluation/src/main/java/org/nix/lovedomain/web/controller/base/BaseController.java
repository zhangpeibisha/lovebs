package org.nix.lovedomain.web.controller.base;

import io.swagger.annotations.ApiParam;
import org.nix.lovedomain.service.vo.LimitVO;
import org.nix.lovedomain.utils.ConditionStr;
import org.nix.lovedomain.utils.SQLUtil;
import org.nix.lovedomain.component.ReflectEngine;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @version 1.0
 * @anthor zsl on 2019/3/30
 * @since jdk8
 *
 * controller的基础类，通过反射去执行service
 */
public class BaseController<M> {

    @Resource
    protected ReflectEngine reflectEngine;

    protected String invokeObjName;

    /**
     * 批量删除数据
     * @param ids
     * @return
     */

    @RequestMapping(value = "deletes",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deletes(@ApiParam("用户id数组") @RequestParam Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        getInvokeObjName();
        Integer status = 0;
        try {
            status =  (Integer) reflectEngine.invokeMapperMethod("deletes",
                    invokeObjName,
                    new Class[]{Integer[].class},
                    new Object[]{ids});
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("status",status);
        return map;
    }

    /**
     * 删除一条数据
     * @param id
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> delete(@ApiParam("用户id") @RequestParam  Integer id){
        Map<String,Object> map = new HashMap<>();
        getInvokeObjName();
        Integer status  = null;
        try {
            status = (Integer) reflectEngine.invokeMapperMethod("delete",invokeObjName,new Class[]{Integer.class},id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
         map.put("status",status);
        return map;
    }

    /**
     * 添加一条数据
     * @param model
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(@ModelAttribute M model){
        Map<String,Object> map = new HashMap<>();
        getInvokeObjName();
        Integer status = 0;
        try {
             status = (Integer) reflectEngine.invokeMapperMethod("add",invokeObjName,new Class[]{Object.class},model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status",status);
        return map;
    }

    /**
     * 更新一条数据
     * @param model
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> update(@ModelAttribute M model){
        Map<String,Object> map = new HashMap<>();
        getInvokeObjName();
        Integer status = 0;
        try {
            status = (Integer) reflectEngine.invokeMapperMethod("update",invokeObjName,new Class[]{Object.class},model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("status",status);
        return map;
    }

    /**
     * 根据条件查询数据条数
     * @return
     */
    @RequestMapping(value = "queryAmount",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> queryAmount(@ModelAttribute M m){
          Map<String,Object> map = new HashMap<>();
        Long account = 0L;
        getInvokeObjName();
        Class clazz = m.getClass();
        Object[] values  = getParameters(clazz,m);
        String[] names = getParameterNames(clazz,m);
        try {
             account = (Long) reflectEngine.invokeMapperMethod(
                     "queryAmount",
                     invokeObjName,
                     new Class[]{String.class},
                     SQLUtil.fillCondition(ConditionStr.sqlTemplate(names),values));
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("account",account);
        return  map;
    }

    /**
     * 根据id查询一条数据
     * @param id
     * @return
     */
    @RequestMapping(value = "findById",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findById(@ApiParam("用户id") @RequestParam Integer id){
        Map<String,Object> map = new HashMap<>();
        Object m = null;
        getInvokeObjName();
        try {
            m  =  reflectEngine.invokeMapperMethod("findById",invokeObjName,new Class[]{Integer.class},id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("object",m);
        return  map;
    }

    /**
     * 获取数据列表
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(@ModelAttribute M m, @ModelAttribute LimitVO limitVO){
        Class clazz = m.getClass();
        Map<String,Object> map = new HashMap<>();
        // 获取被调用对象的名称
        getInvokeObjName();
        Object[] values  = getParameters(clazz,m);
        String[] names = getParameterNames(clazz,m);

        List<Model> list = null;
        try {
            // 条件查询
            list = (List<Model>) reflectEngine.invokeMapperMethod(
                    "list",
                    invokeObjName,
                    new Class[]{Integer.class, Integer.class,String.class},
                    limitVO.getCurPage(),
                    limitVO.getLimit(),
                    SQLUtil.fillCondition(ConditionStr.sqlTemplate(names),values));
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("list",list);
        return map;

    }

    /**
     * 获取被调用对象的名字
     */
    protected void getInvokeObjName(){
        invokeObjName = this.getClass().getSimpleName();
        invokeObjName = invokeObjName.replace("Controller","Service");
        invokeObjName = invokeObjName.substring(0,1).toLowerCase()+invokeObjName.substring(1);
    }

    /**
     * 通过反射获取参数值
     * @param clazz
     * @return
     */
    protected Object[] getParameters(Class clazz,M m)  {
        ArrayList arrayList = new ArrayList();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f:
             fields) {
            f.setAccessible(true);
            try {
                if(f.get(m) != null && !f.get(m).equals(0)&&!f.getName().equals("serialVersionUID")){
                    // 获取域的值
                    arrayList.add(f.get(m));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Object[] values = new Object[arrayList.size()];

        for(int i = 0; i < arrayList.size(); i++){
            values[i] = arrayList.get(i);
        }

        return  values;
    }

    /**
     * 获取参数域的名称
     * @param clazz
     * @param m
     * @return
     */
    protected String[] getParameterNames(Class clazz,M m){
        ArrayList<String> arrayList = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f:
                fields) {
            f.setAccessible(true);
            try {
                if(f.get(m) != null && !f.get(m).equals(0) && !f.getName().equals("serialVersionUID")){
                    // 获取域的名称
                    arrayList.add(f.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        String[] values = new String[arrayList.size()];

        for(int i = 0; i < arrayList.size(); i++){
            values[i] = arrayList.get(i);
        }
        return  values;
    }

}
