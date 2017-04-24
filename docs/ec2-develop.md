* sudo yum install java-1.8.0-devel git docker
* sudo alternatives --config java
* git clone https://github.com/joeyslalom/spring-booty.git
* sudo service docker restart
* sudo usermod -a -G docker ec2-user
  * requires log out / log on
  * requires system reboot for reasons unknown (sudo reboot)
  * check with: docker info, ./gradlew buildDocker
  