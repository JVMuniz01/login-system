🚀 Sistema de Login e Gerenciamento de Usuários

Este projeto é dividido em dois repositórios:

Backend (Spring Boot)
 → API responsável pela autenticação e persistência de dados.

Frontend (Next.js)
 → Interface gráfica que consome a API.

📦 Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

Node.js LTS

npm
 ou yarn

Java 17+

Maven
 (se não estiver usando o wrapper ./mvnw)

PostgreSQL

Git

🔧 Como rodar o Backend

Clone o repositório do backend:

```bash
git clone https://github.com/JVMuniz01/login-system.git
cd login-system
```
Rodar a api:
```bash
mvn spring-boot:run
```

🎨 Como rodar o Frontend

Clone o repositório do frontend:
```bash
git clone https://github.com/JVMuniz01/login-system-front.git
cd login-system-front
```
Configuração

Crie um arquivo .env.local na raiz com a URL da API backend:
```bash
NEXT_PUBLIC_API_URL=http://localhost:8080
```

Rodar o front:
```bash
npm install
npm run dev
```

Front-end disponivel na porta http://localhost:3000
