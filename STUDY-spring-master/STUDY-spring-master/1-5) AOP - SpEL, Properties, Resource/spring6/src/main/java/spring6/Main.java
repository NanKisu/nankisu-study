package spring6;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.StreamUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ExpressionParser parser = new SpelExpressionParser();
//		Expression expression = parser.parseExpression("1 * 10 + 1");
//		System.out.println(expression.getValue(Integer.class));
//		System.out.println(expression.getValue(String.class));
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
//		TemporaryDirectory td = context.getBean("temporaryDirectory", TemporaryDirectory.class);
		
//		ExpressionParser parser = new SpelExpressionParser();
//		Expression expression = parser.parseExpression("0x1B");
//		System.out.println(expression.getValue(Integer.class));

//		ExpressionParser parser = new SpelExpressionParser();
//		Expression expression = parser.parseExpression("{'1', 2, '3'}");
//		System.out.println(expression.getValue(List.class));
//		System.out.println((expression.getValue(List.class)).get(0).getClass());
		
//		ExpressionParser parser = new SpelExpressionParser();
//		Expression expression = parser.parseExpression("'Hello World'.substring(0,5)");
//		System.out.println(expression.getValue(String.class));
//		System.out.println(System.getProperty("java.class.path"));
		
//		Resource resource = null;
//		try {
//			resource = new UrlResource("http://jsonplaceholder.typicode.com/posts/42");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try(				
//				InputStream in = resource.getInputStream()){
//			String result = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
//			System.out.println(result);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Resource resource = null;
//		try {
//			resource = new UrlResource("http://jsonplaceholder.typicode.com/posts/42");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try(				
//				InputStream in = resource.getInputStream()){
//			String result = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
//			System.out.println(result);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		AccessResource ar = context.getBean(AccessResource.class);
		ar.execute();
		AccessResource2 ar2 = context.getBean(AccessResource2.class);
		ar2.execute();
		System.out.println(System.getProperty("java.class.path"));
	}

}
