package com.yitianyigexiangfa.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerTest {

	public FreemarkerTest() {
	}

	public static void main(String[] args) {
		Configuration config = new Configuration();
		try {
			String path = new File("").getAbsolutePath();
			config.setDirectoryForTemplateLoading(new File(path));
			Template template = config.getTemplate("src/test.ftl", "UTF-8");
			// 创建数据模型
			Map root = new HashMap();
			List<User> users = new ArrayList<User>();
			User u1 = new User();
			u1.setId("123");
			u1.setName("王五");
			users.add(u1);
			User u2 = new User();
			u2.setId("423");
			u2.setName("李四");
			users.add(u2);
			User u3 = new User();
			u3.setId("333");
			u3.setName("张三");
			users.add(u3);
			root.put("userList", users);
			Map product = new HashMap();
			root.put("lastProduct", product);
			product.put("url", "www.baidu.com");
			product.put("name", "green hose");
			File file = new File(path + "\\src\\test.html");
			if(!file.exists()){  
                //System.out.println("file exist");  
                file.createNewFile();  
            }  
            Writer out = new BufferedWriter(new FileWriter(file));  
            template.process(root, out);  
            out.flush();  
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
