# Flight Reservation System
---
## Steps to deploy Application
1. Clone this repository
```shell
git clone https://github.com/shubhamkalsait/Flight-reservation.git
```

2. Install Mysql Server and create database
```shell
apt update -y
apt install mariadb-server -y
systemctl start mariadb
systemctl enable mariadb
systemctl status mariadb
mysql_secure_installation
mysql -uroot -p
>> create user linux identified by "Redhat";
>> grant all privileges on *.* to linux;
>> flush privileges;
>> create flightdb;
>> grant all privileges on flightdb.* to linux;
>> flush privileges;
>> exit
```

3. Deploy Backend
```shell
cd Flight-reservation
cd FlightReservationSystem
apt install openjdk-17-jdk -y
apt install maven -y
# vim application.properties
cp application.properties src/main/resources/
export DATASOURCE_URL="jdbc:mysql://localhost:3306/flightdb"
export DATASOURCE_USER="linux"
export DATASOURCE_PASSWORD="Redhat"
export FRONTEND_URL="http://localhost:80"
mvn clean package
java -jar target/flight*.jar
```

4. Deploy Frontend (open new tab)
```shell
cd Flight-reservation
cd frontend
apt install nodejs npm -y
vim .env
export VITE_API_URL=http://localhost:8080
npm install
npm run build
apt install apache2 -y
cp -rf dist/* /var/www/html/
systemctl start apache2
```

