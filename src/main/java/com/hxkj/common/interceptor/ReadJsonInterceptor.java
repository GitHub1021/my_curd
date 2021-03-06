package com.hxkj.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;

/**
 * 读取 客户端 post 请求 body json 对象 放入到 request 中
 * （ 不是 ajax datatype:'json" )
 * 此拦截器 针对 非web 环境下的客户端
 */
public class ReadJsonInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Controller c = inv.getController();
        String jsonStr = HttpKit.readData(c.getRequest());
        System.out.println(jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        c.setAttr("pdata", jsonObject);
        inv.invoke();
    }
}
