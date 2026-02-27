# Java UDP Server/Client

## Overview
This repository is a lightweight Java UDP client/server proof of concept created to understand datagram networking and Wake-on-LAN communication patterns.

The project was intentionally kept small and dependency-free so the network behavior is easy to inspect, test, and extend.

## Project Goal
This code was built as a learning and validation step before implementing Wake-on-LAN behavior in Android applications.

It demonstrates:
- UDP socket setup and communication in Java
- Request/response behavior over datagrams
- Basic service-style server behavior that listens continuously on a fixed port

## Professional Context
This project was used to de-risk implementation decisions before mobile development work, specifically:
- validating low-level UDP behavior in a controlled Java environment
- confirming packet flow and response handling before Android integration
- creating a clear baseline reference for later product-facing Wake-on-LAN features

## Architecture
- `JavaUdpServer.java`: starts a UDP listener on port `4445`, receives packets, and responds with the current server timestamp
- `JavaUdpClient.java`: sends a UDP packet to `127.0.0.1:4445`, waits for a response, and prints the returned timestamp

## Run Locally
Compile:

```bash
javac JavaUdpServer.java
javac JavaUdpClient.java
```

Run in separate terminals:

```bash
java JavaUdpServer
```

```bash
java JavaUdpClient
```

Expected behavior:
- Server logs a request source, for example: `Request from: /127.0.0.1:<random_port>`
- Client prints Java runtime info, target endpoint, and a timestamp returned by the server

## Related Repositories
- Android UDP client prototype: https://github.com/adamsinnott/AndroidDatagramUdpClient
- Wake-on-LAN Android implementation: https://github.com/adamsinnott/WakeOnLAN

## Notes
- This repository is a focused learning project, not a production-ready service.
- The original inspiration came from Oracle UDP datagram examples and early community tutorials, then was adapted for Wake-on-LAN experimentation.
