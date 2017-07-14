# SpringMicroservices

# 1.- Begin REST
	The @SpringBootApplication annotation is a top-level annotation that encapsulates
	three other annotations, as shown in the following code snippet:

	- @Configuration
	- @EnableAutoConfiguration
	- @ComponentScan


	$mvn install -> will generate a jar file under the target folder.

	$java -jar target/bootrest-0.0.1-SNAPSHOT.jar -> could be run as a stadalone application.


# HATEOAS.- Begin REST
	HATEOAS is a REST service pattern in which navigation links are provided as part
	of the payload metadata. The client application determines the state and follows the
	transition URLs provided as part of the state. This methodology is particularly useful
	in responsive mobile and web applications in which the client downloads additional
	data based on user navigation patterns.


#Custom properties