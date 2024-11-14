package com.lzy.neocache.service;

import java.util.Map;

public interface BasicHashService {
  /**
     * 获取返回值
     *
     * @param key
     * @return
     */
    Object getValue(String key);

    /**
     * 添加或覆盖kv
     *
     * @param hashMap
     */
    void addOrUpdate(Map<String, Object> hashMap);

    /**
     * 删除kv
     *
     * @param key
     * @return
     */
    boolean delete(String key);
}
