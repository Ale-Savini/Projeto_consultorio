# 🏥 Projeto Consultório

Sistema desktop desenvolvido em Java para auxiliar a gestão de um consultório médico. O sistema permite o cadastro e gerenciamento de pacientes, profissionais, agendamentos, salas e controle de estoque.

## 📁 Estrutura do Projeto

Projeto_Consultorio/ │ ├── src/ │ └── main/ │ └── java/ │ └── br/ │ └── com/ │ └── projetoconsultorio/ │ ├── controller/ │ ├── dao/ │ ├── model/ │ └── view/ │ ├── bin/ # Compilados (.class) ├── lib/ # Bibliotecas externas (se necessário) └── README.md # Este arquivo


## ⚙️ Funcionalidades

- Cadastro e listagem de **pacientes**
- Cadastro de **profissionais** com herança da classe Pessoa
- **Agendamento** de consultas e controle de **salas**
- **Controle de estoque** com movimentações de entrada e saída
- Estrutura orientada a objetos (POO), com uso de DAO e JDBC

## 📌 Tecnologias Utilizadas

- Java 11+
- JDBC para conexão com o banco de dados
- MySQL (recomendado)
- Visual Studio Code (como IDE)
- Git & GitHub para versionamento

## 🚀 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/Ale-Savini/Projeto_consultorio.git
cd Projeto_consultorio

2. Compile o projeto .java:
javac -d bin src/main/java/br/com/projetoconsultorio/model/*.java

3. Execute a classe Main:
java -cp bin br.com.projetoconsultorio.model.Main



