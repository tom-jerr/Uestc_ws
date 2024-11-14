package com.lzy.neocache.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 缓存结构，每个服务器一个
 *
 */
@Slf4j
@Component
public class Cache {
    // 缓存结构
    private HashMap<String, Object> cacheNode;
    private CountingBloomFilterImpl<String> countingBloomFilter;

    public Cache() {
        this.cacheNode = new HashMap<>();
        // TODO: 2024/11/3 暂时使用固定值
        this.countingBloomFilter = new CountingBloomFilterImpl<>(500, 0.01); 
    }


    /**
     * 添加元素到服务器的虚拟节点，以nodeNo为虚拟节点索引
     *
     * @param nodeNo 虚拟节点id
     * @param key    元素的key
     * @param values 元素的value
     * @return
     */
    public boolean addElement(String key, Object values) {
       
        cacheNode.put(key, values);
        countingBloomFilter.addElement(key); // 添加元素到布隆过滤器
        // log.info("add a new element :" + key + ":" + values.toString());
        // log.info("bloomFilter add a new element :" + key);
        return true;
    }

    /**
     * 删除元素
     *
     * @param nodeNo 虚拟节点id
     * @param key    元素的key
     * @return boolean 删除是否成功
     */
    public boolean removeElement(String key) {
        if (!cacheNode.containsKey(key)) {
            return false;
        }
        // log.info("delete a key :" + key);
        // log.info("bloomFilter delete a key :" + key);
        cacheNode.remove(key);
        countingBloomFilter.removeElement(key); // 从布隆过滤器中删除元素
        return true;
    }

    /**
     * 获取元素
     *
     * @param nodeNo 虚拟节点id
     * @param key    元素的key
     * @return object 元素的value
     */
    public Object getElement(String key) {
        if(!countingBloomFilter.mightContain(key)) {
            return null;
        }
        return cacheNode.containsKey(key) ? cacheNode.get(key) : null;
    }
}



