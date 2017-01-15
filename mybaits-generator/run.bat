rd .\src /S /Q
mkdir .\src\main\java
mkdir .\src\main\resources
java -jar .\mybatis-generator-core-1.3.1.jar -configfile .\generatorConfig.xml -overwrite
pause