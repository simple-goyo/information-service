package com.fdse.is.common.constant;


/**
 * <pre>
 *     author : shenbiao
 *     e-mail : 1105125966@qq.com
 *     time   : 2018/08/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class UrlConstant {

    /**
     * App后端url
     */
    public static final String APP_BACK_END_IP = "192.168.1.148";//142
    public static final String APP_BACK_END_PORT = "8081";

    //获取用户位置
    public static final String APP_BACK_END_USER_GET_LOCATION = "user/getLocation";

    public static String getAppBackEndServiceURL(String  service) {
        String serviceURL = String.format("http://%s:%s/%s", APP_BACK_END_IP, APP_BACK_END_PORT, service);
        return serviceURL;
    }

    /**
     * 本体库平台url
     */
    public static final String ONTOLOGY_IP = "192.168.1.142";//142
    public static final String ONTOLOGY_PORT = "8080";

    //用户登录
    public static final String ONTOLOGY_GET_OWLS = "getOwls";

    public static String getOntologyServiceURL(String  service) {
        String serviceURL = String.format("http://%s:%s/%s", ONTOLOGY_IP, ONTOLOGY_PORT, service);
        return serviceURL;
    }

    /**
     * 流程执行引擎url
     */
    public static final String ACTIVITI_IP = "192.168.1.142";//142
    public static final String ACTIVITI_PORT = "8080";

    //用户登录
    public static final String ACTIVITI_GET_BPMN= "getOwls";

    public static String getActivitiServiceURL(String  service) {
        String serviceURL = String.format("http://%s:%s/%s", ACTIVITI_IP, ACTIVITI_PORT, service);
        return serviceURL;
    }

    /**
     * 众包平台url
     */

}
