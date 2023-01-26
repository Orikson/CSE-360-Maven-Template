# CSE 360 Maven Template
Maven template for JavaFX setup for the CSE 360 class at Arizona State University.

Use this repository as a template for a starting point by following the directions below, or alternatively setup your own Maven project with JavaFX.

## Table of Contents
1. [Install JDK](#install-jdk)
2. [Install Maven](#install-maven)
3. [Setup Eclipse](#setup-eclipse)
   1. [Run project in Eclipse](#run-project-in-eclipse)
4. [Setup VS Code](#setup-vs-code)
   1. [Run project in VS Code](#run-project-in-vs-code)
5. [Using this template](#using-this-template)
6. [Java coding standards](#java-coding-standards)

## Install JDK
Modern JavaFX requires minimally JDK 11 (with long term support) or any subsequent development kit. It is recommended to use either JDK 17 or JDK 19. If you install a JDK, you do _not_ need to install a JRE; the JDK is everything JRE is and more.

1. Download a JDK for your system
   1. [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
   2. [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
   3. [JDK 19](https://www.oracle.com/java/technologies/downloads/#java19)
2. During installation, select "Add to `PATH`" and "Setup `JAVA_HOME` Environment Variable" or their equivalents
3. After installation, verify that the destination folder has been added to the `JAVA_HOME` environment variable, and that its respective `bin` folder is in the `JAVA_HOME` environment variable. If not, add the folder containing your JDK to either of those variables. 
   1. For Windows, this can be verified in a command prompt by executing `echo %JAVA_HOME%`. Similarly, execute `echo %PATH%`. If your installation location is displayed correctly, then your JDK has been successfully installed.
   2. For MacOS, this can be verified in a bash or zsh shell by executing `echo $JAVA_HOME`. If your installation location is displayed correctly, then your JDK has been successfully installed.
   3. For Linux, this can be verified in the terminal by executing `echo $JAVA_HOME`. If your installation location is displayed correctly, then your JDK has been successfully installed.
4. If your installation cannot be found, you can manually add the JDK folder to the `JAVA_HOME` environment variable
   1. For Windows, press your windows key and type "path" and select "Edit the system environment variables". Select "Environment variables" and under "System variables" add an entry for `JAVA_HOME` with a value of `path\to\JDK`, and edit the `Path` entry by appending `;path\to\JDK\bin`. Verify this result in a new terminal using step 3 after accepting changes. 
   2. For MacOS;
      1. If you have MacOS Catalina or newer (v10.15+), open a zsh shell and execute `echo export "JAVA_HOME=\$(/usr/path/to/JDK)" >> ~/.zshrc` and `echo export "PATH=$JAVA_HOME/bin:$PATH" >> ~/.zshrc`. Verify this result after restarting the shell using step 3. If this doesn't work, you might have to edit the `.zshrc` resource file manually (e.g. via vim). 
      2. If you have an older version than MacOS Catalina, open a bash shell and execute `echo export "JAVA_HOME=\$(/usr/path/to/JDK)" >> ~/.bash_profile` and `echo export "PATH=$JAVA_HOME/bin:$PATH" >> ~/.bash_profile`. Verify this result after restarting the shell using step 3 If this doesn't work, you might have to edit the `.bash_profile` profile file manually (e.g. via vim).
   3. For Linux, execute `vim /etc/profile` to modify the profile file of the system. Then add `export JAVA_HOME=/usr/path/to/JDK` and then `export PATH=$PATH:$JAVA_HOME/bin` to the file (press `i` to edit, `[ESC]` + `:wq` to write and quit). Logout and login, and then verify this result using step 3.

## Install Maven
It is recommended to have a JDK installation on your device (see above) prior to installation, although that is unnecessary.
1. [Download Maven](https://maven.apache.org/download.cgi) and extract the contents of the archive
2. Add the Apache Maven bin folder to the `PATH` environment variable. This can be verified in a command prompt by executing `mvn -v`. If Maven version information is displayed, then your Maven installation has been successfully installed.

Detailed instructions can be found [here](https://maven.apache.org/install.html)

## Setup Eclipse
Most Eclipse versions (since 2016) have built-in Maven support. If your version of Eclipse doesn't, it might be time to upgrade. If you really don't want to, install the Maven plugin via `Help` -> `Install New Software` and search for `M2Eclipse`, or via `Help` -> `Eclipse Marketplace` and search for `Maven`.

Creating a Maven project is easy! Create a new project by selecting `File` -> `New` -> `Java Project`. Give it a name, and select the execution environment you want to use. Then, right click the project and select `Configure` -> `Convert to Maven Project`. Eclipse should then generate a `pom.xml` file and other necessary components. 

To use JavaFX with this new Maven Project, you have to add a few dependencies. After the `<version> ... </version>` specification tag add the following JavaFX dependencies.
```xml
<dependencies>
  <dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>13</version>
	</dependency>
  <dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>13</version>
  </dependency>
</dependencies>
```

Within the `<plugins> ... </plugins>` specification tag add the following plugin.
```xml
<plugin>
  <groupId>org.openjfx</groupId>
  <artifactId>javafx-maven-plugin</artifactId>
  <version>0.0.6</version>
  <executions>
    <execution>
      <!-- Default configuration for running -->
      <!-- Usage: mvn clean javafx:run -->
      <id>default-cli</id>
      <configuration>
        <mainClass>main.Main</mainClass>
      </configuration>
    </execution>
  </executions>
</plugin>
```

Replace `main.Main` with the package path to the main JavaFX app class. You're now ready to code.

### Run project in Eclipse
Once you've set up your project, there's a few more steps required before you can run it.

1. Select `Run` -> `Run as` -> `Maven build...`, and input `clean javafx:run` as a build goal
2. Apply changes, and run the build
3. If Maven options are not displayed under the "Run as" dropdown menu, verify your Maven installation and corresponding `PATH` variable and then restart Eclipse
4. If errors occur when `clean javafx:run` is invoked, select under the "Run as" dropdown menu "Maven test" and then "Maven clean" and then retry step 2

Once you have made your custom build path, you can access it via the `Run as` dropdown menu. 

## Setup VS Code
By default, Visual Studio Code does not support Maven. However (as with all things VS Code), there are a set of extensions to handle that. 

1. Under the extensions tab, install the [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack), or from the provided link
2. In the bottom left in the explorer tab, there should be a new Maven dropdown menu. If not, under the extensions tab, verify that Maven for Java has also been installed. Restarting Visual Studio Code may also be necessary.

Once Maven is setup, press `[CTRL]` + `[SHIFT]` + `p` and search for `create java project` and select the corresponding option. From the drop down menu, select `JavaFX`. Enter a group id and artifact id and destination folder. VS Code should then generate a `pom.xml` file and other necessary components. It should also set up JavaFX for you! You're now ready to code. 

### Run project in VS Code
Once you've set up your project, running it is fairly simple

1. In the bottom left in the explorer tab, there should be a new Maven dropdown menu. If not, under the extensions tab, verify that Maven for Java has also been installed. Restarting Visual Studio Code may also be necessary
2. Under the Maven dropdown menu, select your project, then `Lifecycle` and run the `clean` process
3. Under the Maven dropdown menu, select your project, then `Plugins` -> `javafx` and run `javafx:run`
3. If the project does not run, follow relevant pop up information that VS Code provides to resolve the issue. You may have to scroll through terminal output to find errors

Alternatively, using the built in terminal, navigate to your project directory (where `pom.xml` resides) and invoke `mvn clean javafx:run`.

## Using this template
This template provides an example of what your JavaFX project might look like with a simple "Hello World!" scene. You can create a repository of your own using this repository as a template by selecting `Use This Template` on this repository's [GitHub page](https://github.com/Orikson/CSE-360-Maven-Template).

Try running it!

## Java coding standards
As is best practice for software development, try to keep the following considerations in mind as you code. 

1. Package names are always prefixed by an all-lowercase top-level domain name, such as `com`, `edu`, `gov`, etc. For purposes of this class, consider package names that begin with `edu.asu.cse360.projectname`
2. Classes and interfaces follow an upper camel case naming convention (e.g. "Main", "MainApp"). Methods and variables follow a lower camel case naming convention (e.g. "variable", "methodName")
3. Keep files tidy. Generally one class per file, and methods shouldn't be overbearingly complicated. If you bunched a sorting algorithm into 200 lines of code in one function, consider breaking it up into subfunctions that have well defined scope and have a singular intention. This can also help when working in a team (e.g. splitting one function into 3 separate smaller functions, and having 3 different people work on each function). 
