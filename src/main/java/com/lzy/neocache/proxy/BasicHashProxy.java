package com.lzy.neocache.proxy;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BasicHashProxy {

    @Autowired
    private Environment env;

    private HashMap<String, String> uris = new HashMap<>();

    private Vector<String> cacheNodes = new Vector<>();

    private HashMap<String, Integer> cacheKeyNum = new HashMap<>(); 

    private int totalKeyNum = 0;


    @PostConstruct
    public void init() {
        // 在对象实例化后执行的初始化操作
        uris.put(env.getProperty("server1.name"), env.getProperty("consistentHash.server1.port"));
        uris.put(env.getProperty("server2.name"), env.getProperty("consistentHash.server2.port"));
        uris.put(env.getProperty("server3.name"), env.getProperty("consistentHash.server3.port"));
        initCacheNodes(); 
    }

    public void initCacheNodes() {
        Set<String> serversName = uris.keySet();
        // System.out.println("serversName: " + serversName);
        for (String node : serversName) {
            cacheNodes.add(node);
            cacheKeyNum.put(node, 0);
        }
    }


    public String getNode(String key) {
        int hash = key.substring(4).hashCode();
        // System.out.println("hash: " + hash);
        int index = (hash + cacheNodes.size()) % cacheNodes.size();
        return cacheNodes.get(index);
    }

    public void addKey(String key) {
      int hash = key.hashCode();
      int index = (hash + cacheNodes.size()) % cacheNodes.size();
      cacheKeyNum.put(cacheNodes.get(index), cacheKeyNum.get(cacheNodes.get(index)) + 1);
    }

    public void removeKey(String key) {
      int hash = key.hashCode();
      int index = (hash + cacheNodes.size()) % cacheNodes.size();
      cacheKeyNum.put(cacheNodes.get(index), cacheKeyNum.get(cacheNodes.get(index)) - 1);
    }

    public void rebuildNodes() {
      int avgKeyNum = totalKeyNum / cacheNodes.size();
      for(String node: cacheNodes){
        if(cacheKeyNum.get(node) - avgKeyNum < 10) {
          continue;
        } else {
          int keyNum = cacheKeyNum.get(node);
          if (keyNum > avgKeyNum) {
            int diff = keyNum - avgKeyNum;
            for (int i = 0; i < diff; i++) {
              String key = "key" + i;
              int hash = key.hashCode();
              int index = (hash + cacheNodes.size()) % cacheNodes.size();
              if (cacheNodes.get(index).equals(node)) {
                cacheKeyNum.put(node, cacheKeyNum.get(node) - 1);
              }
            }
          }
        }
      }
    }
}
