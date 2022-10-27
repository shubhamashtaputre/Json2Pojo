package com.json2pojo.code;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Json2PojoConvertApplication {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(Json2PojoConvertApplication.class, args);
		
		String packageName="com.json2pojo.code";  
        File inputJson= new File("E:/json/input.json");  
        File outputPojoDirectory=new File("E:/json");  
        outputPojoDirectory.mkdirs();  
        try {  
             new Json2Pojo().convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, packageName, inputJson.getName().replace(".json", ""));  
        } catch (IOException e) {  
             // TODO Auto-generated catch block  
             System.out.println("Encountered issue while converting to pojo: "+e.getMessage());  
             e.printStackTrace();  
        }  

	}

}
