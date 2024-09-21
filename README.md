# Login Application - Angular & Spring Boot

## 📄 **Descripción del Proyecto**

Este proyecto es una aplicación de **Login** construida con **Angular** en el frontend y **Spring Boot** en el backend. Permite a los usuarios registrarse, iniciar sesión y gestionar la autenticación.

- **Frontend**: [https://backendfinal-angular-latest.onrender.com](https://backendfinal-angular-latest.onrender.com/)
- **Backend**: [https://backendfinal-angular-latest.onrender.com](https://backendfinal-angular-latest.onrender.com/)
- **Repositorios GitHub**:
    - [Backend](https://github.com/Marulanda921/LoginBack)
    - [Frontend](https://github.com/Marulanda921/LoginFront)

## 🛠 **Imágenes Docker**

- **Frontend**: `docker pull achner/backendfinal-angular:latest`
- **Backend**: `docker pull achner/backendfinal:latest`


## **Instrucciones para Ejecutar el Proyecto**

### 1. **Desde el Código Fuente**

### Backend (Spring Boot)

1. Clona el repositorio y navega al backend:
    
    ```bash
    git clone https://github.com/Marulanda921/LoginBack.git
    cd LoginBack
    
    ```
    
2. Configura la base de datos en `application.properties`:
    
    ```
    
    spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    
    ```
    
3. Ejecuta el backend:
    
    ```bash
    mvn clean install
    mvn spring-boot:run
    
    ```
    

### Frontend (Angular)

1. Clona el repositorio y navega al frontend:
    
    ```bash
    git clone https://github.com/Marulanda921/LoginFront.git
    cd LoginFront
    
    ```
    
2. Instala las dependencias:
    
    ```bash
    npm instal
    ```
    
3. Ejecuta el frontend:
    
    ```bash
    ng serv
    ```
    

---

### 2. **Ejecutar con Docker**

### Usar Imágenes de Docker

1. Descarga las imágenes:
    
    ```bash
    docker pull achner/backendfinal:latest
    docker pull achner/backendfinal-angular:latest
    ```
    
2. Ejecuta el backend:
    
    ```bash
    
    docker run -d -p 8080:8080 achner/backendfinal:latest
    
    ```
    
3. Ejecuta el frontend:
    
    ```bash
    docker run -d -p 4200:80 achner/backendfinal-angular:latest
    ```
    

---

### 3. **Usar Docker Compose**

1. Crea un archivo `docker-compose.yml` con el siguiente contenido:
    
    ```yaml
    yaml
    Copy code
    version: '3.8'
    
    services:
      backend:
        image: achner/backendfinal:latest
        ports:
          - "8080:8080"
      frontend:
        image: achner/backendfinal-angular:latest
        ports:
          - "4200:80"
    
    ```
    
2. Ejecuta con Docker Compose:
    
    ```bash
    docker-compose up -d
    ```
    

---

## 🌐 **Acceso a la Aplicación**

- **Frontend**: [http://localhost:4200](http://localhost:4200/)
- **Backend**: [http://localhost:8080](http://localhost:8080/)

---

## 📝 **Créditos**

Este proyecto fue desarrollado por [Alejandro Marulanda](https://github.com/Marulanda921).
