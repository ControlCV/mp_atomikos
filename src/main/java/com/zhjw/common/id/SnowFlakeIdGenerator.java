package com.zhjw.common.id;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * 分布式snowflake Id生成器
 *
 * @author scotthu
 */
@Component("idGenerator")
public class SnowFlakeIdGenerator implements IdGenerator {

    private Sequence sequence;

    private static IdGenerator idGenerator;

    @PostConstruct
    public void init() {
        Long workerId = 0L;

        Long dataCenterId = workerId / 32;
        Long realWorkerId = workerId % 32;
        sequence = new Sequence(realWorkerId, dataCenterId);
    }

    /**
     * 实例化，单例模式
     * @return 返回单例
     */
    public static IdGenerator newInstance() {
        if(idGenerator == null) {
            synchronized (SnowFlakeIdGenerator.class) {
                if(idGenerator == null) {
                    idGenerator = new SnowFlakeIdGenerator();
                }
            }
        }
        return idGenerator;
    }

    @Override
    public Long generate() {
        return sequence.nextId();
    }

    @Override
    public String generateStr() {
        if (this.sequence == null) {
            this.init();
        }
        return String.valueOf(sequence.nextId());
    }

}
