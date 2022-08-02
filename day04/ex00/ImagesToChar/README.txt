# Creating path to store Java classes
mkdir target

# Compile java files and put them to directory
javac -d target src/java/edu/school21/printer/*/*.java

# Run program from specify folder
java -classpath target edu.school21.printer.app.Program . 0 /Users/abernita/Desktop/it.bmp