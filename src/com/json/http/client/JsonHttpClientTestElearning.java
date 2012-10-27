package com.json.http.client;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;



public class JsonHttpClientTestElearning
{

	public static void main(String[] args) {
		try {
			write();
			list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 대화 목록
	public static void list() throws Exception {
		
		String result = JsonHttpClient.sendHttpGet("http://applab.mireene.com/bbs.do?action=list&num=0");
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	
	public static void write() throws Exception {
		String result = JsonHttpClient.sendHttpGet("http://applab.mireene.com/bbs.do?action=write&writer=고양이&message=야옹야옹야옹야옹...~!");
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	public static void delete() throws Exception {
		String result = JsonHttpClient.sendHttpGet("http://applab.mireene.com/bbs.do?action=delete");
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	public static void elist() throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "list");
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(jsonObject.toString());
		System.out.println("---------------------------------------------------------------------");
		
		String result = JsonHttpClient.sendHttpPost("http://58.102.122.183:8080/elearning/elearning.do", jsonObject);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	public static void insert() throws Exception {
		long time = System.currentTimeMillis();
		String key = new Long(time).toString();
		
		String content = "{'title' : '체험 삶의 현장.', 'content' : '비가 많이 오고, 바람이 많이 분다. \n 감기가 걸렸다.', 'writer' : '초코칩'}";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "insert");
		map.put("key", key);
		map.put("content", content);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(jsonObject.toString());
		System.out.println("---------------------------------------------------------------------");
		
		String result = JsonHttpClient.sendHttpPost("http://58.102.122.183:8080/elearning/elearning.do", jsonObject);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	public static void update() throws Exception {
		
		String content = "{'title' : '체험 삶의 현장2222333.', 'content' : '비가 많이 오고, 바람이 많이 분다.22333 \n 감기가 걸렸다22.', 'writer' : '초코칩2333332'}";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "update");
		map.put("key", "1350881865976");
		map.put("content", content);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(jsonObject.toString());
		System.out.println("---------------------------------------------------------------------");
		
		String result = JsonHttpClient.sendHttpPost("http://58.102.122.183:8080/elearning/elearning.do", jsonObject);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	public static void remove() throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "remove");
		map.put("key", "1350881357668");
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(jsonObject.toString());
		System.out.println("---------------------------------------------------------------------");
		
		String result = JsonHttpClient.sendHttpPost("http://58.102.122.183:8080/elearning/elearning.do", jsonObject);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	public static void user_list() throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "user_list");
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(jsonObject.toString());
		System.out.println("---------------------------------------------------------------------");
		
		String result = JsonHttpClient.sendHttpPost("http://58.102.122.183:8080/elearning/elearning.do", jsonObject);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	public static void user_insert() throws Exception {
		long time = System.currentTimeMillis();
		String key = new Long(time).toString();
		
		String content = "{'name' : '도창욱', 'age' : 34, 'level' : '팀장'}";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "user_insert");
		map.put("key", key);
		map.put("content", content);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(jsonObject.toString());
		System.out.println("---------------------------------------------------------------------");
		
		String result = JsonHttpClient.sendHttpPost("http://58.102.122.183:8080/elearning/elearning.do", jsonObject);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
	
	public static void user_update() throws Exception {
		
		String content = "{'name' : '도창욱2', 'age' : 34, 'level' : '팀장'}";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmd", "user_update");
		map.put("key", "1350896182325");
		map.put("content", content);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(jsonObject.toString());
		System.out.println("---------------------------------------------------------------------");
		
		String result = JsonHttpClient.sendHttpPost("http://58.102.122.183:8080/elearning/elearning.do", jsonObject);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(result);
		System.out.println("---------------------------------------------------------------------");
	}
}