package main.java.com.taskcli.cli;

public class TaskApp {

  public static void main(String[] args) {
        System.out.println("Task CLI up! Args: " + String.join(" ", args));
    }


private void AddCommand() {

}

private void ListCommand() {

}

private void UpdateCommand() {

}

}


/*
tasktracker/
├─ pom.xml
├─ README.md
├─ .gitignore
├─ src/
│  ├─ main/
│  │  ├─ java/com/taskcli/
│  │  │  ├─ cli/                 # comandos e parsing (AddCommand, ListCommand, App.java)
│  │  │  ├─ config/              # leitura de propriedades, injeção simples
│  │  │  ├─ domain/              # enums e VOs (Status, Priority)
│  │  │  ├─ model/               # entidades (Task, User)
│  │  │  ├─ exceptions/          # exceções da app (TaskNotFoundException, etc.)
│  │  │  ├─ repository/          # *interfaces* (TaskRepository)
│  │  │  │  ├─ jdbc/             # *implementações JDBC* (TaskRepositoryJdbc)
│  │  │  ├─ persistence/         # **conexão à BD** (DataSource/ConnectionFactory, migrations)
│  │  │  ├─ service/             # regras de negócio (TaskService, UserService)
│  │  │  └─ util/                # helpers (DateUtils, TablePrinter)
│  │  └─ resources/
│  │     ├─
│  │     ├─ logback.xml          # logging
│  │     ├─ schema.sql           # criação de tabelas (se usares JDBC “na mão”)
│  │     └─ data.sql             # dados seed (opcional)
│  └─ test/
│     ├─ java/com/taskcli/…      # testes JUnit/Mockito
│     └─ resources/              # props de teste, dataset H2, etc.

 */