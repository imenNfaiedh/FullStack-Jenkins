pipeline {
    agent any

    tools {

        nodejs 'nodejs' // ' ' Le nom que vous avez donné à votre installation NodeJS dans Jenkins
        maven 'install maven' // Define Maven tool to be used
    }

    stages {
        stage("Clean up") {
            steps {
                deleteDir() // Clean up the workspace before starting
            }
        }

        stage("Checkout SCM") {
            steps {

                checkout scm

            }
        }

        stage('Build Frontend Angular') {
            steps {
                // Se déplacer dans le répertoire du frontend Angular
                dir("${env.WORKSPACE}/angular-app") {
                    // Installer les dépendances Angular
                    bat "npm install"

                    // Construire le projet Angular
                    bat "npm run build"
                }
            }
        }


        stage("Build Backend") {
            steps {
                // Navigate to the project directory and build the Maven project
                dir("${env.WORKSPACE}/tp4jenkins") {
                    bat "mvn clean install"
                }
            }
        }

//         stage("Build Docker Image") {
//             steps {
//                 // Build the Docker image using the Dockerfile
//                 dir("${env.WORKSPACE}") {
//                     bat "docker build -t backend ."
//                 }
//             }
//         }
//
//         stage("Run Docker Compose") {
//             steps {
//                 // Run Docker Compose to start the application
//                 dir("springboot-postgres-pipeline") {
//                     bat "docker compose up -d"
//                 }
//             }
//         }
//     }
}}
