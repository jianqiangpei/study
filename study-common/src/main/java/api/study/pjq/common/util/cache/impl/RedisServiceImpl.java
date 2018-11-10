package api.study.pjq.common.util.cache.impl;

import api.study.pjq.common.util.cache.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {


    private final RedisTemplate<String , Object> redisTemplate;

    public RedisServiceImpl(RedisTemplate<String , Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }


    public void putString(String key , String value){
        this.putString(key , value , DEFAULT_TIMEOUT);
    }

    @Override
    public void putString(String key , String value , Long timeout){
        redisTemplate.opsForValue().set(key , value , timeout , DEFAULT_TIME_UNIT);
    }


    public String getAndSetString(String key , String value){

        return redisTemplate.opsForValue().getAndSet(key , value).toString();
    }











}
