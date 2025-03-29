# WebServer
# TCP Server and client for Web Connection

This Java application creates a simple TCP server that listens for client connections on port `5000`. The server accepts incoming connections and spawns a new thread for each client that connects. It utilizes `ServerSocket` and `Socket` classes to establish connections, and `DataInputStream` and `DataOutputStream` for communication with the client.
This project consists of a simple **TCP client** and **server** communication system. The **server** listens on a given port (`5000`), and the **client** connects to the server, sends data, and continuously reads from the server.


## Features

- **TCP Server**: Listens on port 5000 for incoming client connections.
- **Client**: A client that connects to the server, sends a message, and then waits for a response.
- **Multithreading (Server Side)**: The server can handle multiple client connections simultaneously by spawning a new thread for each client.
- **Buffered Streams**: Uses `BufferedInputStream` and `BufferedOutputStream` for efficient data reading and writing.

## Prerequisites

- Java 8 or higher installed.
- Basic knowledge of TCP networking and Java threading.

## Getting Started

### 1. Clone or Download the Repository

If you haven't already, clone or download the repository where this code resides.

```bash
git clone git@github.com:rahulbhagatrb/WebServer.git
