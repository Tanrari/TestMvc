package ru.web.dto;

import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class UrlUtil {
    public static String encodeUrlPathSegment
            (String pathSegment, HttpServletRequest httpServletRequest){
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null){
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }

        pathSegment= UriUtils.encodePathSegment(pathSegment, enc);

        return pathSegment;
    }
}
