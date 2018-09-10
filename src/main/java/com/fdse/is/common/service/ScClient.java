package com.fdse.is.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * <pre>
 *     author : shenbiao
 *     e-mail : 1105125966@qq.com
 *     time   : 2018/09/09
 *     desc   :暂时没有用了
 *     version: 1.0
 * </pre>
 */
@FeignClient(name = "sc-client",
        url = "${sc.url}",
        fallback = ScClient.DefaultFallback.class)
public interface ScClient {

        @RequestMapping(value = "/user/getLocation", method = RequestMethod.POST)
        HashMap<String ,Double> getLocation(@RequestParam("userId") int userId);

        /**
         * 容错处理类，当调用失败时，简单返回空字符串
         */
        @Component
        class DefaultFallback implements ScClient {
                @Override
                public HashMap<String ,Double> getLocation(@RequestParam("userId") int userId) {
                        HashMap<String ,Double> result =new HashMap<String ,Double>();
                        result.put("longtitude", Double.valueOf(0));
                        result.put("latidude", Double.valueOf(0));
                        return result;
                }
        }
}
