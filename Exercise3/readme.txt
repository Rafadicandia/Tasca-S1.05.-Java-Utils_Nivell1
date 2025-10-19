
## Objective: Recursive Directory Tree Lister (Output to File)

This project implements the required functionality for Exercise 3: recursively listing the contents of a directory tree, the entire structure is saved to a TXT file.**

The program performs the following actions:
1.  **Builds the Directory Tree:** Recursively traverses the file system.
2.  **Lists Metadata:** Creates the structure with indentation, type ([D]/[F]), name, and last modification date.
3.  **Saves Output:** The complete formatted listing is saved to a file named **`ListedDirectoryTree.txt`** in the execution directory.

---

## INSTRUCTIONS FOR COMMAND LINE EXECUTION (Using Maven)

To compile and run this application, ensure you are in the project's root directory (where the `pom.xml` file is located).

### STEP 1: Clean and Compile

Use the following command to clean up previous artifacts and compile the source code.

```bash
mvn clean compile
````

### STEP 2: Program Execution (Output to TXT File)

To run the `PrintDirectoryTree` class from the compiled code, use the `exec:java` plugin, passing the target directory path as the sole argument.

**Output Behavior:** The console output will only show brief confirmation messages. The main output is saved to the file.

**Command:**

```bash
mvn exec:java -Dexec.mainClass="PrintDirectoryTree" -Dexec.args="<directory_path>"
```

*Example (Generating the structure of a test directory and saving it to file):*

```bash
mvn exec:java -Dexec.mainClass="PrintDirectoryTree" -Dexec.args="src/main/resources"
```

-----

### PROPER USAGE & OUTPUT

1.  **Output File:** A file named **`ListedDirectoryTree.txt`** will be generated in the root directory, containing the indented structure.
2.  **Usage:** The program requires **exactly one argument** (the target directory path).


```
Usage: java Main <directory_path>
```

```
```