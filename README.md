spring-boot-zk
==============

POC of Spring Boot and ZKoss and Spring Security with custom Login screen.

After checkout, just execute :

```
mvn spring-boot:run
```

Or simply :

```
git clone https://github.com/juminrubin/spring-boot-zk.git
cd spring-boot-zk/
mvn mvn spring-boot:run
firefox http://localhost:8080/
# Enjoy ;-D
```

and go to http://localhost:8080/ 

The spring security authentication with custom login.zul and LoginController.java. Sample authorization - user / organization / pw:   ```user / org / pass1234```

See index.zul and it's VM:  IndexVM.java.

Enhanced and modified from: https://github.com/guillefritz/spring-boot-zk
