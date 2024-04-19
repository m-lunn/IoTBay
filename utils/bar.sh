#!/bin/bash

cd /Users/michaellunn/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/bin

./shutdown.sh

/Library/Maven/bin/mvn package -f /Users/michaellunn/IoTBay/pom.xml

mv /Users/michaellunn/IoTBay/target/IoTBay-1.0-SNAPSHOT.war /Users/michaellunn/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/ROOT.war

cp /Users/michaellunn/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/ROOT.war /Users/michaellunn/IoTBay/target/

mv /Users/michaellunn/IoTBay/target/ROOT.war /Users/michaellunn/IoTBay/target/IoTBay-1.0-SNAPSHOT.war

rm -r /Users/michaellunn/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/ROOT

./startup.sh
