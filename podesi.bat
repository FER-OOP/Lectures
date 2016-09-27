@echo "Podesavamo staze:"
@SET "JAVA_HOME=C:\Program Files\Java\jdk1.8.0_101"
@SET "PATH=%PATH%;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin"
@echo "JAVA_HOME je postavljen na %JAVA_HOME%"
@echo "PATH je postavljen na %PATH%"
@echo "Verzija javinog virtualnog stroja je:"
@java -version
@echo "Verzija javinog prevodioca je:"
@javac -version

