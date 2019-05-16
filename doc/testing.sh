sudo fuser -k -n tcp 9030
nohup java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=15999  evaluation.jar --server.port=9030&
