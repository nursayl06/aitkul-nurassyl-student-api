# Aitkul Nurassyl Student API

Student: Aitkul Nurassyl, group IT2-2307, Student ID 37375 (conflict resolved by Aitkul Nurassyl).

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
EOF
## API endpoints
- GET    /api/students        - all students
- GET    /api/students/{id}   - one student (404 if not found)
- POST   /api/students        - create a student
- PUT    /api/students/{id}   - update a student (added by Aitkul Nurassyl)
- DELETE /api/students/{id}   - delete a student
- GET    /api/info            - student information and app version

## Change log
- feature/aitkul-nurassyl-crud: Aitkul Nurassyl added the PUT operation to update a student.

## CI/CD
Jenkins job Aitkul_Nurassyl_Student_API runs Checkout, Build, Test, Docker Build and Verify.
It checks GitHub every minute (Poll SCM) and starts a build automatically after a new commit.
Automatic build test: commit pushed at 2026-10-28 22:30
