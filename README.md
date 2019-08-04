# code-it

## Requirements

1. Maven 3.5 or higher
2. Java 1.8

The above must be installed and available in the classpath

## Execution steps

1. git clone https://github.com/nishant-/code-it.git
2. Go inside the project folder i.e code-it.
3. Run the following command
   * mvn install
4. After the above command completes, executable jar code-it-1.0-SNAPSHOT will be created in target folder.
5. config.properties file will also be copied to target folder. This file is required for configuring the values of price, shipping cost, number of items etc.
6. Navigate to "target" folder and run the below command
   * java -jar code-it-1.0-SNAPSHOT.jar
