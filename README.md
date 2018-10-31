Develop
    Download the zip file into eclipse
	Right-click on the  project --> Configure --> Add Gradle Nature
	Right-click on the  project -->Graddle --> Refresh Gradle Project
    gradlew build 
	gradlew tasks
	gradlew bootJar
	
To run the app from the command line, run the following:
   java -jar build/libs/"iHeart Media-0.0.1-SNAPSHOT-boot.jar"

Test 
	gradlew test build
	gradlew test jacocoTestReport
	open this page from your browser file://YOUR_PROJECT_PATH/build/reports/tests/test/index.html
		Jacoco Test Report: file://YOUR_PROJECT_PATH/build/reports/jacoco/test/html/index.html