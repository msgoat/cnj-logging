#!/bin/sh

if [ "$1" = "start" ]
then
	echo "Running Payara Microprofile application ..."
	if [ "$PAYARA_LOGGING_FORMAT" = "JSON" ]
	then
	  PAYARA_ARGUMENTS="${PAYARA_ARGUMENTS} --logProperties /home/payara/logging.properties"
	fi
	echo "JAVA_OPTS: ${JAVA_OPTS}"
	echo "DOCKER_JAVA_OPTS: ${DOCKER_JAVA_OPTS}"
	echo "PAYARA_JAVA_OPTS: ${PAYARA_JAVA_OPTS}"
	echo "PAYARA_ARGUMENTS: ${PAYARA_ARGUMENTS}"
	java ${JAVA_OPTS} ${DOCKER_JAVA_OPTS} ${PAYARA_JAVA_OPTS} -jar /home/payara/*.jar ${PAYARA_ARGUMENTS}
else 
	exec "$@"	
fi
