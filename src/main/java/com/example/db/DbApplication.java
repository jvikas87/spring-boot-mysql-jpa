package com.example.db;

import com.example.db.entity.KeyValue;
import com.example.db.repository.KeyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

}

@Controller
class MyController{

	@Autowired
	private KeyValueRepository keyValueRepository;

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	@ResponseBody
	public String sayHello(){
		return "Hello World";
	}


	@RequestMapping(value = "/dbhealth",method = RequestMethod.GET)
	@ResponseBody
	public KeyValue checkDb(@RequestParam("key")String key,@RequestParam("value")String value){
		KeyValue keyValue = new KeyValue();
		keyValue.setKey(key);
		keyValue.setValue(value);
		keyValueRepository.save(keyValue);
		return keyValue;
	}
}



