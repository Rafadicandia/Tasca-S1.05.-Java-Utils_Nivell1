Exercise 1

## Objective: Directory Content Listing (Alphabetical Order)

This project implements the required functionality for Exercise 1: listing the contents of a specified directory and ensuring the output is sorted alphabetically.

The main execution is handled via the command line using Maven.

---

## INSTRUCTIONS FOR COMMAND LINE EXECUTION (Using Maven)

To compile and run this program, ensure you are in the project's root directory (where the `pom.xml` file is located) and that the `mvn` command is properly configured in your system's PATH.

### STEP 1: Compilation

Use the following command to clean and compile the source code:

```bash
mvn clean compile
````

### STEP 2: Execution (Exercise 1)

The program executes the core logic by passing the target directory path as the sole argument. The output will be a list of file and folder names sorted alphabetically.

**Command:**

```bash
mvn exec:java -Dexec.mainClass="DirectoryLister" -Dexec.args="<directory_path>"
```

*Example (Listing the contents of the current directory):*

```bash
mvn exec:java -Dexec.mainClass="DirectoryLister" -Dexec.args="."
```

-----

### PROPER USAGE

The program requires **exactly one argument** (the directory path). If not provided, a usage message is displayed:

```
Usage: java DirectoryLister <directory_path>
```

```
```