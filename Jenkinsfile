pipeline {
    agent any

    tools {
        jdk 'jdk21'
    }

    environment {
        STUDENT_NAME = 'Aitkul Nurassyl'
        STUDENT_ID   = '37375'
        IMAGE_NAME   = 'aitkul-nurassyl-student-api'
        IMAGE_TAG    = 'v1.1-37375'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "Student: ${STUDENT_NAME}, ID: ${STUDENT_ID}"
                sh 'git log -1 --oneline'
            }
        }

        stage('Build') {
            steps {
                echo "Building Spring Boot application of ${STUDENT_NAME} with Gradle"
                sh 'chmod +x gradlew && ./gradlew clean assemble --no-daemon'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test --no-daemon'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} -t ${IMAGE_NAME}:build-${BUILD_NUMBER} ."
            }
        }

        stage('Verify') {
            steps {
                sh "docker image inspect ${IMAGE_NAME}:${IMAGE_TAG} --format 'Image exists: {{.Id}} | size {{.Size}} bytes'"
                sh "docker images ${IMAGE_NAME}"
                echo "Image ${IMAGE_NAME}:${IMAGE_TAG} is ready (student ${STUDENT_NAME})"
            }
        }
    }

    post {
        success {
            echo "Pipeline SUCCESS for ${STUDENT_NAME} (${STUDENT_ID})"
        }
        failure {
            echo "Pipeline FAILED for ${STUDENT_NAME} - see the failed stage above"
        }
    }
}
