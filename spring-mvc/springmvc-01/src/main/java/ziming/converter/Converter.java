package ziming.converter;

import org.springframework.lang.Nullable;

public interface Converter<S, T> {//S:表示接受的类型，T：表示目标类型
    /**
     * 实现类型转换的方法
     */
    @Nullable
    T convert (S source);
}
