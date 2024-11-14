package com.lzy.neocache.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lzy.neocache.entity.Cache;
import com.lzy.neocache.proxy.BasicHashProxy;
import com.lzy.neocache.service.BasicHashService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicHashServiceImpl implements BasicHashService {
    
    @Value("${currentServer.name}")
    private String serverName;

    @Autowired
    private BasicHashProxy hashProxy;

    @Autowired
    private Cache cacheNodes;

    @Autowired
    private ClientRemoteServiceImpl remoteService;

    @Autowired
    private Environment env;

    private HashMap<String, String> uris = new HashMap<>();


    @PostConstruct
    private void init() {
        uris.put(env.getProperty("server1.name"), env.getProperty("consistentHash.server1.port"));
        uris.put(env.getProperty("server2.name"), env.getProperty("consistentHash.server2.port"));
        uris.put(env.getProperty("server3.name"), env.getProperty("consistentHash.server3.port"));
    }

    @Override
    public void addOrUpdate(Map<String, Object> hashMap) {
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            String nodeForKey = hashProxy.getNode(key); // 获取该kv应该被分配的位置

            Object o = hashMap.get(key);
            // log.info("server name :" + nodeForKey);
            if (nodeForKey.equals(serverName)) {
                cacheNodes.addElement(key, o);
            } else {
                addFromOtherServer(nodeForKey, key, o);
            }
        }
    }

    @Override
    public boolean delete(String key) {
        String nodeForKey = hashProxy.getNode(key); 
        // log.info("server name :" + nodeForKey);
        if(nodeForKey.equals(serverName)) {
            return cacheNodes.removeElement(key);
        } else {
            return deleteFromOtherServer(nodeForKey, key);
        }
    }

    @Override
    public Object getValue(String key) {
        String nodeForKey = hashProxy.getNode(key);
        // log.info("server name :" + nodeForKey);
        if(nodeForKey.equals(serverName)) {
            return cacheNodes.getElement(key);
        } else {
            return getFromOtherServer(nodeForKey,key);

        }
    }


    private Object getFromOtherServer(String serverName, String key) {
        return remoteService.doGetRemote(serverName, Integer.parseInt(uris.get(serverName)), key);
    }

    private boolean addFromOtherServer(String serverName, String key, Object o) {
        return remoteService.doAddRemote(serverName, Integer.parseInt(uris.get(serverName)), key, o);
    }

    private boolean deleteFromOtherServer(String serverName, String key) {
        return remoteService.doDeleteRemote(serverName, Integer.parseInt(uris.get(serverName)), key);
    }

  
}
