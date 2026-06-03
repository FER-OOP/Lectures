@echo "Podesavamo staze:"
@SET "JAVA_HOME=C:\Java\jdk-21.0.10+7"
@SET "PATH=%PATH%;%JAVA_HOME%\bin"
@echo "JAVA_HOME je postavljen na %JAVA_HOME%"
@echo "PATH je postavljen na %PATH%"
@echo " "
@echo "Verzija javinog virtualnog stroja je:"
@java -version
@echo "Verzija javinog prevodioca je:"
@javac -version

