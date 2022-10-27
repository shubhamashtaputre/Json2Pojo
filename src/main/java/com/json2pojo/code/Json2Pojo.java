package com.json2pojo.code;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import com.sun.codemodel.*;

public class Json2Pojo {
	
	public void convert2JSON(URL inputJson, File outputPojoDirectory, String packageName, String className) throws IOException{  
        JCodeModel codeModel = new JCodeModel();  
        URL source = inputJson;  
        GenerationConfig config = new DefaultGenerationConfig() {  
        @Override  
        public boolean isGenerateBuilders() {
            return true;  
        }  
        public SourceType getSourceType(){  
    return SourceType.JSON;  
  }  
        };  
        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());  
        mapper.generate(codeModel, className, packageName, source);  
        codeModel.build(outputPojoDirectory);  
   }  
	
	
}
