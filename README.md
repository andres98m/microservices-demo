# Microservices Demo with Docker

This project demonstrates a simple microservices architecture using **Java, Spring Boot, and Docker**.
It includes two services — **Product Service and Order Service** — communicating with each other and persisting data into a **MongoDB container**.
The project showcases how to build, run, and connect microservices using lightweight, real-world practices.

> [!NOTE]
>  Note: This is a small-scale project intended as an introductory workshop for university students or anyone interested in learning the basic concepts of microservices architecture. It focuses on providing a clear and practical overview, not on production-level complexity.

### Key highlights:

- Spring Boot microservices

- Dockerized environment

- MongoDB integration

- RESTful APIs for communication

- Clean and scalable architecture


## How to Run Locally?

- Clone the project

```bash
  git clone https://github.com/andres98m/microservices-demo.git
```

- In the terminal, go to each backend projects' (product-service and order-service) folder and build the snapshot

```bash
  ./gradlew clean build
```


- Download Docker Desktop or OrbStack (for Mac)

```bash
  https://www.docker.com/products/docker-desktop/
  https://orbstack.dev/download
```

- Open Docker Desktop or OrbStack

- In the terminal, go to the project directory

```bash
  cd microservices-demo
```

- Run docker compose
```bash
  docker-compose up --build
```

### Notes

Each time you want to update something in the backend services, you will need to create a new clean snapshot and re-run the docker command

- In each backend service
```bash
  ./gradlew clean build
```
- In the root folder of the microservices-demo
```bash
  docker-compose up --build
```
