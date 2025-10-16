

## Objective: Recursive Directory Tree Lister with Metadata

This project implements the required functionality for Exercise 2: recursively listing the contents of a directory tree. The output displays the structure with **alphabetical sorting** per level, **indentation** reflecting the depth, the **resource type** ([D] for Directory / [F] for File), and the **last modification date**.

The main execution is handled via the command line using Maven.

---

## INSTRUCTIONS FOR COMMAND LINE EXECUTION (Using Maven)

To compile and run this program, ensure you are in the project's root directory (where the `pom.xml` file is located) and that the `mvn` command is properly configured in your system's PATH.

### STEP 1: Compilation

Use the following command to clean and compile the source code:

```bash
mvn clean compile
````

### STEP 2: Execution (Exercise 2)

The program executes the recursive listing logic by passing the target directory path as the sole argument.

**Output Format:** Indented structure, showing `[Type] Name (Date)`.

**Command:**

```bash
mvn exec:java -Dexec.mainClass="PrintDirectoryTree" -Dexec.args="<directory_path>"
```

*Example (Listing the recursive tree of the content in resources):*

```bash
mvn exec:java -Dexec.mainClass="PrintDirectoryTree" -Dexec.args="src/main/resources"
```

-----

### PROPER USAGE

The program requires **exactly one argument** (the directory path). If the argument is missing, an error message detailing usage is displayed.

```
Usage: java PrintDirectoryTree <directory_path>
```

```