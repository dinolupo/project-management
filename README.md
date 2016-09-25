# Liferay 6.2 JSF Portlet development

## Step 1 - Generate a plugin project with a service and a portlet subproject


```sh
mvn archetype:generate -DarchetypeArtifactId=liferay-servicebuilder-archetype -DarchetypeGroupId=com.liferay.maven.archetypes -DarchetypeVersion=6.2.5 -DgroupId=io.github.dinolupo -DartifactId=projman -Dversion=1.0 -DpackageName=io.github.dinolupo.projman -DinteractiveMode=false
```

Change the namespace of file service.xml

```xml
<namespace>PM</namespace>
```

Inside the `proj-management` directory run:

```sh
mvn liferay:build-service
```

**this command is necessary everytime you modify the services, for example adding a method or an exception** 


## Step 2 - Add the following dependencies into the pom.xml of the portlet project:

> pom.xml of the portlet project

```xml
		<!-- 		Liferay JSF Portlet dependencies -->	
		<dependency>
			<groupId>com.liferay.faces</groupId>
			<artifactId>liferay-faces-alloy</artifactId>
			<version>3.2.4-ga5</version>
		</dependency>
		<dependency>
			<groupId>com.liferay.faces</groupId>
			<artifactId>liferay-faces-bridge-impl</artifactId>
			<version>3.2.4-ga5</version>
		</dependency>
		<dependency>
			<groupId>com.liferay.faces</groupId>
			<artifactId>liferay-faces-portal</artifactId>
			<version>3.2.4-ga5</version>
		</dependency>
	
		<dependency>
			<groupId>com.sun.faces</groupId>
			<artifactId>jsf-api</artifactId>
			<version>2.1.21</version>
		</dependency>
		<dependency>
			<groupId>com.sun.faces</groupId>
			<artifactId>jsf-impl</artifactId>
			<version>2.1.21</version>
		</dependency>
		<dependency>
			<groupId>javax.el</groupId>
			<artifactId>el-api</artifactId>
			<version>1.0</version>
			<scope>provided</scope>
		</dependency>
		
 		<dependency>
			<groupId>org.jboss.seam</groupId>
			<artifactId>jboss-el</artifactId>
			<version>2.0.0.GA</version>
			<exclusions>
				<exclusion>
					<artifactId>el-api</artifactId>
					<groupId>javax.el</groupId>
				</exclusion>
			</exclusions>
		</dependency>
		
	<!-- end JSF Portlet -->
```


## Step 3 - change the web.xml to support the JSF portlet

> `web.xml` in the portlet subproject

```xml
<?xml version="1.0"?>

<web-app
	version="2.5"
	xmlns="http://java.sun.com/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
>
	<context-param>
		<param-name>com.sun.faces.expressionFactory</param-name>
		<param-value>org.jboss.el.ExpressionFactoryImpl</param-value>
	</context-param>
	<context-param>
		<param-name>javax.faces.PROJECT_STAGE</param-name>
		<param-value>Development</param-value>
	</context-param>
	<servlet>
		<servlet-name>Faces Servlet</servlet-name>
		<servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>
</web-app>
```

To update the eclipse project, use the following on the main Maven project:

right-click -> Maven -> Update Project (ALT-F5 on OSX) 


## Step 4 - 


## Handle LOCALIZATION in Liferay JSF portlet

[https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-2/localizing-jsf-portlets]()


## JSF with Liferay Portlet

Commands does not work unless you put the following line in `liferay-portlet.xml`:

`<requires-namespaced-parameters>false</requires-namespaced-parameters>`

Full snippet:

	<portlet>
		<portlet-name>proj-management</portlet-name>
		<icon>/icon.png</icon>
		<requires-namespaced-parameters>false</requires-namespaced-parameters>
		<header-portlet-css>/css/main.css</header-portlet-css>
		<footer-portlet-javascript>/js/main.js</footer-portlet-javascript>
	</portlet>

source: [http://stackoverflow.com/questions/30547743/commandbutton-action-method-not-invoked-in-liferay]()

     <aui:field id="entryEmailField" label="#{i18n['email']}">
        <h:message for="entryEmail" />
        <h:inputText id="entryEmail" required="true" validatorMessage="#{i18n['please-enter-a-valid-email-address']}"
            value="#{projectManagementBacking.selectedEntry.email}">
            <f:validateRegex pattern=".+[@].+[.].+" />
            <f:ajax render="entryEmailField" />
        </h:inputText>
    </aui:field>
 
