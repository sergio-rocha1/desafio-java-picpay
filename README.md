# Desafio Back-end Java Spring
<img src="images/picpay-logo.svg" alt="PicPay Logo" width="200"/>

**Descrição:**  
> ***📱💼 Este é um projeto de desafio do PicPay que simula uma aplicação de carteira digital. O projeto permite criar carteiras de clientes, realizar transferências entre essas carteiras e interagir com serviços externos para autorização e notificação.***

**Versão:** 1.0.0

---

## Tecnologias Utilizadas 🚀

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento da API.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Spring Validation**: Para validação de dados de entrada da aplicação.
- **MySQL**: Banco de dados relacional.
- **Docker**: Para containerização do banco de dados.
- **Dotenv**: Para gerenciamento de variáveis de ambiente.
- **Feign**: Para comunicação com serviços externos.
- **Lombok**: Para reduzir o código boilerplate.

---

## Principais Funcionalidades/Regras de Negócio 🛠️

- **Criação de Carteira**: Permite criar novas carteiras para usuários e empresas com validação de dados únicos.
- **Transferências**: Realiza transferências de valores entre carteiras com validação de saldo e autorização.
- **Serviços Externos**: Integra com serviços externos para autorização e notificação de transferências. (Utilizando Mock)

---

## Endpoints 📡

### 1. Criar Carteira
- **Método:** `POST`
- **URL:** `/wallets`
- **RequestBody:**
  ```json
  {
    "fullName": "Nome Completo",
    "cpfCnpj": "12345678901",
    "email": "exemplo@dominio.com",
    "password": "senha",
    "walletType": "USER"
  }
  ```
- **Descrição**: Cria uma nova carteira com as informações fornecidas.

### 2. Realizar Transferência
- **Método:** `POST`
- **URL:** `/transfer`
- **RequestBody:**
  ```json
  {
    "value": 100.00,
    "payer": 1,
    "payee": 2
  }
  ```
- **Descrição**: Realiza uma transferência de valor entre duas carteiras. Valida saldo, tipo de carteira e autorização.

---

## Collection do Insomnia 📥

Para facilitar o teste dos endpoints, você pode baixar e importar a coleção do Insomnia utilizada para este projeto. A coleção inclui exemplos de requisições para todos os endpoints descritos acima.

- [Baixar Collection do Insomnia](https://github.com/sergio-rocha1/desafio-java-picpay/blob/main/insomnia/Collection-Insomnia-Desafio-Picpay)

---

## Como Executar o Projeto ⚙️
1. Clonar o repositório:
```bash
    git clone https://github.com/sergio-rocha1/desafio-java-picpay.git
    cd desafio-picpay
```
2. Executar o Docker Compose:
```cmd
    cd .\docker\
    docker-compose up
```
3. Executar a Aplicação:
```cmd
    ./mvnw spring-boot:run
```

---

## Próximos Passos 🚀
- Validação de Dados Adicionais: Adicionar mais validações para os dados de entrada e saída.
- Autenticação e Autorização: Implementar um sistema de autenticação para garantir a segurança das operações.
- Testes Automatizados: Escrever testes unitários e de integração mais robustos.
- Documentação Swagger: Adicionar documentação interativa para a API usando Swagger.
- Monitoramento e Logs: Implementar monitoramento e logging detalhado para melhor gestão e rastreamento da aplicação.

---

## Referências e Créditos 📝
- **Vídeo base para execução do Desafio:** [Assista aqui](https://youtu.be/dttXo48oXt4?si=62j6uJv7MnlCG-4h)
- **PicPay:** Logo e branding utilizados no desafio.

Se você tiver sugestões de melhoria ou quiser contribuir com o projeto, fique à vontade para abrir uma issue ou um pull request. Agradecemos sua contribuição!

**Agradeço por conferir o projeto!** 🚀
