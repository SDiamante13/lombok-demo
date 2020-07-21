# lombok-demo

This application is to demonstrate how to use Project Lombok with MyEclipse and Maven.

Add the following to your pom.xml:

```
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<version>1.18.12</version>
		<scope>provided</scope>
	</dependency>
```

Next, download the [lombok jar](https://repo1.maven.org/maven2/org/projectlombok/lombok/1.18.12/) so that MyEclipse can install the plugin for you. 

Once you download the jar run the command: `java -jar lombok-1.18.12.jar`

It will not find MyEclipse automatically.

![alt text](src/main/resources/Installer1.png)

You must browse for the location. You want to find the MyEclipse.app file and right click on it and show Contents. Then navigate to Contents/Profile and find the eclipse.ini file.

<small>**Windows file structure may appear differently**</small>

![alt text](src/main/resources/Installer2.png)

While interacting with your model classes annotated with Lombok if you still see errors try restarting MyEclipse and then running 
`mvn clean install`

then execute Project > Clean ...

___
IntelliJ users can install the Lombok plugin by going to Preferences > Plugins and searching for lombok.


## Don't believe me?

After running `mvn clean install` run the following command to see the java bytecode:

`javap -c target/classes/tech/pathtoprogramming/lombokdemo/model/VideoGame.class`

## Using Delombok

An alternative to seeing the byte code is to use the delombok plugin. All models must be in a package called lombok for this to work. After running `mvn clean install` navigate to `target/generated-sources/delombok` and find your code after annotations have been coverted to boilerplate code.



