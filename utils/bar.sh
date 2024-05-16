#!/bin/bash

cd ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/bin

./shutdown.sh

rm -r ~/IoTBay/target/IoTBay-1.0-SNAPSHOT

rm -r ~/IoTBay/target/classes

/Library/Maven/bin/mvn package -f ~/IoTBay/pom.xml

rm -r ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/IoTBay-1.0-SNAPSHOT
rm ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/IoTBay-1.0-SNAPSHOT.war

mv ~/IoTBay/target/IoTBay-1.0-SNAPSHOT.war ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/IoTBay-1.0-SNAPSHOT.war

# cp ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/ROOT.war ~//IoTBay/target/

# mv ~/IoTBay/target/ROOT.war ~/IoTBay/target/IoTBay-1.0-SNAPSHOT.war

# rm -r ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/webapps/ROOT

./startup.sh

cd ~/IoTBay/utils

./serverlogs.sh
