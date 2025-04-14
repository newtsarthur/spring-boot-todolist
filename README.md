Aqui está um modelo completo de **README.md** para seu projeto **Spring Boot TodoList**, com informações técnicas, como executar o projeto e badges personalizáveis:

```markdown
# 📝 Spring Boot TodoList Application

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

Aplicação de lista de tarefas (TODO) desenvolvida com Spring Boot para gerenciamento de atividades diárias.

## ✨ Funcionalidades

- ✅ Criar, editar e excluir tarefas
- ✅ Marcar tarefas como concluídas
- ✅ Filtragem por status (todas/ativas/concluídas)
- ✅ Persistência em banco de dados H2 (em memória)
- ✅ API RESTful documentada

## 🚀 Como Executar

### Pré-requisitos
- Java 21+
- Maven 3.6+
- (Opcional) Docker para versão containerizada

### Instalação Local
```bash
# Clone o repositório
git clone https://github.com/newtsarthur/spring-boot-todolist.git
cd spring-boot-todolist

# Compile e execute
mvn spring-boot:run
```

### Acessando a Aplicação
- **API**: `http://localhost:8080/api/tasks`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **Banco H2 Console**: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:todolist`)

## 🛠️ Tecnologias Utilizadas

| Tecnologia        | Finalidade                          |
|-------------------|-------------------------------------|
| Spring Boot       | Framework backend                   |
| Spring Data JPA   | Persistência de dados               |
| H2 Database       | Banco em memória para desenvolvimento|
| Swagger           | Documentação de API                 |
| Lombok            | Redução de boilerplate code         |

## 🌿 Estrutura do Projeto
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── todolist/
│   │               ├── controller/   # Endpoints API
│   │               ├── model/        # Entidades JPA
│   │               ├── repository/   # Interfaces Spring Data
│   │               └── service/      # Lógica de negócio
│   └── resources/
│       ├── application.properties    # Configurações
│       └── static/                   # Frontend (se aplicável)
```

## 🤝 Como Contribuir
1. Faça um fork do projeto
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📄 Licença
Este projeto está sob licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.