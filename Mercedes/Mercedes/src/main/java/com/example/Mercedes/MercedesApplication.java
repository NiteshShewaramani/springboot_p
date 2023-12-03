package com.example.Mercedes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class MercedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercedesApplication.class, args);
	}

	@RequestMapping(value = "/v1/getdata", method = RequestMethod.POST, consumes="application/json",produces = { "application/json" })
	public Map<String,String> calculateDiff(@RequestBody String request) throws JSONException {

		JSONObject reqObj = new JSONObject(request);
		int testCount = (int) reqObj.get("Total Test Cases");


		Map<String,String> jsonOutput = new HashMap<>();

		for(int i =1;i <= testCount;i++){
			long sum = 0;
			String testCase = ""+i;
			JSONObject data = reqObj.getJSONObject(testCase);
			sum = solve(data);
			jsonOutput.put(testCase, String.valueOf(sum));
		}
		return  jsonOutput;

	}

	@RequestMapping(value = "/v2/getdata/1", method = RequestMethod.POST,produces = { "application/json" })
	public ResponseEntity<String> calculateDiff1() throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();

		body.add("email", "shewaramani91@gmail.com");
		body.add("password", "nitesh");

		//for test case1

		final String case1 = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/testCase1e100177.json";
		String result1 = restTemplate.getForObject(case1, String.class);
		//compute here
		JSONObject reqObj1 = new JSONObject(result1);
		int testCount = (int) reqObj1.get("Total Test Cases");
		System.out.println("c is " + testCount);

		String answerStr1="{";

		for(int i =1;i <= testCount;i++){
			long sum = 0;
			String testCase = ""+i;
			JSONObject data = reqObj1.getJSONObject(testCase);
			sum = solve(data);
			answerStr1 = answerStr1 +   " \""  +testCase + "\" "  +  ":" +sum + ",";
		}
		answerStr1 = answerStr1.substring(0, answerStr1.length() - 1);
		answerStr1 = answerStr1 + "}";
		System.out.println("ans is " + answerStr1);

		body.add("testCase","3");
		body.add("answerStr",answerStr1);
		//will fire the api now
		//https://mercedes-hiring-2023.hackerearth.com/check
		HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);
		final String chechkUrl =  "https://mercedes-hiring-2023.hackerearth.com/check";


		ResponseEntity<String> response = restTemplate.exchange(chechkUrl,
				HttpMethod.POST, httpEntity, String.class);

		return response;





	}

	private long solve(JSONObject data) throws JSONException {
		long sum =0;
		int size = (int) data.get("N");
		if(size == 1)
			return sum;

		JSONArray jsonArray = data.getJSONArray("S");
		int [] arrayData = new int[size];
		for(int j=0;j<size;j++){
			arrayData[j] = jsonArray.getInt(j);
		}

		Arrays.sort(arrayData);

		if(size == 2)
			return arrayData[1] - arrayData[0];

		int minDiff=Integer.MAX_VALUE ;
		int first=0,second=0;
		for(int k = 1; k < size;k++){
			int diff = arrayData[k] - arrayData[k-1];
			if(diff <= minDiff)
			{
				first = k-1;
				second= k;
				minDiff = diff;
			}
		}

		long ans = func(first,second,arrayData);
		System.out.println( " with func" + ans );
		return ans;

	}

	public long func(int first,int second,int arr[])
	{
		if(first == 0 && second == arr.length-1)
			return arr[second] - arr[first];

		if(first == 0)
			return arr[second]-arr[first] + func(first,second+1,arr);
		if(second == arr.length-1)
			return arr[second]-arr[first] + func(first-1,second,arr);


		long sumi = arr[second]  - arr[first]  + func(first-1,second,arr);
		long sumj = arr[second]  - arr[first]  + func(first,second+1,arr);

		return Math.min(sumi,sumj);
	}




//
//		final String case4 = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/testCase4098e123.json";
//		String result4 = restTemplate.getForObject(case4, String.class);
//
//		final String case5 = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/testCase518a79ed.json";
//		String result5 = restTemplate.getForObject(case5, String.class);
//
//		final String case6 = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/testCase632a2a40.json";
//		String result6 = restTemplate.getForObject(case6, String.class);
//
//		final String case7 = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/testCase7256d7a2.json";
//		String result7 = restTemplate.getForObject(case7, String.class);
//
//		final String case8 = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/testCase83dbfe6d.json";
//		String result8 = restTemplate.getForObject(case8, String.class);
//
//		final String case9 = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/testCase948e834d.json";
//		String result9 = restTemplate.getForObject(case9, String.class);
//
//		final String case10 = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/testCase10528c6f1.json";
//		String result10 = restTemplate.getForObject(case10, String.class);


	//		//we will use greedy now
//		while(first >=0 && second<size)
//		{
//			sum = sum + (arrayData[second] -arrayData[first]) ;
//			//System.out.println(first + " index " + second  + " diff " + (arrayData[second] -arrayData[first]) );
//
//			int d1=Integer.MAX_VALUE;
//			int d2=Integer.MAX_VALUE;
//
//			if(first-1 >= 0 )
//			{
//				d1= arrayData[second] - arrayData[first-1];
//				//System.out.println("first diff " + d1);
//
//
//			}
//			if(second+1 < size)
//			{
//				d2 = arrayData[second + 1] - arrayData[first];
//				//System.out.println("second diff "+ d2);
//
//			}
//			if(d1<d2)
//				--first;
//			else
//				++second;
//		}
//		System.out.println( " with greedy " + sum );
//
//		return sum;

}
