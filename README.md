# Spring AI

Projeto desenvolvido durante live com o grupo **Dev's do Futuro**. Confira o [canal no YouTube](https://www.youtube.com/@maddytec).

---

## Foco do Projeto

Desenvolver uma API que tenha acesso a uma I.A. específica e retorne os dados solicitados pelo usuário, mas com configurações e limitações pré-estabelecidas via código Java. Neste projeto, limitamos as respostas a perguntas relacionadas exclusivamente à **tecnologia**.

Durante a live, utilizamos a versão `llama3`, mas posteriormente foi alterada para a versão `llama3.2:3b` por ser mais leve e fornecer respostas mais rápidas, sem a necessidade de configurar o uso de GPU.

---

## O que foi utilizado?

- **Java 23** com [GraalVM](https://www.graalvm.org/downloads/)
- **Spring Initializr** para geração do projeto [Start Project](https://start.spring.io/)
    - Spring Web
    - Spring AI
    - Lombok

---

## Como inicializar o projeto?

### Pré-requisitos

1. **JDK** Java 23
2. **Maven**
3. **Docker**
4. Certifique-se de que as portas **8080** e **11434** estão livres.

---

### Passo a passo

#### 1. Baixe o projeto e instale as dependências do Spring Boot usando o IntelliJ IDEA.
#### 2. Execute o arquivo de script para baixar a imagem do Docker e instalar o modelo `llama`.

- **Se estiver utilizando Windows**:
```bash
cd docker
start.bat
```
- **Se estiver utilizando Linux or WSL2**:
```bash
cd docker
start.sh
```

### 3 - Start o projeto e utilize o Postman para fazer requisição POST
```
POST http://localhost:8080/api/v1/ai
```
Exemplo de Body (JSON)
```
{
    "question": "Qual a diferença entre bloqueio pessimista e bloquio otimista?"
}
```

