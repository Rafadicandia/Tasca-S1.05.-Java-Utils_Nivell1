
## Objective: Directory Tree Serialization and Verification

This project implements the functionality for Exercise 5: mapping a directory structure, **serializing** the resulting object tree to a binary file, and then **deserializing** it for integrity verification.

The program cycle includes the stages of **Construction**, **Serialization** (to `directoryTree.ser`), and **Deserialization/Verification**.

---

## INSTRUCTIONS FOR COMMAND LINE EXECUTION (Using Maven)

To compile and execute this application, ensure you are in the project's root directory (where the `pom.xml` file is located) and that the `mvn` command is properly configured in your system's PATH.

### STEP 1: Clean and Compile

Use the following command to clean up previous artifacts and compile the source code.

```bash
mvn clean compile
````

### STEP 2: Program Execution (Serialization and Deserialization)

To run the `Main` class directly from the compiled code, use the `exec:java` plugin, passing the directory path as the single argument.

**Output Format:** Success messages for serialization/deserialization.

**Command:**

```bash
mvn exec:java -Dexec.mainClass=Main -Dexec.args="<directory_path>"
```

*Example (Serializing and Deserializing a test directory):*

```bash
mvn exec:java -Dexec.mainClass=Main -Dexec.args="src/main/resources"
```

-----

### PROPER USAGE

The program requires **exactly one argument** (the directory path).

```
Usage: java Main <directory_path>
```

```
```