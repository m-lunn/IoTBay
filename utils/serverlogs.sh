cd ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/logs

logfile=`ls | grep catalina.$(date +%F)`

tail -f $logfile