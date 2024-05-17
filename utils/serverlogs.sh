cd ~/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4/apache-tomcat-10.1.4/logs # Changes directory into server log folder.

logfile=`ls | grep catalina.$(date +%F)` # Finds the server logs for todays's date.

tail -f $logfile # Reads the server logs and keeps open to monitor for updates to server logs.