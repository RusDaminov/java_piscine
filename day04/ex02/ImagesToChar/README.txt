mkdir target
mkdir lib

curl -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
curl -o lib/JCDP-4.0.2.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar

javac  -classpath lib/JCDP-4.0.2.jar:lib/jcommander-1.82.jar -d target src/java/edu/school21/printer/*/*.java
cd target
jar xf ../lib/jcommander-1.82.jar
jar xf ../lib/JCDP-4.0.2.jar
cd ..
cp -R src/recources target/.

jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN