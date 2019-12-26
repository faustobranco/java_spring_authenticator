
# Java Spring Boot Web Server with DB Authentication

[![Github All Releases](https://img.shields.io/github/downloads/faustobranco/java_WatchLogFile/total.svg)]()

The idea here is to show a simple example of a JSP website using Spring Boot with authentication, but a bit more complete with persistence of information in databases, in this example PostgreSQL.

Some of the examples shown here that are persisted in database:
- Logins / passwords;
- Custom roles;
- Access permissions to pages according to roles;
- Redirection of pages according to the user's role;

## Getting Started
  

The project, done in Java 8 using IntelliJ 2019.3 and Maven, simply shows examples of using org.springframework.boot,  passwords encode ** for reference only **:

The database.txt file has all scripts for database creation, database user, schema, inserts of the data used in the example.

Passwords are encrypted by a Spring Boot BCryptPasswordEncoder method, shown in the example https://github.com/faustobranco/java_SpringPasswordEncoder.

The login information in the database is in a yaml file (config.yaml), read using the Jackson component and encrypted in AES.

Some information from the Java classes:

**AppConfig** Creates a datasource to use for database connections for authentication.

**WebAuthenticationSuccessHandler** - Used to successfully capture the authentication event and redirect the user to the page configured at tb_page_redirect_roles.

**WebSecurityConfig** - Used for loading user database information for authentication and page permissions by roles.

**LoginController** - RequestMapping of pages and loading information for the user class.

**AES** - Encryption and decryption of yaml file settings (config.yaml).

**LoadConfiguration** - Reading and loading src / main / resources / config.yaml file information for the appConfiguration class


There is also redirection to error pages like 404 (Page not found) and 403 (Access Forbidden)


## Database Model

![Image of Database Model](https://github.com/faustobranco/java_spring_authenticator/blob/master/readme_images/database_model.png)

## Web Pages

![Image of Web Pages](https://github.com/faustobranco/java_spring_authenticator/blob/master/readme_images/web_pages.png)


## Maven:

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
        
		<!-- JSTL tag lib -->
		<dependency>
			<groupId>javax.servlet.jsp.jstl</groupId>
			<artifactId>javax.servlet.jsp.jstl-api</artifactId>
			<version>1.2.1</version>
		</dependency>

		<dependency>
			<groupId>taglibs</groupId>
			<artifactId>standard</artifactId>
			<version>1.1.2</version>
		</dependency>

		<!-- Tomcat for JSP rendering -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.9</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-yaml</artifactId>
			<version>2.9.9</version>
		</dependency>
	</dependencies>
        <build>  
           <plugins> 
                <plugin> 
                    <groupId>org.apache.maven.plugins</groupId>  
                    <artifactId>maven-compiler-plugin</artifactId>  
                    <configuration> 
                        <source>1.8</source>  
                        <target>1.8</target>  
                    </configuration> 
                </plugin> 
            </plugins>
       </build>
       <packaging>war</packaging>



## Authors

-   **Fausto Branco** - _Initial work_ - [Git faustobranco](https://github.com/faustobranco)
