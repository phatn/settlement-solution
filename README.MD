# Settlements Enrichment Application
## 0. Requires Maven, Java 11 and Node version >= 12

## I. Build backend service
1. cd to scripts
2. Execute **build-service.sh**

## II. Run backend service
1. Run with profile dev
Execute **run-service-dev.sh**
Memory database is accessible at **http://localhost:8080/h2-console**

2. Run with profile prod
a. Update database details (database name, username, password) in /settlement-service/src/main/resources/application-prod.yml
b. Run **schema.sql** and **data.sql** to init database
c. Execute **run-service-prod.sh**

3. Swagger UI can be ccessible at http://localhost:8080/swagger-ui/index.html

## III. Build and run web
Execute script **build-run-web-dev.sh** and **build-run-web-prod.sh** for profile dev and prod respectively, the web is accessible at http://localhost:3000/