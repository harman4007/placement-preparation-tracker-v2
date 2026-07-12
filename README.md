
# Placement Preparation Tracker

A Spring Boot web application to track job applications and placement preparation progress.

## Tech Stack

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Thymeleaf**
- **Bootstrap 5**
- **Maven**

## Features

- Dashboard with statistics (total applications, status counts)
- Add new company applications
- Edit existing company applications
- Delete company applications
- Search companies by name or role
- Track application status (Applied, OA, Interview, Selected, Rejected)
- Add notes for each application
- Record interview dates

## Installation and Setup

### Prerequisites

- Java 25 or higher
- Maven 3.6+
- MySQL 8.0+

### Steps

1. **Clone the repository** (if applicable) or navigate to the project directory.

2. **Configure MySQL Database**
    - Create a database (or let the application create it automatically)
    - Update `src/main/resources/application.properties` with your MySQL credentials:
      ```properties
      spring.datasource.username=YOUR_USERNAME
      spring.datasource.password=YOUR_PASSWORD
      ```

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   Or run the main class `PlacementtrackerApplication` from your IDE.

5. **Access the application**
   Open your browser and navigate to `http://localhost:8080`

## Project Structure

```
src/main/java/com/harmandeep/placementtracker/
├── entity/          # JPA entities
├── repository/      # Spring Data JPA repositories
├── service/         # Business logic
├── controller/      # Web controllers
└── config/          # Configuration classes

src/main/resources/
├── templates/       # Thymeleaf templates
└── static/          # CSS, JS, images
```

## Usage

1. **Add a Company**: Click "Add New Company" to create a new application entry.
2. **Edit a Company**: Click "Edit" on any company entry to update details.
3. **Delete a Company**: Click "Delete" to remove an application (confirm when prompted).
4. **Search**: Use the search bar to find companies by name or role.
5. **Track Status**: Update the status as you progress through the application process.

## License

MIT
