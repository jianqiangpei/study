package api.study.pjq.common.util.cache;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

@Validated
public interface RedisService {


    /**
     * 默认超时时间
     */
    Long DEFAULT_TIMEOUT = 24*60*60*1000L;

    /**
     * 默认超时计算单位
     */
    TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MILLISECONDS;

    /**
     * redis set字符串
     * @param key key
     * @param value 字符串值
     */
    void putString(@NotNull(message = "param key can not is null") String key , String value);

    /**
     * redis set字符串
     * @param key key
     * @param value 字符串值
     * @param timeout 超时时间（毫秒）
     */

    void putString(@NotNull(message = "param key can not is null") String key , String value , Long timeout);

    /**
     * 获取原来的key的值并将新的值替换原值
     * 若不存在则添加
     * @param key 字符串
     * @param value 值
     */
    String getAndSetString(@NotNull(message = "param key can not is null") String key , String value);

}
