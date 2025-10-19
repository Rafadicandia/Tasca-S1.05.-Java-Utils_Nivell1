
## Objective: Recursive Tree Listing and TXT File Content Reader

This project implements the combined functionality of the first three exercises: recursively listing the directory tree, including metadata, and **reading the content of all found `.txt` files** directly to the console.

The application performs the following actions:
1.  **Builds the Directory Tree:** Recursively traverses the file system.
2.  **Lists Metadata:** Prints the structure with indentation, type ([D]/[F]), name, and last modification date.
3.  **Reads TXT Files:** When an entry is a file ending in `.txt`, its entire content is printed to the console *before* its metadata is listed.

---

## INSTRUCTIONS FOR COMMAND LINE EXECUTION (Using Maven)

To compile and run this application, ensure you are in the project's root directory (where the `pom.xml` file is located).

### STEP 1: Clean and Compile

Use the following command to clean up previous artifacts and compile the source code.

```bash
mvn clean compile
````

### STEP 2: Program Execution (Listing and Reading TXT)

To run the `PrintDirectoryTree` class from the compiled code, use the `exec:java` plugin, passing the target directory path as the single argument.

**Output Format:** Mixed output—file contents are printed first, followed by the complete directory listing structure.

**Command:**

```bash
mvn exec:java -Dexec.mainClass="PrintDirectoryTree" -Dexec.args="<directory_path>"
```

*Example (Listing and reading TXT files in a test directory):*

```bash
mvn exec:java -Dexec.mainClass="PrintDirectoryTree" -Dexec.args="src/main/resources"
```

-----

### PROPER USAGE

The program requires **exactly one argument** (the target directory path).

```
Usage: java PrintDirectoryTree <directory_path>
```

```
```