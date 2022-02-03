# tracking-web-server!

Web server implemented in Java, Spring Boot.
/ping - returns response code 200 and string OK when file /tmp/ok is present, if file is not present returns 503 service unavailable
/img - returns a 1x1 gif image, and log the request

How to run
prerequisits are installed maven and java11
- navigate to tracking-web-server/webserver
- run "mvn spring-boot:run"

Test in separate console or in browser
localhost:8080/ping
localhost:8080/img

![webserver_img_response](https://user-images.githubusercontent.com/7190740/152264045-aeccbef6-ea62-44bd-b315-d11abca0cecc.JPG)
![webserver_ping_ok](https://user-images.githubusercontent.com/7190740/152264277-f25a3950-5e6d-4c4a-ae0b-924f5216bd83.JPG)
![webserver_ping_notok](https://user-images.githubusercontent.com/7190740/152264283-2c7438ee-03b7-4070-a4f3-08b9e8795945.JPG)
