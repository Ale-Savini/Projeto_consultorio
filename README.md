# 🏥 Projeto Consultório

Este projeto é uma aplicação voltada para gerenciamento de sistemas de consultório médico, organizada seguindo boas práticas de Arquitetura de Software e Engenharia de Software.
O objetivo é demonstrar a separação de responsabilidades, modularidade e documentação completa, facilitando a manutenção, evolução e testes do sistema.

## 📁 Estrutura do Projeto

Projeto_Consultorio/
├── src/
│   └── main/
│       └── java/
│           └── br/
│               └── com/
│                   └── projetoconsultorio/
│                       ├── controller/
│                       ├── dao/
│                       ├── model/
│                       └── view/
├── bin/                         # Compilados (.class)
├── lib/                         # Bibliotecas externas (opcional)
├── docs/                        # Documentação do projeto
│   └── documento_teorico.md     # Documento único contendo todo o trabalho teórico
└── README.md                     # Este arquivo


## Conteúdo da Documentação (/docs)

documento_teorico.md → Relatório teórico do projeto, com fundamentação, análise e metodologia.
arquitetura.md → Decisões de arquitetura e diagramas de alto nível.
requisitos.md → Requisitos funcionais e não funcionais do sistema.
casos_de_uso.md → Casos de uso detalhados.
diagramas/ → Diagramas visuais do sistema, como UML, ER, BPMN.

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

⚙️ Observações

O código-fonte está em src/.

Toda a documentação acadêmica do projeto está no arquivo docs/documento_teorico.md.

A pasta bin/ contém arquivos compilados (podem ser ignorados no GitHub via .gitignore).

Bibliotecas externas podem ser adicionadas em lib/, se necessário.
Desenvolvido por:
Alunos:       Alexandre Savini                        RA:24000563
              Wanderberg de Andrade                   RA: 1012023100726
              Julio Cesar Azevedo Souza               RA: 24001773
              Gabriel Henrique Barbosa                RA:1012023200408
              Glauber Mariano Lellis Junior           RA: 1012023200186

