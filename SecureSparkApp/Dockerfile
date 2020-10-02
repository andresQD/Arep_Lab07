FROM openjdk:8

WORKDIR /usrapp/bin

ENV PORT 6000

COPY SecureSparkApp/target/classes /usrapp/bin/classes
COPY SecureSparkApp/target/dependency /usrapp/bin/dependency

COPY SecureSparkApp/keystores /usrapp/bin/SecureSparkApp/keystores
COPY OtherServiceArep/keystores /usrapp/bin/OtherServiceArep/keystores

CMD ["java","-cp","./classes:./dependency/*","co.edu.eci.arep.securesparkapp.SecureSparkServicesApp"]

