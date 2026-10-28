# Aitkul Nurassyl Student API

Student: Aitkul Nurassyl, IT2-2307, Student ID 37375 - main branch version.

A Spring Boot CRUD application for students with PostgreSQL,
Docker, Docker Compose and Jenkins CI/CD (DevOps midterm).

## API endpoints
- GET    /api/students        - all students
- GET    /api/students/{id}   - one student (404 if not found)
- POST   /api/students        - create a student
- PUT    /api/students/{id}   - update a student (added by Aitkul Nurassyl)
- DELETE /api/students/{id}   - delete a student
- GET    /api/info            - student information and app version

## Change log
- feature/aitkul-nurassyl-crud: Aitkul Nurassyl added the PUT operation to update a student.
