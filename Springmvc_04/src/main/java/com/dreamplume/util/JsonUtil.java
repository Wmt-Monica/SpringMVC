package com.dreamplume.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @Classname JsonUtil
 * @Description TODO
 * @Date 2021/3/20 16:03
 * @Created by 翊
 * 创建一个方便获取 JSON 对象的辅助工具类
 */
public class JsonUtil {

    // 创建 ObjectMapper 对象
    static ObjectMapper mapper = new ObjectMapper();

    /**
     * 获取对应 根据 Date 对象依据 format 时间格式来输出对应的时间字符串
     * @param date Date 要获取的事件对象
     * @param format 对应输出时间字符串的格式要求字符串
     * @return 返回时间字符串
     */
    public static String getJSON(Object date, String format) {
        // 1.不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        // 2.使用 SimpleDataFormat 对象的对应的时间格式
        mapper.setDateFormat(dateFormat);
        String time = null;
        try {
            time =  mapper.writeValueAsString(date);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return time;
    }

    // 使用默认获取 JSON 的方法
    public static String getJSON(Object date) {
        return getJSON(date, "YYYY-MM-dd hh:mm:ss");
    }
}
