🎸 GB_Shop - Guitar & Bass Management System
GB_Shop este o aplicatie backend dezvoltata in Spring Boot, conceputa pentru gestionarea inventarului unui magazin de instrumente muzicale. Proiectul pune accent pe o arhitectura robusta, utilizarea corecta a maparilor JPA si o strategie de testare riguroasa.

🚀 Tehnologii si Framework-uri
Java 21

Spring Boot 3.x

Spring Data JPA (Hibernate)

H2 Database 

PostgreSQL

Lombok

JUnit 5 & Mockito

Swagger/OpenAPI 

🏗️ Arhitectura Proiectului
Aplicatia urmeaza modelul Layered Architecture pentru a asigura separarea responsabilitatilor:

Web Layer (Controllers): Expunerea endpoint-urilor REST si gestionarea cererilor HTTP.

Service Layer (Services): Implementarea logicii de business, validarilor si transformarilor DTO.

Data Access Layer (Repositories): Interfata cu baza de date prin Spring Data JPA.

Model Layer (Entities): Definirea structurii bazei de date.

📊 Design-ul Bazei de Date
Mostenire (Inheritance Mapping)
Am utilizat strategia JOINED pentru ierarhia produselor, asigurand o structura normalizata si extensibila:

Product (Clasa de baza): Contine atribute comune (nume, pret, descriere).

StringInstrument (Extinde Product): Atribute specifice instrumentelor cu coarde.

Amplifier (Extinde Product): Atribute specifice amplificatoarelor (putere, tehnologie).

Relatii
Many-to-One: Fiecare produs este asociat unui Brand.

🧪 Strategia de Testare
Proiectul demonstreaza bune practici in asigurarea calitatii codului prin:

Unit Testing
Testarea izolata a serviciilor (BrandServiceTest).

Utilizarea Mockito pentru simularea straturilor de persistenta.

Verificarea scenariilor de tip Happy Path si Error Handling.

Integration Testing
Testarea fluxului complet (End-to-End) folosind MockMvc.

Configurarea unei baze de date H2 in-memory dedicata testelor (@AutoConfigureTestDatabase).

Validarea persistentei reale in baza de date prin verificarea numarului de inregistrari post-executie (repository.count()).

🛠️ Instalare si Utilizare
Cloneaza repository-ul:

git clone https://github.com/utilizator/GB_Shop.git

Configurare baza de date:
Asigura-te ca setarile din application.properties corespund mediului tau local.

Rulare aplicatie:
./mvnw spring-boot:run
Documentatie API:

Dupa pornire, Swagger UI poate fi accesat la: http://localhost:8080/swagger-ui/index.html

📝 Key Features Implementate
Validari Custom: 
Prevenirea duplicatelor prin logica de tip existsByName in stratul Service.

Mapping DTO: Utilizarea Java Records pentru un transfer de date eficient si imuabil.

RESTful API: Endpoint-uri complete pentru operatii CRUD pe entitatile principale.