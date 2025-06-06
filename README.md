# NotificationDispatcher
A Aplicação de Notificação de Eventos de Pagamento é um componente crucial em nossa arquitetura, atuando como o elo final na comunicação do status de transações financeiras com nossos clientes.

## Features

- Listens to a Kafka topic (`Contact_Topic`) for incoming messages.
- Deserializes JSON messages into Java objects.
- Sends email notifications using the configured email server.

## Technologies Used

- **Java 17**
- **Spring Boot 3.5.0**
  - Spring Kafka
  - Spring Mail
  - Spring Web
- **Apache Kafka**
- **Jackson** for JSON deserialization
- **Lombok** for reducing boilerplate code
- **Maven** for dependency management

## Prerequisites

- Java 17 or higher
- Apache Kafka running locally or on a server
- SMTP server for sending emails
- Maven for building the project

## Setup and Configuration

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/NotificationDispatcher.git
   cd NotificationDispatcher
