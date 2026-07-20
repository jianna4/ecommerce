
# this is your example mysql.properties

spring.datasource.url=jdbc:mysql://localhost:3306/store?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=store_app or your password
spring.datasource.password=Store@2026 or your password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
# make sure to also create thedatabase