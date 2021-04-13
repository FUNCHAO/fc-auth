package fc.test1.oauth2.core.mode.enums;

import lombok.Getter;

@Getter
public enum LoginTypeEnum {
    /**
     * json数据返回
     */
    JSON,
    /**
     * 重定向
     */
    REDIRECT;

}
