* Using m3.medium instance
* EC2 will create SSH key, use puttygen for use with putty
* In EC2, add inbound rules for 8080, 22

* sudo yum install java-1.8.0-devel git docker
* sudo alternatives --config java
* git clone https://github.com/joeyslalom/spring-booty.git
* sudo service docker restart
* sudo usermod -a -G docker ec2-user
  * requires log out / log on
  * requires system reboot for reasons unknown (sudo reboot)
  * check with: docker info, ./gradlew buildDocker
  
 