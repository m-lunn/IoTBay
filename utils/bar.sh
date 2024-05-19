#!/bin/bash

cd ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/bin # Changes directory into server bin location

./shutdown.sh # Stops the server, if running.

rm -r ~/IoTBay/target # Remove project target folder to prevent Maven caching fuckery.

/Library/Maven/bin/mvn package -f ~/IoTBay/pom.xml # Package project into .war

rm -r ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/ROOT # Remove old deployment on server.

mv ~/IoTBay/target/IoTBay-1.0.war ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/IoTBay-1.0.war # Overwrites old deployment with new deployment.

./startup.sh # Starts the server.

cd ~/IoTBay/utils # Changes directory into IoTBay/utils

./serverlogs.sh # Opens and tracks server logs
