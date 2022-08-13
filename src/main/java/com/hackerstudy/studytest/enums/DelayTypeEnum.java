package com.hackerstudy.studytest.enums;

/**
 * @class: DelayTypeEnum
 * @description:
 * @author: HackerStudy
 * @date: 2022-08-13 15:30
 */
public enum DelayTypeEnum {
    order(1,"订单"),
    ;

    //学号
    private final int code;

    //名字
    private final String description;

    DelayTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 获取枚举对象
     * @param code
     * @return
     */
    public static DelayTypeEnum getEnumByCode(int code) {
        for (DelayTypeEnum enums : DelayTypeEnum.values()) {
            if (enums.getCode()==code) {
                return enums;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Enum{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
