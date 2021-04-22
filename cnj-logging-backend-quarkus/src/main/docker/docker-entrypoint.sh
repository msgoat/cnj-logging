#!/bin/sh

if [ "${WAIT_FOR_URLS}" -o "${WAIT_FOR_PORTS}" ]
then
	echo "Waiting for ..."
  /home/quarkus/wait-for.sh ${WAIT_FOR_ARGUMENTS}
fi

if [ "$1" = "start" ]
then
	echo "Running Quarkus application ..."
	java ${JAVA_OPTS} ${DOCKER_JAVA_OPTS} ${QUARKUS_JAVA_OPTS} -jar /home/quarkus/*.jar ${QUARKUS_ARGUMENTS}
else
	exec "$@"	
fi
