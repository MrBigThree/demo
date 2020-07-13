package util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/18
 */
public abstract class TimeServerUtil {

    public static String getCurrentTime(byte[] req) throws UnsupportedEncodingException {
        String reqBody = new String(req, "UTF-8");
        return "QUERY TIME ORDER".equalsIgnoreCase(reqBody) ? new Date().toString() : "BAD ORDER";
    }
}
