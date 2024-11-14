package com.lzy.neocache.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lzy.neocache.utils.grpc.ArrayString;
import com.lzy.neocache.utils.grpc.Data;
import com.lzy.neocache.service.BasicHashService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DistributedCacheController {
    @Autowired
    private BasicHashService BaseHashService;

    /**
     * Get请求：通过key获取value
     *
     * @param key
     * @return 返回目标值
     */
    @GetMapping("/{key}")
    @ResponseBody
    public ResponseEntity<?> getValueByKey(@PathVariable String key) {
        Object element = BaseHashService.getValue(key);
        if (element == null) {
            return new ResponseEntity<>("404, not found\n", HttpStatus.NOT_FOUND);
        }
        return formatResponse(element, key);
    }

    /**
     * 对cur主机和outer主机返回值解析并格式化
     *
     * @param element 获取的返回值
     * @param key     请求的key
     * @return 格式化后的kv对
     */
    private ResponseEntity<?> formatResponse(Object element, String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonData = objectMapper.createObjectNode();
        ResponseEntity<?> fomatjsonData = formatOuterResponse(element, key, objectMapper, jsonData);
        if (fomatjsonData != null) return fomatjsonData;
        return fomatCurResponse(element, key, objectMapper, jsonData);
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    private static ResponseEntity<?> fomatCurResponse(Object element, String key, ObjectMapper objectMapper, JsonNode jsonData) {
        if (element instanceof ArrayList<?>) {
            ArrayNode dynamicData = objectMapper.createArrayNode();
            for (String s : (ArrayList<String>) element) {
                dynamicData.add(s);
            }
            ((ObjectNode) jsonData).put(key, dynamicData);
            return new ResponseEntity<>(jsonData.toString()+"\n", HttpStatus.OK);
        } else {

            ((ObjectNode) jsonData).put(key, (String) element);
            return new ResponseEntity<>(jsonData.toString()+"\n", HttpStatus.OK);
        }
    }

    @SuppressWarnings("deprecation")
	private static ResponseEntity<?> formatOuterResponse(Object element, String key, ObjectMapper objectMapper, JsonNode jsonData) {
        if (element instanceof Data) {
            Data newElement = (Data) element;
            if (newElement.hasArrayString()) {
                ArrayString arrayString = newElement.getArrayString();
                List<String> list = arrayString.getStringArrayList().stream().toList();
                ArrayNode dynamicData = objectMapper.createArrayNode();
                for (String s : list) {
                    dynamicData.add(s);
                }
                ((ObjectNode) jsonData).put(key, dynamicData);
                return new ResponseEntity<>(jsonData.toString() + "\n", HttpStatus.OK);
            } else {
                ((ObjectNode) jsonData).put(key, newElement.getString());
                return new ResponseEntity<>(jsonData.toString() + "\n", HttpStatus.OK);
            }
        }
        return null;
    }

    /**
     * POST请求：添加或覆盖kv
     *
     * @param requestBody 接收body
     */
    @PostMapping("/")
    public void update(@RequestBody Map<String, Object> requestBody) {
        BaseHashService.addOrUpdate(requestBody);
    }

    /**
     * DELETE请求：删除kv
     *
     * @param key
     * @return 1成功，0失败；但是都会返回200
     */
    @DeleteMapping("/{key}")
    public ResponseEntity<String> deleteItem(@PathVariable String key) {
        if (BaseHashService.delete(key)) {
            return new ResponseEntity<>("1\n", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("0\n", HttpStatus.OK);
        }
    }
}
