//package velocity;
//
//import java.io.StringWriter;
//
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//
///**
// * This class is a simple demonstration of how the Velocity Template Engine can
// * be used in a standalone application.
// */
//
//public class Example {
//
//	public static void main(String[] args) throws Exception {
//		/* first, get and initialize an engine */
//		VelocityEngine ve = new VelocityEngine();
//		ve.init();
//		/* next, get the Template */
//		Template t = ve.getTemplate("example.vm");
//		/* create a context and add data */
//		VelocityContext context = new VelocityContext();
//		context.put("name", "World");
//		/* now render the template into a StringWriter */
//		StringWriter writer = new StringWriter();
//		t.merge(context, writer);
//		/* show the World */
//		System.out.println(writer.toString());
//	}
//}
