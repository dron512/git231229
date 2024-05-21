kill $(pgrep -f "java -jar -Dserver.port=8181 /var/jenkins_home/workspace/sample/target/app.jar")
nohup java -jar -Dserver.port=8181 /var/jenkins_home/workspace/sample/target/app.jar &
