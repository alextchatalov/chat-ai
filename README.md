# Chat AI - Local AI Chat Application

A simple chat application that allows you to interact with a local AI model using a web interface. This project leverages Spring AI and Ollama to provide a seamless chat experience with your locally running AI models.

## Features

- Modern and visually appealing chat interface
- Support for file uploads (text and Excel files)
- Integration with local Ollama models
- Real-time chat with AI responses
- Responsive design
- Animated message bubbles and loading indicators
- Custom styling with icons and visual enhancements

## Technologies Used

- **Backend**:
  - Java 24
  - Spring Boot 3.4.5
  - Spring AI 1.0.0-M7
  - Apache POI 5.2.3 (for Excel file processing)

- **Frontend**:
  - HTML5
  - CSS3
  - JavaScript (Vanilla)

- **AI Integration**:
  - Ollama (Local AI model server)
  - Default model: llama3.1:8b

## Prerequisites

Before running this application, you need to have the following installed:

1. **Java 24** - [Download from Oracle](https://www.oracle.com/java/technologies/downloads/)
2. **Maven** - [Installation Guide](https://maven.apache.org/install.html)
3. **Ollama** - [Installation Guide](https://ollama.ai/download)

## Setup and Installation

### 1. Clone the repository

```bash
git clone <repository-url>
cd chat-ai
```

### 2. Install and run Ollama

Follow the instructions at [Ollama's download page](https://ollama.ai/download) to install Ollama for your operating system.

Once installed, pull the default model:

```bash
ollama pull llama3.1:8b
```

Make sure Ollama is running on port 11434 (default port).

### 3. Build and run the application

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## Usage

1. Open your browser and navigate to `http://localhost:8080`
2. Type your message in the input field and click "Send" or press Enter
3. Wait for the AI to respond
4. To upload a file:
   - Click "Choose File" and select a text or Excel file
   - Type a message related to the file (e.g., "Analyze this data")
   - Click "Send"
   - The AI will process both your message and the file content

## How It Works

The application consists of:

1. **Spring Boot Backend**:
   - Handles HTTP requests
   - Communicates with the Ollama API
   - Processes file uploads
   - Serves the web interface

2. **Web Interface**:
   - Provides a user-friendly chat interface
   - Handles file uploads
   - Displays AI responses

3. **Ollama Integration**:
   - Connects to your local Ollama instance
   - Sends prompts to the AI model
   - Receives and processes AI responses

## Configuration

You can modify the application's behavior by editing the `application.properties` file:

```properties
spring.application.name=chat-ai
spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.chat.model=llama3.1:8b
spring.ai.ollama.chat.options.temperature=0.4
spring.ai.ollama.init.pull-model-strategy=always
```

- Change the model by modifying `spring.ai.ollama.chat.model`
- Adjust the temperature (creativity) with `spring.ai.ollama.chat.options.temperature`
- Change the Ollama server URL with `spring.ai.ollama.base-url`
