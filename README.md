
## 📄 Description - Exercise Statement

This project addresses the following functionalities:

### Exercise 1: Alphabetical Directory Listing

Create a class that **alphabetically lists the contents of a directory** received as a parameter.

### Exercise 2: Recursive Directory Tree Listing

Extend the previous class to **recursively list a directory tree** across all its levels. The output must be alphabetized within each level and indicate if the entry is a **Directory (D)** or a **File (F)**, along with its **last modification date**.

### Exercise 3: Saving Output to TXT File

Modify the previous exercise to **save the directory tree listing result to a TXT file** instead of displaying it on the console.

### Exercise 4: Reading and Displaying TXT Content

Add the functionality to **read any TXT file** and display its content in the console.

### Exercise 5: Object Serialization and Deserialization

The program must **serialize a Java Object** to a `.ser` file and subsequently **deserialize** it back into an object.

-----

## 💻 Used Technologies

| Technology | Version | Description |
| :--- | :--- | :--- |
| **Java** | 24 (OpenJDK) | Language and environment for development. |
| **Apache Maven** | 3.9.6 (or higher) | Build automation and project management tool. |

-----

## 📋 Requirements

- Operating System: Windows/macOS/Linux.

- **Java Development Kit (JDK):** Version **24.0.1** (or higher). Using an **OpenJDK** distribution is recommended.

- **Apache Maven:** Installed and configured in the system PATH.

- Integrated Development Environment (IDE): **IntelliJ IDEA** (recommended) or any other IDE with Maven support.

-----

## 🛠️ Installation

1.  **Clone the Repository:**

    ```bash
    git clone https://github.com/Rafadicandia/Tasca-S1.05.-Java-Utils_Nivell1.git
    ```

2.  **IDE Configuration:**

    Open the folder as a **Maven project** in your IDE. The IDE will process the `pom.xml` file.

3.  **Build the Project:**

    From the terminal in the project's root directory (where `pom.xml` is located), run the following command to clean and compile the source code:

    ```bash
    mvn clean compile
    ```

-----

## ▶️ Execution

### 🚀 Running Individual Exercises (Command Line - Maven)

Since each exercise likely has its own main class, you will use the `exec:java` plugin, specifying the main class and any necessary arguments (like the directory path). **Refer to the specific `README.txt` inside each exercise folder for exact class names and required arguments.**

**General Command Structure:**

```bash
mvn exec:java -Dexec.mainClass="<MainClassName>" -Dexec.args="<arg1> <arg2>..."
```

**Example (Running Exercise 1):**

Assuming the main class is `DirectoryLister` and it takes a path argument:

```bash
mvn exec:java -Dexec.mainClass="DirectoryLister" -Dexec.args="/path/to/directory"
```

### 💻 Execute from the IDE

- Open the main file for the specific exercise you wish to run.
- Right-click within the file and select "Run 'MainClassName'". *Note: You may need to configure run arguments within the IDE for exercises that require directory or file paths.*

-----

## 🤝 Contributions

Contributions are welcome. Please report any bugs by opening an issue or suggest improvements via a clear and concise Pull Request.