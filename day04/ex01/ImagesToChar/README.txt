
javac -sourcepath ./src -d target src/java/edu/school21/printer/*/*.java

cp -R src/recources target/.
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .
chmod u+x target/images-to-chars-printer.jar
java -jar target/images-to-chars-printer.jar . 0