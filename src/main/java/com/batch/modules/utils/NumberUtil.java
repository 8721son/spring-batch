package com.batch.modules.utils;

import java.text.DecimalFormat;

public class NumberUtil {
    public static String dotNumberStrNormal(Long number) {
        return new DecimalFormat("###,###").format(number);
    }

    public static String dotIntegerStrNormal(Integer number) {

        return new DecimalFormat("###,###").format(number);

    }
}
