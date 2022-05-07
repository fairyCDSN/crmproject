package com.trkj.crmproject.util;

import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JSON返回结果工具类
 **/
@Slf4j
public class ResponseUtil {

    /**
     * 私有化构造器
     */
    private ResponseUtil(){}

    /**
     * 使用response向前端输出JSON
     **/
    public static void responseJson(HttpServletResponse response, HttpStatus status, String data)  {
            log.debug("status={},data={}",status.toString(),data);
            response.setContentType("application/json");
            response.setStatus(status.value());
            response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().print(data);

        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomError(CustomErrorType.SYSTEM_ERROR,"服务器内部异常");
        }
    }

}
