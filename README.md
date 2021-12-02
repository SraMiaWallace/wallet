# Wallet 

Intrucciones para el deploy:

- Tipo: Maven

+ Swagger, que ofrece una interfaz para acceder a los métodos de forma más amigable, previo RUN del proyecto.
URL: http://localhost:8080
Además de los métodos solicitados se han creado métodos getAll() para todas las entidades para facilitar el acceso a los datos.

+ DB H2:
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:file:./db/wallet_h2
User: wallet_user
Pass: P@ssw0rd
Además en la carpeta de resources hay un script "scriptResetDB.txt" para restaurar la DB, dejando solo los datos por defecto.
